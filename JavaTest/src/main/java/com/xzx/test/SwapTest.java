package com.xzx.test;

import org.junit.Test;

public class SwapTest {

	static SwapTest test = new SwapTest();

	static Integer sa = new Integer(1);
	static Integer sb = new Integer(2);

	public void swap(Object a, Object b) {
		Object c = a;
		a = b;
		b = c;
	}

	public void swap(SwapObject a, SwapObject b) {
		SwapObject c = a;
		a = b;
		b = c;
	}

	public void swapObj(SwapObject a, SwapObject b) {
		SwapObject c = new SwapObject(a.getValue());
		a.setValue(b.getValue());
		b.setValue(c.getValue());
	}

	@Test
	public void integerTest() {
		Integer a = new Integer(1);
		Integer b = new Integer(2);
		System.out.println(a + ":" + b);
		test.swap(a, b);
		System.out.println(a + ":" + b);
		System.out.println(sa + ":" + sb);
		test.swap(sa, sb);
		System.out.println(sa + ":" + sb);
	}

	@Test
	public void ojbTest() {
		SwapObject a = new SwapObject(1);
		SwapObject b = new SwapObject(2);
		System.out.println(a + ":" + b);
		test.swap(a, b);
		System.out.println(a + ":" + b);
		test.swapObj(a, b);
		System.out.println(a + ":" + b);
	}
}
