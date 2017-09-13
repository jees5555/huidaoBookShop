package com.github.jees5555.huidaoBookShop.service;

import com.github.jees5555.huidaoBookShop.entity.Users;

public interface UserService extends BaseService<Users>{
		Users login(String username,String password);
}
