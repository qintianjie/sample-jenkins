package com.colorcc.sample.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkFactoryProxy<T> implements FactoryProxy {
	@Override
	public Object getProxy(final Object impl, Class<?> interfaceName) {
		Class<?>[] ifs = {interfaceName};
		Object proxy = Proxy.newProxyInstance(interfaceName.getClassLoader(), ifs, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.invoke(impl, args);
			}});
		return proxy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getProxy(Class<?> interfaceName) {
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[] {interfaceName}, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Base1 b1 = new Base1(this, method, args);
						return b1.invokeMethod();
					}
			
		});
		
		
//		final Class<?>[] ifs = {interfaceName};
//		Object proxy = Proxy.newProxyInstance(interfaceName.getClassLoader(), ifs, new InvocationHandler() {
//			@Override
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				MethodInfo mi = new MethodInfo();
//				mi.setMethod(method);
//				mi.setArgs(args);
//				return JSON.toJSONString(mi);
//			}});
//		return proxy;
	}

}
