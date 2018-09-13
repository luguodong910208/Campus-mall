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
	//实现userRegist
	public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//接收表单参数
		Map<String, String[]> map = request.getParameterMap();
		User user = new User();
		//使用MyBeanUtils工具类获取user的所有数据
		MyBeanUtils.populate(user, map);
		//为用户的其他属性赋值
		user.setUid(UUIDUtils.getId());
		user.setState(0);
		user.setCode(UUIDUtils.getCode());
		System.out.println(user);
		
		//遍历map中的数据
		
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
		//调用业务层的注册功能
		 UserService userService = new UserServiceImp();
		 try {
			 userService.userRegist(user);
			 //注册成功，向用户邮箱发送信息，跳转到提示页面
			 //发送邮件
			 //
			 request.setAttribute("msg", "用户注册成功，请激活！");
			 return "/jsp/info.jsp";
		 }catch(Exception e) {
			 //注册失败，跳转到提示页面
			 request.setAttribute("msg", "用户注册失败，请重新注册");
			 return "/jsp/info.jsp";
		 }
		//注册成功，向用户邮箱发送信息，并跳转到信息提示页面
		//当注册失败，也要进行跳转
		
	}
}
