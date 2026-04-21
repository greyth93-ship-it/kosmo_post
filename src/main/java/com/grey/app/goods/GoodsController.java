package com.grey.app.goods;

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
import org.springframework.web.multipart.MultipartFile;

import com.grey.app.pager.Pager;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@Value("${app.goods}")
	private String name;
	
	@ModelAttribute("name")
	public String getName() {
		
		return this.name;
	}
	
	
	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {
		
		List<GoodsDTO> ar = goodsService.list(pager);
		model.addAttribute("list", ar);
		
		return "goods/list";
	}
	
	@GetMapping("create")
	public void create() throws Exception {}
	
	@PostMapping("create")
	public String create(GoodsDTO goodsDTO, @RequestParam("attach") MultipartFile attach) throws Exception {
		int result = goodsService.create(goodsDTO, attach);
		
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String detail(GoodsDTO goodsDTO, Model model) throws Exception {
		goodsDTO = goodsService.detail(goodsDTO);
		model.addAttribute("dto", goodsDTO);
		return "goods/detail";
	}

}
