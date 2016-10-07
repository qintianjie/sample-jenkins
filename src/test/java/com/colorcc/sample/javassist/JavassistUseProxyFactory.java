package com.colorcc.sample.javassist;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.ProxyFactory;

public class JavassistUseProxyFactory {
	  private static final String WRITE_REPLACE_METHOD = "writeReplace";

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ProxyFactory factory = new ProxyFactory ();
		factory.setSuperclass(JavassistClassSampleSuper.class);
		
		factory.setFilter(new MethodFilter(){
			@Override
			public boolean isHandled(Method m) {
				return m.getName().equals("getName");
			}
		});
		
		/*
		 *  Object obj = create(paramTypes, args);
        ((Proxy)obj).setHandler(mh);
        return obj;
        
        factory.setHandler(new MehtodHandler(){});
		 */
		
		Class<?> c = factory.createClass();
		
		JavassistClassSampleSuper jcs = (JavassistClassSampleSuper) c.newInstance();
		System.out.println("jcs: " + jcs.getName());
		
		
	}
	
//	static Object crateProxy(Class<?> type, MethodHandler callback, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
//
//	    ProxyFactory enhancer = new ProxyFactory();
//	    enhancer.setSuperclass(type);
//
//	    try {
//	      type.getDeclaredMethod(WRITE_REPLACE_METHOD);
//	      // ObjectOutputStream will call writeReplace of objects returned by writeReplace
//	    } catch (NoSuchMethodException e) {
//	      enhancer.setInterfaces(new Class[]{WriteReplaceInterface.class});
//	    } catch (SecurityException e) {
//	      // nothing to do here
//	    }
//
//	    Object enhanced = null;
//	    Class<?>[] typesArray = constructorArgTypes.toArray(new Class[constructorArgTypes.size()]);
//	    Object[] valuesArray = constructorArgs.toArray(new Object[constructorArgs.size()]);
//	    try {
//	      enhanced = enhancer.create(typesArray, valuesArray);
//	    } catch (Exception e) {
//	      throw new ExecutorException("Error creating lazy proxy.  Cause: " + e, e);
//	    }
//	    ((Proxy) enhanced).setHandler(callback);
//	    return enhanced;
//	  }

}
