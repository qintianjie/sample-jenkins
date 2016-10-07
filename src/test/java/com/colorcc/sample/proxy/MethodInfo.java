package com.colorcc.sample.proxy;

import java.io.Serializable;
import java.lang.reflect.Method;

public class MethodInfo implements Serializable {

	private static final long serialVersionUID = -4651427816593429022L;
	
	private Method method;
	private Object[] args;
	public Method getMethod() {
		return method;
	}
	public void setMethod(Method method) {
		this.method = method;
	}
	public Object[] getArgs() {
		return args;
	}
	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	
	
	
	
//	private String methodName;
//	private Class<?>[] type;
//	private Class<?>[] paramType;
//	private Object[] paramValue;
//	private Class<?> returnType;
//	private Object returnValue;
//	public String getMethodName() {
//		return methodName;
//	}
//	public void setMethodName(String methodName) {
//		this.methodName = methodName;
//	}
//	public Class<?>[] getType() {
//		return type;
//	}
//	public void setType(Class<?>[] type) {
//		this.type = type;
//	}
//	public Class<?>[] getParamType() {
//		return paramType;
//	}
//	public void setParamType(Class<?>[] paramType) {
//		this.paramType = paramType;
//	}
//	public Object[] getParamValue() {
//		return paramValue;
//	}
//	public void setParamValue(Object[] paramValue) {
//		this.paramValue = paramValue;
//	}
//	public Class<?> getReturnType() {
//		return returnType;
//	}
//	public void setReturnType(Class<?> returnType) {
//		this.returnType = returnType;
//	}
//	public Object getReturnValue() {
//		return returnValue;
//	}
//	public void setReturnValue(Object returnValue) {
//		this.returnValue = returnValue;
//	}

	

}
