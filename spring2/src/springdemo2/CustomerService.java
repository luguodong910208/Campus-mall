package springdemo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService {
	@PostConstruct//�൱��init-method
	public void init() {
		System.out.println("CustomerService����ʼ����......");
	}
	public void save() {
		System.out.println("Service��save����ִ����");
	}
	@PreDestroy//�൱��destory-method
	public void destroy() {
		System.out.println("CustomerService��������......");
	}
}
