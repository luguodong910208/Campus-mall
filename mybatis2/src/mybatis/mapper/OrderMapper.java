package mybatis.mapper;

import java.util.List;

import mybatis.pojo.Orders;

public interface OrderMapper {
	//��ѯ����order��������
	public List<Orders> selectOrdersList();
}
