package com.colorcc.sample.proxy;

import com.alibaba.fastjson.JSON;

public class Request {
	@SuppressWarnings("unused")
	private String req;
	private String resp;
	public Request(String req) {
		this.req = req;
	}
	
	public String getResp() {
		return resp;
	}
	public void setResp(String resp) {
		this.resp = resp;
	}
	public Object getReqest() {
		return JSON.parse(resp);
	}

}
