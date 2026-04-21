package com.grey.app.account;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grey.app.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping("create")
	public void create() throws Exception{}
	
	
	
	@PostMapping("create")
	public String create(AccountDTO accountDTO, HttpSession session) throws Exception{
		Object object = session.getAttribute("member");
		MemberDTO memberDTO = (MemberDTO)object;
		
		accountDTO.setUsername(memberDTO.getUsername());
		
		int result = accountService.create(accountDTO);
		return "redirect:/";
	}

}
