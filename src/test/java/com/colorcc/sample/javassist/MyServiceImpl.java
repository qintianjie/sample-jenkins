package com.colorcc.sample.javassist;

public class MyServiceImpl implements MyService {
	@Override
	public String sayHello() {
		return "Hello default";
	}

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}
	
	public void hello() {
		System.out.println("Hello hello");
	}
	
	public void finalize() {
		
	}

}
