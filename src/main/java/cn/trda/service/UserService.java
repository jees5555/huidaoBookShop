package cn.trda.service;

import cn.trda.entity.Users;

public interface UserService extends BaseService<Users>{
		Users login(String username,String password);
}
