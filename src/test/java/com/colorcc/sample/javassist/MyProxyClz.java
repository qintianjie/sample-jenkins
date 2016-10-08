package com.colorcc.sample.javassist;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyObject;
import javassist.util.proxy.RuntimeSupport;

public class MyProxyClz extends MyServiceImpl implements Serializable, ProxyObject {
	
	/*
	 * // handler is per instance
        FieldInfo finfo2 = new FieldInfo(pool, HANDLER, HANDLER_TYPE);
        finfo2.setAccessFlags(AccessFlag.PRIVATE);
        cf.addField(finfo2);
	 */
	private MethodHandler handler;
	public void setHandler(MethodHandler paramMethodHandler) {
		this.handler = paramMethodHandler;
	}

	public MethodHandler getHandler() {
		return this.handler;
	}
	
	/*
	 * // filter signature is per class
        FieldInfo finfo3 = new FieldInfo(pool, FILTER_SIGNATURE_FIELD, FILTER_SIGNATURE_TYPE);
        finfo3.setAccessFlags(AccessFlag.PUBLIC | AccessFlag.STATIC);
        cf.addField(finfo3);
	 */
	public static byte[] _filter_signature;
	
	/*
        // the proxy class serial uid must always be a fixed value
        FieldInfo finfo4 = new FieldInfo(pool, SERIAL_VERSION_UID_FIELD, SERIAL_VERSION_UID_TYPE);
        finfo4.setAccessFlags(AccessFlag.PUBLIC | AccessFlag.STATIC| AccessFlag.FINAL);
        cf.addField(finfo4);
	 */
	public static final long serialVersionUID = -1L;
	private static Method[] _methods_;
	
	static {
		Method[] arrayOfMethod = new Method[26];
		try {
			Class<?> localClass = Class.forName("com.colorcc.sample.javassist.MyProxyClz");
			RuntimeSupport.find2Methods(localClass, "clone", "_d0clone", 0, "()Ljava/lang/Object;", arrayOfMethod);
			RuntimeSupport.find2Methods(localClass, "equals", "_d1equals", 2, "(Ljava/lang/Object;)Z", arrayOfMethod);
			RuntimeSupport.find2Methods(localClass, "hashCode", "_d4hashCode", 8, "()I", arrayOfMethod);
			RuntimeSupport.find2Methods(localClass, "sayHello", "_d7sayHello", 14, "()Ljava/lang/String;", arrayOfMethod);
			RuntimeSupport.find2Methods(localClass, "sayHello", "_d8sayHello", 16, "(Ljava/lang/String;)Ljava/lang/String;", arrayOfMethod);
			RuntimeSupport.find2Methods(localClass, "toString", "_d9toString", 18, "()Ljava/lang/String;", arrayOfMethod);
			_methods_ = arrayOfMethod;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	

	Object writeReplace() throws ObjectStreamException {
		return RuntimeSupport.makeSerializedProxy(this);
	}

	public final Object _d0clone() throws CloneNotSupportedException {
		return super.clone();
	}

	protected final Object clone() {
		Method[] arrayOfMethod = _methods_;
		try {
			return (Object) this.handler.invoke(this, arrayOfMethod[0], arrayOfMethod[1], new Object[0]);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public final boolean _d1equals(Object paramObject) {
		return super.equals(paramObject);
	}

	public final boolean equals(Object paramObject) {
		Method[] arrayOfMethod = _methods_;
		try {
			return ((Boolean) this.handler.invoke(this, arrayOfMethod[2], arrayOfMethod[3], new Object[] { paramObject })).booleanValue();
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}
	}

	public final int _d4hashCode() {
		return super.hashCode();
	}

	public final int hashCode() {
		Method[] arrayOfMethod = _methods_;
		try {
			return ((Integer) this.handler.invoke(this, arrayOfMethod[8], arrayOfMethod[9], new Object[0])).intValue();
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	}

	public final String _d7sayHello() {
		return super.sayHello();
	}

	public final String sayHello() {
		Method[] arrayOfMethod = _methods_;
		try {
			return (String) this.handler.invoke(this, arrayOfMethod[14], arrayOfMethod[15], new Object[0]);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public final String _d8sayHello(String paramString) {
		return super.sayHello(paramString);
	}

	public final String sayHello(String paramString) {
		Method[] arrayOfMethod = _methods_;
		try {
			return (String) this.handler.invoke(this, arrayOfMethod[16], arrayOfMethod[17], new Object[] { paramString });
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

	public final String _d9toString() {
		return super.toString();
	}

	public final String toString() {
		Method[] arrayOfMethod = _methods_;
		try {
			return (String) this.handler.invoke(this, arrayOfMethod[18], arrayOfMethod[19], new Object[0]);
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
}
