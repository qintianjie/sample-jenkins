package com.colorcc.sample.netty.seri;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SeriObject implements Serializable {
	private static final long serialVersionUID = 3038510513323041576L;
	private String name;
	private int age;
	private Map<String, String> map;
	private List<String> list;
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
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
}
