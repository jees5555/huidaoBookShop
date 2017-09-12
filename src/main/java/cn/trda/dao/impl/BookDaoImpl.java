package cn.trda.dao.impl;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.trda.dao.BookDao;
import cn.trda.entity.Books;
import cn.trda.exception.Myexception;
import cn.trda.util.DBCPUtil;

public class BookDaoImpl extends BaseDaoImpl<Books> implements BookDao{
	private QueryRunner qr=new QueryRunner(DBCPUtil.getDataSource());
	
	@Override
	public int findAllRecords() {
		//Object 类型转成int
		Object obj =null;
		try {
			obj = qr.query("select count(0) from Books", new ScalarHandler());
			return obj==null?0:((Long)obj).intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Myexception("asdffasdf");
			}
		
	}

	@Override
	public List<Books> showPageRecords(int startnum, int pagesize) {
		// TODO Auto-generated method stub
		
		try {
			return qr.query("select * from Books limit ?,?", new BeanListHandler<Books>(Books.class),startnum,pagesize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Myexception("asdffasdf");
		}
	}
	
	




}
