package com.countdownlatch.example;

import java.util.concurrent.CountDownLatch;

public class MainService {

	public static void main(String args[]) {
		CountDownLatch latch = new CountDownLatch(3);
		try {
			Service service1 = new Service(latch, "Service 1");
			Service service2 = new Service(latch, "Service 2");
			Service service3 = new Service(latch, "Service 3");
			
			Thread thread1 = new Thread(service1);
			Thread thread2 = new Thread(service2);
			Thread thread3 = new Thread(service3);
			
			thread1.start();
			thread2.start();
			thread3.start();
			
			latch.await();
			
			System.out.println("Main Service Started Successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
