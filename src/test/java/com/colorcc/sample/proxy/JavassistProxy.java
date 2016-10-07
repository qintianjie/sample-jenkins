package com.colorcc.sample.proxy;

import java.io.Serializable;
import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

public class JavassistProxy<T> {

	private Class<T> interfaceClass;

	public Class<T> getInterfaceClass() {
		return interfaceClass;
	}

	public void setInterfaceClass(Class<T> interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public T getClazz() {
		ProxyFactory f = new ProxyFactory();

		f.setInterfaces(new Class<?>[] { getInterfaceClass(), Serializable.class });
		f.setSuperclass(Base1.class);
		
		f.setFilter(new MethodFilter(){
			@Override
			public boolean isHandled(Method m) {
				return true;
			}
		});
		
		@SuppressWarnings("unchecked")
		T c = (T)f.createClass();
		((Proxy) c).setHandler(new MethodHandler(){

			@Override
			public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
				return null;
			}
			
		});
		
		

		return null;
	}

	/*
	 * ProxyFactory f = new ProxyFactory();
	 * f.setSuperclass(MyServiceImpl.class); Class<?>[] infs = { MyInf.class,
	 * Serializable.class }; f.setInterfaces(infs); f.writeDirectory =
	 * "d:\\logs"; f.setFilter(new MethodFilter() {
	 * 
	 * @Override public boolean isHandled(Method m) { return
	 * !m.getName().equals("finalize"); } });
	 * 
	 * Class<?> c = f.createClass();
	 * 
	 * MyService ms = (MyService) c.newInstance(); ((Proxy) ms).setHandler(new
	 * MethodHandler() {
	 */

}
