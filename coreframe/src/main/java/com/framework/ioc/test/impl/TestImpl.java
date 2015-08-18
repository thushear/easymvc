package com.framework.ioc.test.impl;

import com.framework.ioc.test.ITestApi;

/*
 * =========================== 维护日志 ===========================
 * 2015-08-04 19:29  kongming 新建代码 
 * =========================== 维护日志 ===========================
 */
public class TestImpl implements ITestApi {

	@Override
	public void hello() {
		System.out.println("hello api");
	}

}
