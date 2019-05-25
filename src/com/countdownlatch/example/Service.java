package com.countdownlatch.example;

import java.util.concurrent.CountDownLatch;

public class Service implements Runnable {

	private final String name;
	private final CountDownLatch latch;

	public Service(final CountDownLatch latch, String name) {
		this.latch = latch;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			System.out.println(name + " Starting...");
			Thread.sleep(5000);
			System.out.println(name + " Started");
			latch.countDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
