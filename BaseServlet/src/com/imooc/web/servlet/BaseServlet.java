package com.imooc.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取客户端提价到服务器端的method对应的值
		String md = request.getParameter("method");
		String path = null;
		//获取当前字节码对象(ServletDemo02.class在内存中形成的对象)
		Class clazz = this.getClass();
		
		try {
			//铜鼓反射获取clazz上名称为md的方法
			Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
			//如果存在该方法，就将参数传入到该方法中
			if(null != method) {
				path = (String)method.invoke(this, request, response);
			}
			if(null != path) {
				//向服务器端转发
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
