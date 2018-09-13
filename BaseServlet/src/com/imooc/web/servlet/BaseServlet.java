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
		//��ȡ�ͻ�����۵��������˵�method��Ӧ��ֵ
		String md = request.getParameter("method");
		String path = null;
		//��ȡ��ǰ�ֽ������(ServletDemo02.class���ڴ����γɵĶ���)
		Class clazz = this.getClass();
		
		try {
			//ͭ�ķ����ȡclazz������Ϊmd�ķ���
			Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);
			//������ڸ÷������ͽ��������뵽�÷�����
			if(null != method) {
				path = (String)method.invoke(this, request, response);
			}
			if(null != path) {
				//���������ת��
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
