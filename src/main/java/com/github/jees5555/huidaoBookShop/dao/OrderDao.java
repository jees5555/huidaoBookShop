package com.github.jees5555.huidaoBookShop.dao;

import com.github.jees5555.huidaoBookShop.entity.Order;

public interface OrderDao extends BaseDao<Order>{

	Long getId() throws Exception;

	int updateAllPrice(Order order) throws Exception;
}
