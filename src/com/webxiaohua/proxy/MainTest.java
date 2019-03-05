package com.webxiaohua.proxy;


import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * @Author: shen_xh
 * @Time: 2019/3/5 10:00
 * @Desc:
 */
public class MainTest {
	public static void main(String... args){
		testCglib();
	}

	public static void testCglib(){
		DaoProxy daoProxy = new DaoProxy();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(DaoImpl.class);
		enhancer.setCallback(daoProxy);
		Dao dao = (DaoImpl)enhancer.create();
		dao.insert();
		dao.delete();
		dao.update();
	}

	public static void testProxy(){
		Dao dao = new DaoImpl();
		Dao proxyDao = (Dao) Proxy.newProxyInstance(
				LogInvocationHandler.class.getClassLoader(),
				new Class<?>[]{Dao.class},
				new LogInvocationHandler(dao));
		proxyDao.insert();
		proxyDao.delete();
		proxyDao.update();
	}
}
