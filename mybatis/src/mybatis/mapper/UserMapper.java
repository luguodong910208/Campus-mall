package mybatis.mapper;

import mybatis.pojo.User;

public interface UserMapper {
	//��ѭ�Ĵ�ԭ��
	//�ӿڷ����� == User.xml��id��
	//����ֵ������Mapper.xml�ļ��з���ֵ����һ��
	//���������������Mapper.xml�������һֱ
	//�����ռ�󶨴˽ӿ�
	public User findUserById(Integer id);
}
