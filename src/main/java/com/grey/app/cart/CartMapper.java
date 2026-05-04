package com.grey.app.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.grey.app.goods.GoodsDTO;
import com.grey.app.member.MemberDTO;

@Mapper
public interface CartMapper {
	
	public int create(CartDTO cartDTO) throws Exception;
	
	public List<GoodsDTO> list(MemberDTO memberDTO) throws Exception;
	
	public int delete(List<CartDTO> ar) throws Exception;
}
