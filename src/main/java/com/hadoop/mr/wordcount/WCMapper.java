package com.hadoop.mr.wordcount;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//4个泛型，前两个是输入类型，后两个是输出类型
//mr以key-value形式进行
//mapper的输入数据，key是一行的起始偏移量，这一行的内容是value
//LongWritable, Text是对long,String的序列化封装
public class WCMapper extends Mapper<LongWritable, Text, Text, LongWritable>{
	
	//map每读一行，调用一次此方法
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {

		
		//将内容转为String
		String line = value.toString();
		

		String[] words = StringUtils.split(line, " ");
		

		for(String word : words){
			
			context.write(new Text(word), new LongWritable(1));
			
		}
		

	}

	
	
}
