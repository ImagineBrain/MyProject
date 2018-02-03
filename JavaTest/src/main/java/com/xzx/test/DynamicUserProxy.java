package com.xzx.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicUserProxy implements InvocationHandler {

	private Object obj;

	public DynamicUserProxy(Object obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("动态代理开始调用:");
		Object result = method.invoke(obj, args);
		System.out.println("动态代理结束调用.");
		return result;
	}

	public Object getProxyInstance() {
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
}
