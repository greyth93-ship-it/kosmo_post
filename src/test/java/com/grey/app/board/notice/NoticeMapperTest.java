package com.grey.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grey.app.board.BoardDTO;
import com.grey.app.pager.Pager;

import lombok.extern.slf4j.Slf4j;



@SpringBootTest
@Slf4j
class NoticeMapperTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void testCreate() throws Exception{
		
		for (int i=0; i<23;i++) {
			
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setBoardTitle("title"+i);
			noticeDTO.setBoardWriter("writer"+i);
			noticeDTO.setBoardContent("content"+i);
			
			noticeMapper.create(noticeDTO);
			if(i%3==0) {
				Thread.sleep(500);
			}
	
		}
		
		System.out.println("finish");
	}
	
	
//	@Test
//	void testList() throws Exception{
//		Pager pager = new Pager();
//		pager.setSearch("9");
//		pager.makeStartNum();
//		pager.setPage(1L);
//		List<BoardDTO> ar = noticeMapper.list(pager);
//		
//		log.info("{}", ar);
//		assertEquals(5, ar.size());
//	}

}
