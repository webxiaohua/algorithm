package com.webxiaohua.jvm;

/**
 * @Author: shen_xh
 * @Time: 2019/2/1 16:28
 * @Desc:
 */
public class StackOverflowError {
	private int stackLength = 1;
	public void invoke(){
		stackLength++;
		invoke();
	}

	public static void main(String... args){
		StackOverflowError stackOverflowError = new StackOverflowError();
		try{
			stackOverflowError.invoke();
		}catch(Throwable ex){
			System.out.println("stack length:"+stackOverflowError.stackLength);
			throw ex;
		}
	}
}
