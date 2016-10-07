package com.colorcc.sample.proxy;

public interface FactoryProxy {
	Object getProxy(Class<?> interfaceName);
	Object getProxy(final Object objImpl, Class<?> interfaceName);

}
