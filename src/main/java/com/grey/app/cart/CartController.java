package com.grey.app.cart;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grey.app.goods.GoodsDTO;
import com.grey.app.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/*")
public class CartController {

	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	
	@PostMapping("create")
	public String create(HttpSession session, CartDTO cartDTO, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		cartDTO.setUsername(memberDTO.getUsername());
		
		int result = cartServiceImpl.create(cartDTO);
		
		model.addAttribute("result",result);
		
		
		return "commons/ajaxResult";
	}
	
	@GetMapping("list")
	public void list() throws Exception{}
	
	@GetMapping("cartlist")
	public void list(HttpSession session, Model model) throws Exception{
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		List<GoodsDTO> ar = cartServiceImpl.list(memberDTO);
		model.addAttribute("list", ar );
		
	}
	
	@PostMapping("delete")
	public String delete(HttpSession session, @RequestParam("goodsNo") Long [] goodsNo, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		List<CartDTO> ar = new ArrayList<>();
		
		for(Long l : goodsNo) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setGoodsNo(l);
			cartDTO.setUsername(memberDTO.getUsername());
			ar.add(cartDTO);
		}
		
		int result = cartServiceImpl.delete(ar);
		model.addAttribute("result",result);
		
		return "commons/ajaxResult";
	}
	
//	@PostMapping("delete")
//	public String delete(HttpSession session, CartDTO cartDTO, Model model) throws Exception{
//		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
//		cartDTO.setUsername(memberDTO.getUsername());
//		int result = cartServiceImpl.delete(cartDTO);
//		model.addAttribute("result",result);
//		
//		return "commons/ajaxResult";
//	}
	
}
