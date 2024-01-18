package com.zumba.bean;

public class batch {
	private int batchid;
	private String typeofbatch;
	private String time;
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	public String getTypeofbatch() {
		return typeofbatch;
	}
	public void setTypeofbatch(String typeofbatch) {
		this.typeofbatch = typeofbatch;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public batch(int batchid, String typeofbatch, String time) {
		super();
		this.batchid = batchid;
		this.typeofbatch = typeofbatch;
		this.time = time;
	}
	
	
}
