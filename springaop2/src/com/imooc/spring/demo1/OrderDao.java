package com.imooc.spring.demo1;

public class OrderDao {
	public void save() {
		System.out.println("���涩��");
	}

	public void update() {
		System.out.println("���¶���");
	}

	public void find() {
		System.out.println("��Ѱ����");
		int i=1/0;
	}

	public String delete() {
		System.out.println("ɾ������");
		return "winston";
	}
}
