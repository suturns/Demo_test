package com.unionpay.acp.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.unionpay.acp.sdk.SDKConfig;

public class InitServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		SDKConfig.getConfig().loadPropertiesFromSrc();// 从classpath加载acp_sdk.properties文件
		super.init();
	}
}