package com.hnjd.news.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test1Filter implements Filter{

	private FilterConfig config;
	
	@Override
	public void destroy() {
		// TODO �Զ����ɵķ������
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("���뵽��Test1������....");
		
		System.out.println("Test1�������Ѿ�����....");
		
		String filterName = config.getFilterName();
		System.out.println("����������"+filterName);
		
		String encoding = config.getInitParameter("encoding");
		System.out.println(encoding);
		
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
