package com.github.jees5555.huidaoBookShop.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.github.jees5555.huidaoBookShop.dao.OrderDao;
import com.github.jees5555.huidaoBookShop.entity.Order;
import com.github.jees5555.huidaoBookShop.util.DBCPUtil;
import com.github.jees5555.huidaoBookShop.util.TransactionUtil;

public class OrderDaoImpl implements OrderDao{

	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());	
	
@Override
public int add(Order order) throws Exception {
	String sql="insert into `order` (uid,allprice,createtime,status) values (?,?,?,?)" ;
	return qr.update(TransactionUtil.getConnection(), sql,order.getUid(),order.getAllprice(),order.getCreatetime(),order.getStatus());
}
@Override
public int updateAllPrice(Order order) throws Exception {
	String sql="update `order` set allprice = ? where oid=?" ;
	return qr.update(TransactionUtil.getConnection(), sql,order.getAllprice(),order.getOid());
}
@Override
public Long getId() throws Exception {
	BigInteger bi =qr.query(TransactionUtil.getConnection(), "SELECT LAST_INSERT_ID()", new ScalarHandler<BigInteger>(1));
	return  Long.valueOf(bi.toString());
}
}
