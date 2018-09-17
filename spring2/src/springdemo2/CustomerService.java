package springdemo2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerService {
	@PostConstruct//相当于init-method
	public void init() {
		System.out.println("CustomerService被初始化了......");
	}
	public void save() {
		System.out.println("Service的save方法执行了");
	}
	@PreDestroy//相当于destory-method
	public void destroy() {
		System.out.println("CustomerService被销毁了......");
	}
}
