package com.colorcc.sample.proxy;

import java.util.Queue;

public class ProAndCon {
	
	private Queue<String> queue;
	public ProAndCon(Queue<String> queue) {
		this.queue = queue;
	}
	
	public void prod(String item) {
		queue.offer(item);
	}
	
	

	public static void main(String[] args) {

	}

}
