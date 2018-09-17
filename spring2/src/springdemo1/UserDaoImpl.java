package springdemo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userDao")//�൱��<bean id="userDao" class="springdemo1.UserDaoImpl" />
public class UserDaoImpl implements UserDao{
	@Value("winston")
	private String name;
	
	/**
	public void setName(String name) {
		this.name = name;
	}
	**/

	@Override
	public void save() {
		System.out.println("UserDao�б���ķ���ִ����......"+name);
	}
}
