package com.colorcc.sample.proxy;

import java.lang.reflect.InvocationTargetException;

import com.colorcc.sample.proxy.service.HelloService;
import com.colorcc.sample.proxy.service.impl.HelloServiceImpl;

public class ProxyMain {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
//		objProxy();
		HelloService hs = new HelloServiceImpl();
		JdkFactoryProxy factory = new JdkFactoryProxy();
		HelloService proxy = (HelloService)factory.getProxy(hs, HelloService.class);
		
		HelloService proxy2 = (HelloService)factory.getProxy(HelloService.class);
		
		System.out.println(proxy.hello());
//		MethodInfo mi = (MethodInfo)proxy2.hello();
		System.out.println(proxy2.hello("Jack", 20) + "");
	}

	@SuppressWarnings("unused")
	private static void objProxy() throws IllegalAccessException, InvocationTargetException {
		HelloService hs = new HelloServiceImpl();
		
		CProxy<HelloService> cp = new CProxy<>();
		cp.setType(HelloService.class);
		cp.setRef(hs);
		
		
//		Class<?>[] types = {String.class};
//		Object[] objs = {"test"};
//		Class<?> returnType = String.class;
		
//		Class<?>[] types = {};
//		Object[] objs = {};
		
		Class<?>[] types = {String.class, Integer.class};
		Object[] objs = {"jack", 20};
		Class<?> returnType = Integer.class;
		System.out.println(cp.invoke(cp.getProxy(), "hello", types, objs, returnType));
	}

}
