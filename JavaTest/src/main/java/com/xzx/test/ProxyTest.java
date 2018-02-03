package com.xzx.test;

import org.junit.Test;

public class ProxyTest {

	@Test
	public void staticProxyTest() {
		IUser user = new UserImpl();
		StaticUserProxy userProxy = new StaticUserProxy(user);
		userProxy.speak();
	}

	@Test
	public void dynamicProxyTest() {
		IUser userImpl = new UserImpl();
		DynamicUserProxy userProxy = new DynamicUserProxy(userImpl);
		IUser user = (IUser) userProxy.getProxyInstance();
		user.speak();
	}

	@Test
	public void cglibProxyTest() {
		User user = new User();
		CglibUserProxy proxy = new CglibUserProxy(user);
		User u = (User) proxy.getProxyInstance();
		u.speak();
	}
}
