package com.hnjd.news.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.entity.User;
import com.hnjd.news.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����ǰ̨���ݵĲ���
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		//��UserServiceִ��ҵ���߼�
		UserService userService = new UserService();
		User user = userService.userLogin(uname, upwd);
		
		
		//�����ݴ��ݸ�ǰ̨
		request.getSession().setAttribute("user", user);
		if(user == null) {
			request.setAttribute("code", "111");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
