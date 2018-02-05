package com.hadoop.ii;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


/**
 *倒排索引，实现的结果是可以统计不同文件中单词出现的个数
 * 第一步，及时将
 */
public class InverseIndexStepOne {
	
	
	
	public static class StepOneMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
		
		@Override
		protected void map(LongWritable key, Text value,Context context)
				throws IOException, InterruptedException {


			String line = value.toString();
			//�зֳ���������
			String[] fields = StringUtils.split(line, " ");
			
			//得到切片
			FileSplit inputSplit = (FileSplit) context.getInputSplit();
			//得到文件名（由此看来，一个文件可以有多个切片，但是一个切片不能包含多个文件）
			String fileName = inputSplit.getPath().getName();
			
			for(String field:fields){
				

				context.write(new Text(field+"-->"+fileName), new LongWritable(1));
				
			}
			
		}
		
		
	}
	
	
	public static class StepOneReducer extends Reducer<Text, LongWritable, Text, LongWritable>{
		
		// <hello-->a.txt,{1,1,1....}>
		@Override
		protected void reduce(Text key, Iterable<LongWritable> values,Context context)
				throws IOException, InterruptedException {

			long counter = 0;
			for(LongWritable value:values){
				
				counter += value.get();
				
			}
			
			context.write(key, new LongWritable(counter));
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();	
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(InverseIndexStepOne.class);
		
		job.setMapperClass(StepOneMapper.class);
		job.setReducerClass(StepOneReducer.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		
		//如果输出文件存在，删掉
		Path output = new Path(args[1]);
		FileSystem fs = FileSystem.get(conf);
		if(fs.exists(output)){
			fs.delete(output, true);
		}
		
		FileOutputFormat.setOutputPath(job, output);
		
		System.exit(job.waitForCompletion(true)?0:1);
		
		
	}

}
