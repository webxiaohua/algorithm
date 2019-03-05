package com.webxiaohua.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: shen_xh
 * @Time: 2019/3/5 10:12
 * @Desc:
 */
public class DaoProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		String methodName = method.getName();
		if("insert".equals(methodName) || "update".equals(methodName)){
			System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
			methodProxy.invokeSuper(object,args);
			System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());
			return object;
		}
		methodProxy.invokeSuper(object,args);
		return object;
	}
}
