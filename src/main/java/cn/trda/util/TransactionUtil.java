package cn.trda.util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
/**
 * 得到连接及事务有关的方法
 * 我擦那个：杭州
 * @author Administrator
 *上午8:13:52
 */
public class TransactionUtil {
	//同一个线程共享一个资源
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	private static DataSource ds;
	static{
		try {
			InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties props = new Properties();
			props.load(in);
			ds = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DataSource getDataSource(){
		return ds;
	}
	public static Connection getConnection(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = ds.getConnection();
				tl.set(conn);
			}
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void startTransaction(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
//				tl.set(conn);
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void rollback(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
//				tl.set(conn);
			}
			conn.rollback();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void commit(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
//				tl.set(conn);
			}
			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void relase(){
		try {
			Connection conn = tl.get();
			if(conn!=null){
				conn.close();
				tl.remove();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}