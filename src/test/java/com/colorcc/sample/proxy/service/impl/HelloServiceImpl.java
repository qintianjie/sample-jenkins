package com.colorcc.sample.proxy.service.impl;

import com.colorcc.sample.proxy.service.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String hello() {
		String msg = "hello jack";
//		System.out.println(msg);
		return msg;
	}

	@Override
	public String hello(String name) {
		String msg = "hello " + name;
//		System.out.println(msg);
		return msg;
	}

	@Override
	public String hello(Integer age) {
		
		String msg = "hello " + age;
		return msg;
	}

	@Override
	public Integer hello(String name, Integer age) {
		String msg = "hello " + name + ", " + age;
		System.out.println(msg);
		return age;
	}

}
