package com.countdownlatch.example2;

import java.util.concurrent.CountDownLatch;

public class OrderProcess implements Runnable {

	private final String[] items;
	private final CountDownLatch latch;

	public OrderProcess(final CountDownLatch latch, final String[] items) {
		this.latch = latch;
		this.items = items;
	}

	@Override
	public void run() {
		try {
			for (String item : items) {
				System.out.println(item + " Preparing");
				Thread.sleep(10000);
				System.out.println(item + " Prepared");
				latch.countDown();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
