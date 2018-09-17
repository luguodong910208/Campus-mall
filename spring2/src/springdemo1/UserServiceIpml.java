package springdemo1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("userService")
public class UserServiceIpml implements UserService {

	//注入dao
	/*@Autowired
	@Qualifier(value="userDao")*/
	@Resource(name="userDao")
	private UserDao userDao;
	
	
	@Override
	public void save() {
		System.out.println("userService的保存方式执行了......");
		userDao.save();
	}
}
