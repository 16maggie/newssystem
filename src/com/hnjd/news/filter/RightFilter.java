package com.hnjd.news.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.hnjd.news.entity.User;

public class RightFilter implements Filter{

	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) {
		try {
			
			HttpServletRequest  httpReq = (HttpServletRequest)req;
			String ignorePath = config.getInitParameter("ignorePath");
			String[] pathList = ignorePath.split(",");
			boolean flag = false;
			for(String path : pathList) {
				//判断当前的请求地址有没有包含忽略路径
				flag = httpReq.getServletPath().toLowerCase().contains(path.toLowerCase());
				if(flag) break;
			}
			if(!flag) {
				User user = (User) httpReq.getSession().getAttribute("user");
				if(user == null) {
					httpReq.setAttribute("code", "222");
					httpReq.getRequestDispatcher("login.jsp").forward(req, resp);
					return;
				}
			}
			chain.doFilter(req, resp);
		} catch (ServletException | IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	
	public static void main(String[] args) {
		boolean contains = "Login".toLowerCase().contains("login".toLowerCase());
		System.out.println(contains);
	}
}
