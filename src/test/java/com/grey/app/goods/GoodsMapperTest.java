package com.grey.app.goods;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grey.app.board.notice.NoticeDTO;

@SpringBootTest
class GoodsMapperTest {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Test
	void testCreate() throws Exception {
		
			for (int i=0; i<23;i++) {
			
			GoodsDTO goodsDTO = new GoodsDTO();
			goodsDTO.setGoodsName("goods"+i);
			goodsDTO.setGoodsContent("content"+i);
			goodsDTO.setGoodsCategory("category"+i);
			goodsDTO.setGoodsRate(1.5+i);
			
			
			goodsMapper.create(goodsDTO);
			if(i%3==0) {
				Thread.sleep(500);
			}
	
		}
		
		System.out.println("finish");
	}

}
