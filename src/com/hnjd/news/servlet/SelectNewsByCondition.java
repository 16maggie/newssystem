package com.hnjd.news.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnjd.news.dao.NewsDao;
import com.hnjd.news.dao.NewsDaoImpl;
import com.hnjd.news.entity.News;

/**
 * Servlet implementation class SelectNewsByCondition
 */
@WebServlet("/SelectNewsByCondition")
public class SelectNewsByCondition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectNewsByCondition() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String ntitle = request.getParameter("ntitle");
		String nauthor = request.getParameter("nauthor");
		String ntid = request.getParameter("ntid");
		String ncreateDate = request.getParameter("ncreateDate");
		try {
			News news = new News();
			news.setNtitle(ntitle);
			news.setNauthor(nauthor);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			news.setNcreateDate(sdf.parse(ncreateDate));
			news.setNtid(Integer.valueOf(ntid));
			
			NewsDao newsDao = new NewsDaoImpl();
			List<News> newsByCondition = newsDao.getNewsByCondition(news);
			request.setAttribute("newsByCondition", newsByCondition);
		}catch (Exception e) {
			// TODO: handle exception
		}
		request.getRequestDispatcher("/selectNewsByCondition.jsp").forward(request, response);
	}

}
