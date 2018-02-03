package com.xzx.test;

public class StaticUserProxy implements IUser {

	private IUser user;

	public StaticUserProxy(IUser user) {
		this.user = user;
	}

	@Override
	public void speak() {
		// TODO Auto-generated method stub
		System.out.println("静态代理开始调用:");
		user.speak();
		System.out.println("静态代理结束调用.");
	}
}
