package com.webxiaohua.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shen_xh
 * @Time: 2019/2/1 16:38
 * @Desc:
 */
public class HeapOOM {
	static class OOMObject{}

	public static void main(String[] args){
		List<OOMObject> list = new ArrayList<>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
