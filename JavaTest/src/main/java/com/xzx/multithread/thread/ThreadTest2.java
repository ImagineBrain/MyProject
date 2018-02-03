package com.xzx.multithread.thread;

import java.util.ArrayDeque;
import java.util.Queue;

public class ThreadTest2 {

	public static int size = 20;
	public static Queue<Integer> queue = new ArrayDeque<Integer>(20);

	class Producer implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					if (queue.size() < size) {
						// TODO Auto-generated method stub
						int e = queue.size() + 1;
						queue.add(e);
						System.out.println("生成数据:" + e);
						if (queue.size() == size) {
							System.out.println("资源满了，唤醒消费者");
							queue.notify();
						}
					} else {
						try {
							System.out.println("资源满了，等待");
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	class Consumer implements Runnable {

		@Override
		public void run() {
			while (true) {
				synchronized (queue) {
					if (!queue.isEmpty()) {
						// TODO Auto-generated method stub
						System.out.println("消耗数据:" + queue.poll());
						if (queue.isEmpty()) {
							System.out.println("资源没了，唤醒生产者");
							queue.notify();
						}
					} else {
						try {
							System.out.println("资源没了，等待");
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest2 test2 = new ThreadTest2();
		Producer producer = test2.new Producer();
		Consumer consumer = test2.new Consumer();
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
	}
}
