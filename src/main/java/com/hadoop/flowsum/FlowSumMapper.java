package com.hadoop.flowsum;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


/**
 * FlowBean 需要符合Hadoop的序列化机制
 *
 */
public class FlowSumMapper extends Mapper<LongWritable, Text, Text, FlowBean>{

	

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {


		String line = value.toString();
		//切分
		String[] fields = StringUtils.split(line, "\t");
		
		//分别得到手机号，上行下行流量
		String phoneNB = fields[1];
		long u_flow = Long.parseLong(fields[7]);
		long d_flow = Long.parseLong(fields[8]);
		
		//分发
		context.write(new Text(phoneNB), new FlowBean(phoneNB,u_flow,d_flow));
		
	}
	
	
}
