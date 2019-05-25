package com.countdownlatch.example2;

import java.util.concurrent.CountDownLatch;

public class FoodOrder {

	public static void main(String[] args) {
		String items[] = new String[3];
		items[0] = "Pizza";
		items[1] = "Burger";
		items[2] = "Fresh lime";
		CountDownLatch latch = new CountDownLatch(items.length);
		try {
			Thread thread = new Thread(new OrderProcess(latch, items));
			thread.start();
			latch.await();
			System.out.println("Completed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
