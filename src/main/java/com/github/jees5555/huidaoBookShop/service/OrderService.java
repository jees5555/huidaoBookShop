package com.github.jees5555.huidaoBookShop.service;

import java.util.List;

import com.github.jees5555.huidaoBookShop.entity.User;

public interface OrderService extends BaseService{
	int createOrder(List<Integer> bids, User user);
}
