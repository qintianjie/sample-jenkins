package com.colorcc.sample.proxy;


public class Producer implements Runnable {
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void run() {
		try {
//			while (true) {
//				System.out.println("produce ==> " + getValue());
//				MyQueue.getQueue().put(getValue());
//			}
			System.out.println("produce ==> " + getValue());
			MyQueue.getQueue().put(getValue());
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}
