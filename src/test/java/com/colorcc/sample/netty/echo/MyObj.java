package com.colorcc.sample.netty.echo;

import java.io.Serializable;
import java.util.List;

public class MyObj implements Serializable {
	private static final long serialVersionUID = 6413146015308533281L;
	
	private String name;
	private int age;
	private List<String> attrs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getAttrs() {
		return attrs;
	}
	public void setAttrs(List<String> attrs) {
		this.attrs = attrs;
	}
	
	public String toString() {
		return "MyObj: " + this.getAge() + ", " + this.getName() + ", " + this.getAttrs();
	}
	
	

}
