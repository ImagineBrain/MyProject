package com.xzx.multithread.lock;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public static int size = 20;
	public static Queue<Integer> queue = new ArrayDeque<Integer>(size);
	public static Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	/**
	 * @author xiezi 生产者
	 */
	class Producer extends Thread {
		@Override
		public void run() {
			while (true) {
				if (lock.tryLock()) {
					try {
						if (queue.size() < size) {
							int e = queue.size() + 1;
							queue.add(e);
							System.out.println("生成数据:" + e);
							if (queue.size() == size) {
								System.out.println("资源满了，唤醒消费者");
								condition.signal();
							}
						} else {
							System.out.println("资源满了，等待");
							condition.await();
						}
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						lock.unlock();
					}
				}
			}

		}
	}
	
	class Consumer extends Thread {
		@Override
		public void run() {
			while (true) {
				if (lock.tryLock()) {
					try {
						if (!queue.isEmpty()) {
							System.out.println("消耗数据:" + queue.poll());
							if (queue.isEmpty()) {
								System.out.println("资源没了，唤醒生产者");
								condition.signal();
							}
						} else {
							System.out.println("资源没了，等待");
							condition.await();
						}
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						lock.unlock();
					}
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLockTest test = new ReentrantLockTest();
		Consumer c = test.new Consumer();
		Producer p = test.new Producer();
		c.start();
		p.start();
	}

}
