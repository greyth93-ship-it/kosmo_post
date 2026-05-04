package com.grey.app.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grey.app.member.MemberDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/comment/*")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("list")
	public void list(CommentDTO commentDTO, Model model) throws Exception {
		List<CommentDTO> ar = commentService.list(commentDTO);
		model.addAttribute("list", ar);
		
	}
	
	@PostMapping("create")
	@ResponseBody
	public int create(HttpSession session, CommentDTO commentDTO, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		commentDTO.setUsername(memberDTO.getUsername());
		int result = commentService.create(commentDTO);
		model.addAttribute("result",result);
		
		return result;
	}
	
	@PostMapping("delete")
	@ResponseBody
	public int delete(HttpSession session, CommentDTO commentDTO, Model model) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		commentDTO.setUsername(memberDTO.getUsername());
		int result = commentService.delete(commentDTO);
		model.addAttribute("result",result);
		
		return result;
	}
	
	@PostMapping("update")
	@ResponseBody
	public int update(CommentDTO commentDTO, Model model) throws Exception{
		int result = commentService.update(commentDTO);
		model.addAttribute("result", result);
		
		return result;
	}
}
