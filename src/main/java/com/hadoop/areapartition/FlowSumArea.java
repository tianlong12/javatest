package com.hadoop.areapartition;


import com.hadoop.flowsum.FlowBean;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


/**
 *对流量进行统计，不同的地区写入不同的文件
 *1.改造原来分区的逻辑，自定义partitioner
 *2.自定义reduce的并发数
 *
 *
 * 
 * @author duanhaitao@itcast.cn
 *
 */
public class FlowSumArea {

	public static class FlowSumAreaMapper extends Mapper<LongWritable, Text, Text, FlowBean>{
		
		@Override
		protected void map(LongWritable key, Text value,Context context)
				throws IOException, InterruptedException {

			//��һ������
			String line = value.toString();
			//�зֳɸ����ֶ�
			String[] fields = StringUtils.split(line, "\t");
			
			//�õ�������Ҫ���ֶ�
			String phoneNB = fields[1];
			long u_flow = Long.parseLong(fields[7]);
			long d_flow = Long.parseLong(fields[8]);
			
			//��װ����Ϊkv�����
			context.write(new Text(phoneNB), new FlowBean(phoneNB,u_flow,d_flow));

		}
		
		
	}
	
	
	public static class FlowSumAreaReducer extends Reducer<Text, FlowBean, Text, FlowBean>{
		
		@Override
		protected void reduce(Text key, Iterable<FlowBean> values,Context context)
				throws IOException, InterruptedException {

			long up_flow_counter = 0;
			long d_flow_counter = 0;
			
			for(FlowBean bean: values){
				
				up_flow_counter += bean.getUp_flow();
				d_flow_counter += bean.getD_flow();
				
				
			}
			
			context.write(key, new FlowBean(key.toString(), up_flow_counter, d_flow_counter));
			
			
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(FlowSumArea.class);
		
		job.setMapperClass(FlowSumAreaMapper.class);
		job.setReducerClass(FlowSumAreaReducer.class);
		
		//设置分组策略
		job.setPartitionerClass(AreaPartitioner.class);
		
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);
		
		//设置reducer的并发数，应该跟分组策略一样，如果并发数多于分组数量，不会报错，只是多余的reducer会输出空文件，但是并发数少于分组策略，会报错，
		//因为找不到合适的reducer来执行操作
		job.setNumReduceTasks(6);
		
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		
		System.exit(job.waitForCompletion(true)?0:1);
		
		
	}
	
	
}
