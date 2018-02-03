package com.xzx.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibUserProxy implements MethodInterceptor {

	private Object obj;

	public CglibUserProxy(Object obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Cglib代理开始调用:");
		Object result = arg3.invokeSuper(arg0, arg2); // 代理方法调用
//		Object result = arg1.invoke(obj, arg2); // 直接调用
		System.out.println("Cglib代理结束调用.");
		return result;
	}

	public Object getProxyInstance() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(this);
		Object proxy = enhancer.create();
		return proxy;
	}
}
