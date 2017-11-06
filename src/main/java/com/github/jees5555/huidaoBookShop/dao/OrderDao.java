package com.github.jees5555.huidaoBookShop.dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.github.jees5555.huidaoBookShop.entity.Order;
import com.github.jees5555.huidaoBookShop.vo.OrderVo;

public interface OrderDao extends BaseDao<Order>{

	Long getId() throws Exception;

	int updateAllPrice(Order order) throws Exception;
	
	int findAllRecords(String keywords,String history) throws Exception;

	List<OrderVo> showOrderList(int startIndex, int pagesize, String keywords, String history) throws SQLException;
}
