package com.hadoop.mr.wordcount;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * 描述一个任务
 * 指定任务类，以及输入输出路径

 * @author duanhaitao@itcast.cn
 *
 */
public class WCRunner {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		
		Job wcjob = Job.getInstance(conf);
		

		wcjob.setJarByClass(WCRunner.class);
		
		

		wcjob.setMapperClass(WCMapper.class);
		wcjob.setReducerClass(WCReducer.class);
		
		

		wcjob.setOutputKeyClass(Text.class);
		wcjob.setOutputValueClass(LongWritable.class);
		

		wcjob.setMapOutputKeyClass(Text.class);
		wcjob.setMapOutputValueClass(LongWritable.class);
		
		

		FileInputFormat.setInputPaths(wcjob, new Path("hdfs://weekend110:9000/wc/srcdata/"));
		

		FileOutputFormat.setOutputPath(wcjob, new Path("hdfs://weekend110:9000/wc/output3/"));
		

		wcjob.waitForCompletion(true);
		
		
	}
	
	
	
	
}
