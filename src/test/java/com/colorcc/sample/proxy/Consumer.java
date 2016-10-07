package com.colorcc.sample.proxy;
public class Consumer implements Runnable {
	public void run() {
		try {
			while (true) {
				consume(MyQueue.getQueue().take());
			}
		} catch (InterruptedException ex) {
		}
	}

	void consume(String e) {
		System.out.println("cons: " + e);
	}

}
