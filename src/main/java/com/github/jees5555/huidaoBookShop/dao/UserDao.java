package com.github.jees5555.huidaoBookShop.dao;

import com.github.jees5555.huidaoBookShop.entity.Users;

public interface UserDao extends BaseDao<Users>{
		Users login(String username,String password);
}
