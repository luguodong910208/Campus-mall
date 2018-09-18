package com.imooc.spring.demo1;

public class OrderDao {
	public void save() {
		System.out.println("保存订单");
	}

	public void update() {
		System.out.println("更新订单");
	}

	public void find() {
		System.out.println("找寻订单");
		int i=1/0;
	}

	public String delete() {
		System.out.println("删除订单");
		return "winston";
	}
}
