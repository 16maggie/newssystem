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
		// TODO 自动生成的方法存根
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入到了Test1过滤器....");
		
		System.out.println("Test1过滤器已经放行....");
		
		String filterName = config.getFilterName();
		System.out.println("过滤器名："+filterName);
		
		String encoding = config.getInitParameter("encoding");
		System.out.println(encoding);
		
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
