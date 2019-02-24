package com.hadoop.flowsum;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class FlowBean implements WritableComparable<FlowBean>{
	
	
	private String phoneNB;
	private long up_flow;
	private long d_flow;
	private long s_flow;
	
	//反序列化的时候会使用反射，需要一个空的构造函数
	public FlowBean(){}
	

	public FlowBean(String phoneNB, long up_flow, long d_flow) {
		this.phoneNB = phoneNB;
		this.up_flow = up_flow;
		this.d_flow = d_flow;
		this.s_flow = up_flow + d_flow;
	}

	public String getPhoneNB() {
		return phoneNB;
	}

	public void setPhoneNB(String phoneNB) {
		this.phoneNB = phoneNB;
	}

	public long getUp_flow() {
		return up_flow;
	}

	public void setUp_flow(long up_flow) {
		this.up_flow = up_flow;
	}

	public long getD_flow() {
		return d_flow;
	}

	public void setD_flow(long d_flow) {
		this.d_flow = d_flow;
	}

	public long getS_flow() {
		return s_flow;
	}

	public void setS_flow(long s_flow) {
		this.s_flow = s_flow;
	}

	
	
	//序列化
	@Override
	public void write(DataOutput out) throws IOException {

		out.writeUTF(phoneNB);
		out.writeLong(up_flow);
		out.writeLong(d_flow);
		out.writeLong(s_flow);
		
	}

	
	//反序列化

	@Override
	public void readFields(DataInput in) throws IOException {

		phoneNB = in.readUTF();
		up_flow = in.readLong();
		d_flow = in.readLong();
		s_flow = in.readLong();
		
	}
	
	
	@Override
	public String toString() {

		return "" + up_flow + "\t" +d_flow + "\t" + s_flow;
	}

	@Override
	public int compareTo(FlowBean o) {
		return s_flow>o.getS_flow()?-1:1;
	}
	

}
