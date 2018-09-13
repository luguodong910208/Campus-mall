package com.imooc.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo01
 */
public class ServletDemo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取客户端提价到服务器端的method对应的值
		String md = request.getParameter("method");
		String path = null;
		//通过判断md中不同的内容来决定本次的功能
		if("addStu".equals(md)) {
			path=addStu(request, response);
		}else if("delStu".equals(md)) {
			path=delStu(request, response);
		}else if("checkStu".equals(md)) {
			path=checkStu(request, response);
		}else if("".equals(md)) {
			
		}
		if(null != path) {
			//向服务器端转发
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	
	protected String addStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("添加学生");
		return "/test.html";
	}
	protected String delStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("删除学生");
		return "/test.html";
	}
	protected String checkStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("检查学生");
		response.getWriter().println("checkall");
		return null;
	}
}
