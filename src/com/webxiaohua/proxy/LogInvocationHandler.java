package com.webxiaohua.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: shen_xh
 * @Time: 2019/3/5 9:52
 * @Desc: 代理模式
 */
public class LogInvocationHandler implements InvocationHandler {
	// 被代理对象
	private Object object;

	public LogInvocationHandler(Object obj){
		this.object = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		if("insert".equals(methodName) || "update".equals(methodName)){
			System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
			Object result = method.invoke(object,args);
			System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());
			return result;
		}
		return method.invoke(object,args);
	}
}
