package cn.trda.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.trda.dao.UserDao;
import cn.trda.entity.Users;
import cn.trda.exception.Myexception;
import cn.trda.util.DBCPUtil;
/**
 * public   protected 默认friendly  private
 * 所有		子类			本包			本类
 * 杭州汇到：
 * 描述:
 *	@author Administrator
 *
 */
public class UserDaoImpl implements UserDao {
	
	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	
	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
	
		try {
			return qr.query("select * from users where username=? and password=?", new BeanHandler<Users>(Users.class), username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Myexception("dasfasdfasdasdfasdfas");
		}
		
	
	}
	
	@Override
	public int add(Users t) {
		// TODO Auto-generated method stub
		
		try {
			return qr.update("insert into users values(null,?,?,?)", t.getUsername(),t.getPassword(),t.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new Myexception("dasfasdfasdasdfasdfas");
		}
	}

	@Override
	public int del(Users t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Users t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findAllRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
