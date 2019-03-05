package com.webxiaohua.proxy;

/**
 * @Author: shen_xh
 * @Time: 2019/3/5 9:42
 * @Desc: 原始调用方式
 */
public class ServiceImpl {
	private Dao dao = new DaoImpl();

	public void insert(){
		System.out.println("insert()方法开始时间：" + System.currentTimeMillis());
		dao.insert();
		System.out.println("insert()方法结束时间：" + System.currentTimeMillis());
	}

	public void delete(){
		dao.delete();
	}

	public void update(){
		System.out.println("update()方法开始时间：" + System.currentTimeMillis());
		dao.update();
		System.out.println("update()方法结束时间：" + System.currentTimeMillis());
	}
}
