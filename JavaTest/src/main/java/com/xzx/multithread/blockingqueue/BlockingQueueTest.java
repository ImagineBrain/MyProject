package com.xzx.multithread.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueTest {
	/**
	 * 阻塞队列
	 */
	private ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(20);

	public static void main(String[] args) {
		BlockingQueueTest test = new BlockingQueueTest();
		Consumer c = test.new Consumer();
		Producer p = test.new Producer();
		c.start();
		p.start();
	}

	class Consumer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					blockingQueue.take();
					System.out.println("消耗元素," + "队列剩余:" + blockingQueue.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}

	class Producer extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					blockingQueue.put(1);
					System.out.println("生产元素," + "队列剩余:" + blockingQueue.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}
}
