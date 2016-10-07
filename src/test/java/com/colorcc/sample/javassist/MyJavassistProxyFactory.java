package com.colorcc.sample.javassist;

import java.io.Serializable;
import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

public class MyJavassistProxyFactory {

	public static void main(String[] args) throws Exception {
		ProxyFactory f = new ProxyFactory();
		f.setSuperclass(MyServiceImpl.class);
		Class<?>[] infs = { MyInf.class, Serializable.class };
		f.setInterfaces(infs);
		f.writeDirectory = "d:\\logs";
		f.setFilter(new MethodFilter() {
			@Override
			public boolean isHandled(Method m) {
				return !m.getName().equals("finalize");
			}
		});

		Class<?> c = f.createClass();

		MyService ms = (MyService) c.newInstance();
		((Proxy) ms).setHandler(new MethodHandler() {
			@Override
			public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
				// System.out.println("Name : " + thisMethod.getName());
				System.out.println("--------------------------------");
				System.out.println(self.getClass());

				// class com.javassist.demo.A_$$_javassist_0
				System.out.println("要调用的方法名：" + thisMethod.getName());
				System.out.println(proceed.getName());
				System.out.println("开启事务-------");

				Object result = proceed.invoke(self, args);
				// 下面的代码效果与上面的相同
				// 不过需要传入一个目标对象
				// Object result = thismethod.invoke(target,args);

				System.out.println("提交事务-------");
				return result;
			}
		});
		
		MyInf mi = (MyInf) ms;
		mi.hello();
		
//		MyInf mi = (MyInf) c.newInstance();
//		mi.hello();

		
		System.out.println(ms.sayHello("Jack."));

		// ClassPool pool = ClassPool.getDefault();
		// CtClass cc = pool.get(MyService.class.getName());
		// cc.setSuperclass(pool.get(Object.class.getName()));
		// // cc.setSuperclass(pool.get("test.Point"));
		// cc.writeFile("d:/logs");
	}

}
