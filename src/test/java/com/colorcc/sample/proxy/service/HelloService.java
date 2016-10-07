package com.colorcc.sample.proxy.service;


public interface HelloService {

	public String hello();

	public String hello(String name);

	public String hello(Integer age);

	public Integer hello(String name, Integer age);

}
