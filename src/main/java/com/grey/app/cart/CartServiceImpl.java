package com.grey.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grey.app.goods.GoodsDTO;
import com.grey.app.member.MemberDTO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public int create(CartDTO cartDTO) throws Exception {
		// TODO Auto-generated method stub
		return cartMapper.create(cartDTO);
	}
	
	

	@Override
	public List<GoodsDTO> list(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return cartMapper.list(memberDTO);
	}
	
	
	@Override
	public int delete(List<CartDTO> ar) throws Exception {
		// TODO Auto-generated method stub
		return cartMapper.delete(ar);
	}
	
	
//	@Override
//	public int delete(CartDTO cartDTO) throws Exception {
//		// TODO Auto-generated method stub
//		return cartMapper.delete(cartDTO);
//	}
}
