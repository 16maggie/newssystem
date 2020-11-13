package com.hnjd.news.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.entity.Topic;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class JSAjaxServlet
 */
@WebServlet("/JSAjaxServlet")
public class JSAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);
		response.getWriter().append("接收数据成功");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		System.out.println(username);
		resp.getWriter().append("接收数据成功");
	}
	public static void main(String[] args) {
		List<Topic> topicList = new ArrayList<Topic>();
		Topic t = new Topic();
		t.setTid(1);
		t.setTname("abc");
		topicList.add(t);
		topicList.add(t);
		JSONArray object = JSONArray.fromObject(topicList);
		String str=object.toString();
		System.out.println(str);
	}
}
