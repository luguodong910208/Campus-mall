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
			 MailUtils.sendMail(user.getEmail(), user.getCode());
			 request.setAttribute("msg", "用户注册成功，请激活！");
		 }catch(Exception e) {
			 //注册失败，跳转到提示页面
			 request.setAttribute("msg", "用户注册失败，请重新注册");
		 }
		 return "/jsp/info.jsp";
	}
	public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		//获取激活码
		String code = request.getParameter("code");
		//调用业务层激活功能
		UserService userService = new UserServiceImp();
		boolean flag = userService.userActive(code);
		if(flag == true) {
			//用户激活成功，跳转到登录页面
			request.setAttribute("msg", "用户激活成功，请登录");
			return "/jsp/login.jsp";
		}else {
			request.setAttribute("msg", "用户激活失败,请重新激活");
			return "/jsp/info.jsp";
		}
	}
	
	public String userLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//获取用户数据（账户/密码）
		User user = MyBeanUtils.populate(User.class, request.getParameterMap());
		
		//调用业务层实现登录功能
		UserService userService = new UserServiceImp();
		User user02 = null;
		try {
			user02 = userService.userLogin(user);
			//用户登陆成功，将用户信息放入session中
			request.getSession().setAttribute("loginUser", user02);
			//在登陆成功的基础上，判断用户是否选中自动登录复选框
			String autoLogin = request.getParameter("autoLogin");
			if("yes".equals(autoLogin)) {
				//用户选中自动登录复选框
				Cookie ck = new Cookie("autoLoginCookie",user02.getUsername()+"@"+user02.getPassword());
				ck.setPath("/store");
				ck.setMaxAge(60*60*24*7);
				response.addCookie(ck);
			}
			//在登陆成功的基础上，判断用户是否记住用户名复选框
			String remUser = request.getParameter("remUser");
			if("yes".equals(remUser)) {
				//用户选中记住用户名
				Cookie ck = new Cookie("remUser",user02.getUsername());
				ck.setPath("/store");
				ck.setMaxAge(23423424);
				response.addCookie(ck);
			}
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return null;
		}catch(Exception e) {
			//用户登录失败
			String msg = e.getMessage();
			System.out.println(msg);
			//向request放入失败的信息
			request.setAttribute("msg", msg);
			return "/jsp/login.jsp";
		}
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//清除session
		request.getSession().invalidate();
		//重定向到首页
		response.sendRedirect("/store/index.jsp");
		return null;
	}
}
