package com.colorcc.sample.proxy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyQueue {
	private static BlockingQueue<String> q = new LinkedBlockingQueue<>();
	
	public static BlockingQueue<String> getQueue() {
		return q;
	}
}
