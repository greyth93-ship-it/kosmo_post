package com.grey.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.grey.app.board.BoardDTO;

@SpringBootTest
class NoticeMapperTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void testList() throws Exception{
		List<BoardDTO> ar = noticeMapper.list();
		assertNotEquals(0, ar.size());
	}

}
