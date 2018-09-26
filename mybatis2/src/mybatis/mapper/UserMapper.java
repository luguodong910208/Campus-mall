package mybatis.mapper;

import java.util.List;

import mybatis.pojo.QueryVo;
import mybatis.pojo.User;

public interface UserMapper {
	//遵循四大原则
	//接口方法名 == User.xml中id名
	//返回值类型与Mapper.xml文件中返回值类型一致
	//方法的入参类型与Mapper.xml入参类型一直
	//命名空间绑定此接口
	public User findUserById(Integer id);
	public List<User> findUserByQueryVo(QueryVo vo);
	public Integer userCount();
	//根据性别和名字查询用户
	public List<User> selectUserBySexAndUsername(User user);
}
