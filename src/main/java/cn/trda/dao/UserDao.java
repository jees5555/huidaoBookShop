package cn.trda.dao;

import cn.trda.entity.Users;

public interface UserDao extends BaseDao<Users>{
		Users login(String username,String password);
}
