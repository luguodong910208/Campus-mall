package com.imooc.store.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.imooc.store.domain.User;
import com.imooc.store.service.UserService;
import com.imooc.store.service.serviceImp.UserServiceImp;
import com.imooc.store.utils.MyBeanUtils;
import com.imooc.store.utils.UUIDUtils;
import com.imooc.store.web.base.BaseServlet;

public class UserServlet extends BaseServlet {
	public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/register.jsp";
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
			 //
			 request.setAttribute("msg", "�û�ע��ɹ����뼤�");
			 return "/jsp/info.jsp";
		 }catch(Exception e) {
			 //ע��ʧ�ܣ���ת����ʾҳ��
			 request.setAttribute("msg", "�û�ע��ʧ�ܣ�������ע��");
			 return "/jsp/info.jsp";
		 }
		//ע��ɹ������û����䷢����Ϣ������ת����Ϣ��ʾҳ��
		//��ע��ʧ�ܣ�ҲҪ������ת
		
	}
}
