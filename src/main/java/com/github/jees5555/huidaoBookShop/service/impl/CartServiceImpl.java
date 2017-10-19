package com.github.jees5555.huidaoBookShop.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.github.jees5555.huidaoBookShop.dao.BookDao;
import com.github.jees5555.huidaoBookShop.dao.CartDao;
import com.github.jees5555.huidaoBookShop.dao.impl.BookDaoImpl;
import com.github.jees5555.huidaoBookShop.dao.impl.CartDaoImpl;
import com.github.jees5555.huidaoBookShop.entity.Cart;
import com.github.jees5555.huidaoBookShop.entity.User;
import com.github.jees5555.huidaoBookShop.service.CartService;
import com.github.jees5555.huidaoBookShop.util.TransactionUtil;
import com.github.jees5555.huidaoBookShop.vo.CartVo;

public class CartServiceImpl implements CartService{
	private BookDao bd = new BookDaoImpl();
	private CartDao cd = new CartDaoImpl();

	@Override
	public int addOrUpdateCart(List<Integer> bids,User user) {
		try{
		//开始事务
		TransactionUtil.startTransaction();
		//查询已有购物车
		List<Cart> carts =new ArrayList<>(); 
		carts=cd.showUserCartList(user);
		for (Integer bid: bids){
			boolean flag=false;
			for(Cart cart:carts){
				if(cart.getBid()==bid){
					//存在就update
					cart.addBookCount();
					cd.update(cart);
					flag=true;
				}
			}
			if(!flag){
				Cart cart =new Cart();
				cart.setUid(user.getUid());
				cart.setBid(bid);
				cart.setCount(1);
				double bookprice=bd.findById(bid).getPrice();
				cart.setBookprice(bookprice);
				cd.add(cart);
				
			}
		}
		
		//提交事务
		TransactionUtil.commit();
		return bids.size();
		}catch(Exception e){
			e.printStackTrace();
			TransactionUtil.rollback();
			return 0;
		}finally{
			TransactionUtil.close();
		}
		
	}

	@Override
	public List<CartVo> findCartByUid(User user)   {
		
			try {
				return cd.findCartByUid(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		
	}

}
