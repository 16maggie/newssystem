package com.hnjd.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.entity.User;
import com.hnjd.news.service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
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
		//����ǰ̨����
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		User user = new User();
		user.setUname(uname);
		user.setUpwd(upwd);;
	
		//����UserServiceִ��ҵ���߼�
		UserService userService = new UserService();
		boolean flag = userService.registerUser(user);
		
		//��������
		JSONObject jo = new JSONObject();
		if(flag) {
			jo.put("result", "ע��ɹ������¼��");
			jo.put("code", "000");
		}else {
			jo.put("result", "ע��ʧ�ܣ��˺��ظ���");
			jo.put("code", "111");
		}
		response.getWriter().print(jo.toString());
	}

}
