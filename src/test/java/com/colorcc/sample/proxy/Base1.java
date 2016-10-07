package com.colorcc.sample.proxy;

import java.lang.reflect.Method;

import com.alibaba.fastjson.JSON;

public class Base1 {

	private Method method;
	private Object[] args;
	
	public Base1(Object proxy, Method method, Object[] args) {
		this.method = method;
		this.args = args;
	}
	
	public Object invokeMethod() {
		try {
			MethodInfo mi = new MethodInfo();
			mi.setMethod(method);
			mi.setArgs(args);
			
			String request = JSON.toJSONString(mi);
//			send(request);
			Producer producer = new Producer();
			producer.setValue(request);
			producer.run();
			
			
			return new Request(request).getReqest();
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void send(String request) {
		System.out.println("send reqest ...");
		MyQueue.getQueue().add(request);
	}
	
	Object getResult(String request) {
		
		
		return null;
	}

}
