package com.grey.app.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



import com.grey.app.file.FileManager;
import com.grey.app.pager.Pager;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private FileManager fileManager;
	
	
	
	@Value("${app.goods}")
	private String name;
	
	
	
	public List<GoodsDTO> list(Pager pager) throws Exception {
		pager.makePageNum(goodsMapper.getCount(pager));
		pager.makeStartNum();
		
		
		return goodsMapper.list(pager);
	}

	public GoodsDTO detail(GoodsDTO goodsDTO) throws Exception {
		
		return goodsMapper.detail(goodsDTO);
	}

	
	public int create(GoodsDTO goodsDTO, MultipartFile attach) throws Exception {
		// 1. 게시판 테이블에 글을 등록
		int result = goodsMapper.create(goodsDTO);
		
		if(attach != null && !attach.isEmpty()) {
			String fileName = fileManager.fileSave(name, attach);
			GoodsFileDTO goodsFileDTO = new GoodsFileDTO();
			goodsFileDTO.setFileName(fileName);
			goodsFileDTO.setOriName(attach.getOriginalFilename());
			goodsFileDTO.setGoodsNo(goodsDTO.getGoodsNo());
			goodsMapper.createFile(goodsFileDTO);
		}
		
		return result;
	}
	

}
