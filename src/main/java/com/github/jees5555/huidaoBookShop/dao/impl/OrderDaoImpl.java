package com.github.jees5555.huidaoBookShop.dao.impl;

import java.math.BigInteger;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.github.jees5555.huidaoBookShop.dao.OrderDao;
import com.github.jees5555.huidaoBookShop.entity.Book;
import com.github.jees5555.huidaoBookShop.entity.Order;
import com.github.jees5555.huidaoBookShop.util.DBCPUtil;
import com.github.jees5555.huidaoBookShop.util.TransactionUtil;
import com.github.jees5555.huidaoBookShop.vo.OrderVo;

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
@Override
public int findAllRecords(String keywords, String history) throws Exception {
	String sql;
	Long rec =null;
	if(keywords==null ||"".equals(keywords)){
		if(history==null || "".equals(history)){
		sql="select count(*) from `order` o left join orderdetail od on o.oid=od.oid";
		rec = qr.query(sql, new ScalarHandler<Long>());
		}else{
			if(history.equals("1M")){
				sql="select count(*) from `order` o  left join orderdetail od on o.oid=od.oid where o.createtime >? and o.createtime<=?";
				rec = qr.query(sql, new ScalarHandler<Long>(),LocalDate.now().minusYears(1),LocalDate.now().minusMonths(1));
			}else if(history.equals("1Y")){
				sql="select count(*) from `order` o left join orderdetail od on o.oid=od.oid where o.createtime <=?";
				rec = qr.query(sql, new ScalarHandler<Long>(),LocalDate.now().minusYears(1));
			}else{
				return findAllRecords(keywords,null);
			}
		}
	}else{
		if(history==null || "".equals(history)){
			keywords="%"+keywords+"%";
			sql="select count(*) from `order` o left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid where b.bookname like ?";
			rec = qr.query(sql, new ScalarHandler<Long>(),keywords);
		}else{
			keywords="%"+keywords+"%";
			if(history.equals("1M")){
				sql="select count(*) from `order` o left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid"
						+" where o.createtime >? and o.createtime<=? and b.bookname like ?";
				rec = qr.query(sql, new ScalarHandler<Long>(),LocalDate.now().minusYears(1),LocalDate.now().minusMonths(1),keywords);
			}else if(history.equals("1Y")){
				sql="select count(*) from `order` o left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid"
						+" where o.createtime <=? and b.bookname like ?";
				rec = qr.query(sql, new ScalarHandler<Long>(),LocalDate.now().minusYears(1),keywords);
			}else{
				return findAllRecords(keywords,null);
			}
		}
	}		
		return rec==null?0:rec.intValue();
	
}
@Override
public List<OrderVo> showOrderList(int startIndex, int pagesize, String keywords, String history) throws SQLException {
	String sql;
	if(keywords==null ||"".equals(keywords)){
		if(history==null || "".equals(history)){
			sql="select * from `order` o left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid Order by createtime DESC limit ?,?";
			return qr.query(sql,  new BeanListHandler<OrderVo>(OrderVo.class),startIndex,pagesize);
		}else{
			if(history.equals("1M")){
				sql="select * from `order` o  left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid"
						+" where o.createtime >? and o.createtime<=? Order by createtime DESC limit ?,?";
				return  qr.query(sql,  new BeanListHandler<OrderVo>(OrderVo.class),LocalDate.now().minusYears(1),LocalDate.now().minusMonths(1),startIndex,pagesize);
			}else if(history.equals("1Y")){
				sql="select * from `order` o left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid"
						+" where o.createtime <=? Order by createtime DESC limit ?,?";
				return qr.query(sql,  new BeanListHandler<OrderVo>(OrderVo.class),LocalDate.now().minusYears(1),startIndex,pagesize);
			}else{
				return showOrderList(startIndex, pagesize, keywords, null);
			}
		}
	}else{
		if(history==null || "".equals(history)){
			keywords="%"+keywords+"%";
			sql="select * from `order` o left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid"
					+" where b.bookname like ? Order by createtime DESC limit ?,?";
			return qr.query(sql,  new BeanListHandler<OrderVo>(OrderVo.class),keywords,startIndex,pagesize);
		}else{
			keywords="%"+keywords+"%";
			if(history.equals("1M")){
				sql="select * from `order` o left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid"
						+" where o.createtime >? and o.createtime<=? and b.bookname like ? Order by createtime DESC limit ?,?";
				return qr.query(sql,  new BeanListHandler<OrderVo>(OrderVo.class),LocalDate.now().minusYears(1),LocalDate.now().minusMonths(1),keywords,startIndex,pagesize);
			}else if(history.equals("1Y")){
				sql="select * from `order` o left join orderdetail od on o.oid=od.oid LEFT JOIN book b on od.bid=b.bid"
						+" where o.createtime <=? and b.bookname like ? Order by createtime DESC limit ?,?";
				return qr.query(sql, new BeanListHandler<OrderVo>(OrderVo.class),LocalDate.now().minusYears(1),keywords,startIndex,pagesize);
			}else{
				return showOrderList(startIndex, pagesize, keywords, null);
			}
		}
	}


}
}
