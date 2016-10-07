package com.colorcc.sample.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IProxy<T> {

	private Class<T> type;

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

//	@SuppressWarnings("unchecked")
//	public T getProxy() {
//
////		if (type.isAssignableFrom(ref.getClass())) {
////			return (T) ref;
////		}
//
//		return null;
//
//	}

	public Object invoke(T obj, String methodName, Class<?>[] paramsType, Object[] paramsValue, Class<?> returnType) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 参数输入判断
		if (paramsType.length != paramsValue.length) {
			return null;
		}
		Method[] methods = type.getMethods();
		for (Method m : methods) {
			if (m.getName().equals(methodName)) {
				// return type equal
				Class<?> rt = m.getReturnType();
				if (rt.getName().equals(returnType.getName())) {
					Class<?>[] pts = m.getParameterTypes();
					// method name equal
					// params lenth equal
					if (pts.length == paramsType.length) {
						boolean isMatch = true;
						for (int i = 0; i < pts.length; i++) {
							// each param type equal
							if (!pts[i].getName().equals(paramsType[i].getName())) {
								isMatch = false;
								break;
							}
						}

						if (isMatch) {
							return m.invoke(obj, paramsValue);
						}
					}
				}
			}
		}

		return null;
	}

}
