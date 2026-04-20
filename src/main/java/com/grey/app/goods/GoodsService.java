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


	
	public int create(GoodsDTO goodsDTO, MultipartFile [] attach) throws Exception {
		// 1. 게시판 테이블에 글을 등록
		int result = goodsMapper.create(goodsDTO);
		
		if (attach == null) {
			return result;
		} 
		
		// 2. 파일을 HDD에 저장
		for(MultipartFile f:attach ) {
			if (f.isEmpty()) {
				continue;
				
			}
			String fileName = fileManager.fileSave(name, f);
			// 3. 파일의 정보를 DB에 저장
			
			GoodsFileDTO goodsFileDTO = new GoodsFileDTO();
			goodsFileDTO.setGoodsNo(goodsDTO.getGoodsNo());
			goodsFileDTO.setOriName(f.getOriginalFilename());
			goodsFileDTO.setFileName(fileName);
			
			result = goodsMapper.createFile(goodsFileDTO);
		}
		
		return result;
	}
	

}
