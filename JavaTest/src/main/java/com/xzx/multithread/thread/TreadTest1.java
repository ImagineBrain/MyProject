package com.xzx.multithread.thread;

public class TreadTest1 {

	public static int value = 0;
	class MyThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				value++;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreadTest1 test = new TreadTest1();
		MyThread t = test.new MyThread();
		t.start();
		try {
			t.join(); // 等待t完成
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value);
	}
}
