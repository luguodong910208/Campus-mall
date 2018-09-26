package mybatis.mapper;

import java.util.List;

import mybatis.pojo.Orders;

public interface OrderMapper {
	//查询订单order所有数据
	public List<Orders> selectOrdersList();
}
