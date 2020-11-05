package com.hnjd.news.servlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/**
 * Servlet implementation class MinGanValidate
 */
@WebServlet("/MinGanValidateServlet")
public class MinGanValidateServlet extends HttpServlet {
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
		
		String ccontent = request.getParameter("ccontent");
		
		InputStream resourceAsStream =MinGanValidateServlet.class.getResourceAsStream("/minganzi.txt") ;

		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
		 String line =bufferedReader.readLine();
		 boolean flag = false;
		 while (line!=null){
	            System.out.println(line);
	            if(ccontent.contains(line)) {
	            	flag = true;
	            	break;
	            };
	            line = bufferedReader.readLine();
	     }
		  bufferedReader.close();
		  if(flag) {
			  response.getWriter().write("º¬ÓÐÃô¸Ð×Ö");
		  }
	}
	

}
