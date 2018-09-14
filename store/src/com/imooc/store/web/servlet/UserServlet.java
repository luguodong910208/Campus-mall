package com.imooc.store.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.imooc.store.domain.User;
import com.imooc.store.service.UserService;
import com.imooc.store.service.serviceImp.UserServiceImp;
import com.imooc.store.utils.MailUtils;
import com.imooc.store.utils.MyBeanUtils;
import com.imooc.store.utils.UUIDUtils;
import com.imooc.store.web.base.BaseServlet;

public class UserServlet extends BaseServlet {
	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
	public String loginUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/login.jsp";
	}
	//ʵ��userRegist
	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//���ձ�����
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		//ʹ��MyBeanUtils�������ȡuser����������
		MyBeanUtils.populate(user, map);
		//Ϊ�û����������Ը�ֵ
		user.setUid(UUIDUtils.getId());
		user.setState(0);
		user.setCode(UUIDUtils.getCode());
		System.out.println(user);
		
		//����map�е�����
		
		/**
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
			String[] strs = map.get(str);
			for(String string : strs) {
				System.out.println(string);
			}
			System.out.println();
		}
		**/
		//����ҵ����ע�Ṧ��
		 UserService userService = new UserServiceImp();
		 try {
			 userService.userRegist(user);
			 //ע��ɹ������û����䷢����Ϣ����ת����ʾҳ��
			 //�����ʼ�
			 MailUtils.sendMail(user.getEmail(), user.getCode());
			 request.setAttribute("msg", "�û�ע��ɹ����뼤�");
		 }catch(Exception e) {
			 //ע��ʧ�ܣ���ת����ʾҳ��
			 request.setAttribute("msg", "�û�ע��ʧ�ܣ�������ע��");
		 }
		 return "/jsp/info.jsp";
	}
	public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		//��ȡ������
		String code = request.getParameter("code");
		//����ҵ��㼤���
		UserService userService = new UserServiceImp();
		boolean flag = userService.userActive(code);
		if(flag == true) {
			//�û�����ɹ�����ת����¼ҳ��
			request.setAttribute("msg", "�û�����ɹ������¼");
			return "/jsp/login.jsp";
		}else {
			request.setAttribute("msg", "�û�����ʧ��,�����¼���");
			return "/jsp/info.jsp";
		}
	}
	
	public String userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//��ȡ�û����ݣ��˻�/���룩
		User user = MyBeanUtils.populate(User.class, request.getParameterMap());
		
		//����ҵ���ʵ�ֵ�¼����
		UserService userService = new UserServiceImp();
		User user02 = null;
		try {
			user02 = userService.userLogin(user);
			//�û���½�ɹ������û���Ϣ����session��
			request.getSession().setAttribute("loginUser", user02);
			//�ڵ�½�ɹ��Ļ����ϣ��ж��û��Ƿ�ѡ���Զ���¼��ѡ��
			String autoLogin = request.getParameter("autoLogin");
			if("yes".equals(autoLogin)) {
				//�û�ѡ���Զ���¼��ѡ��
				Cookie ck = new Cookie("autoLoginCookie",user02.getUsername()+"@"+user02.getPassword());
				ck.setPath("/store");
				ck.setMaxAge(60*60*24*7);
				response.addCookie(ck);
			}
			//�ڵ�½�ɹ��Ļ����ϣ��ж��û��Ƿ��ס�û�����ѡ��
			String remUser = request.getParameter("remUser");
			if("yes".equals(remUser)) {
				//�û�ѡ�м�ס�û���
				Cookie ck = new Cookie("remUser",user02.getUsername());
				ck.setPath("/store");
				ck.setMaxAge(23423424);
				response.addCookie(ck);
			}
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return null;
		}catch(Exception e) {
			//�û���¼ʧ��
			String msg = e.getMessage();
			System.out.println(msg);
			//��request����ʧ�ܵ���Ϣ
			request.setAttribute("msg", msg);
			return "/jsp/login.jsp";
		}
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//���session
		request.getSession().invalidate();
		//�ض�����ҳ
		response.sendRedirect("/store/index.jsp");
		return null;
	}
}
