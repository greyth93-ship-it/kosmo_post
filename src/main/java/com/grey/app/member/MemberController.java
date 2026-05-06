package com.grey.app.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.grey.app.board.notice.NoticeDTO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.Getter;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void join(@ModelAttribute MemberDTO memberDTO) throws Exception {
		
	}
	
	@PostMapping("join")
	public String join(@Valid MemberDTO memberDTO, BindingResult bindingResult, @RequestParam("attach") MultipartFile attach) throws Exception {
		
		if(memberService.doubleCheck(memberDTO, bindingResult)) {
			return "member/join";
		}
		
		
		
		
//		int result = memberService.join(memberDTO, attach);
		
		return "redirect:/";
		
	}
	
	@GetMapping("idCheck")
	public String idCheck(MemberDTO memberDTO, Model model) throws Exception{
		memberDTO = memberService.idCheck(memberDTO);
		int result = 0;
		if(memberDTO == null) {
			result=1;
		}
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
	@GetMapping("login")
	public void login(@ModelAttribute MemberDTO memberDTO)throws Exception{
		
	}
	
	@PostMapping("login")
	public String login(@Valid MemberDTO memberDTO,BindingResult bindingResult ,HttpSession session)throws Exception{
		System.out.println(bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			return "member/login";
		}
		
		
//		memberDTO = memberService.detail(memberDTO);
		
		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
		}
		return "redirect:/";
		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "redirect:/";
	}
	
}
