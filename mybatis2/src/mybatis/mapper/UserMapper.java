package mybatis.mapper;

import java.util.List;

import mybatis.pojo.QueryVo;
import mybatis.pojo.User;

public interface UserMapper {
	//��ѭ�Ĵ�ԭ��
	//�ӿڷ����� == User.xml��id��
	//����ֵ������Mapper.xml�ļ��з���ֵ����һ��
	//���������������Mapper.xml�������һֱ
	//�����ռ�󶨴˽ӿ�
	public User findUserById(Integer id);
	public List<User> findUserByQueryVo(QueryVo vo);
	public Integer userCount();
	//�����Ա�����ֲ�ѯ�û�
	public List<User> selectUserBySexAndUsername(User user);
}
