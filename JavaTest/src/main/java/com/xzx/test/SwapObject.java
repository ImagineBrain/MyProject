package com.xzx.test;

public class SwapObject {
	int value;

	public SwapObject(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SwapObject [value=" + value + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
