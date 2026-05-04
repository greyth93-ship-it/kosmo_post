package com.grey.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.grey.app.board.BoardDTO;
import com.grey.app.board.BoardService;
import com.grey.app.file.FileDTO;
import com.grey.app.file.FileManager;
import com.grey.app.pager.Pager;

@Service
@Transactional(rollbackFor = Exception.class)
public class NoticeService implements BoardService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private FileManager filemanager;
	
	@Value("${app.board.notice}")
	private String name;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makePageNum(noticeMapper.getCount(pager));
		pager.makeStartNum();
		
		return noticeMapper.list(pager);
	}

	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.fileDetail(fileDTO);
	}
	
	
	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.detail(boardDTO);
	}

	
	@Override
	public int create(BoardDTO boardDTO, MultipartFile [] attach) throws Exception {
		// 1. 게시판 테이블에 글을 등록
		int result = noticeMapper.create(boardDTO);
		
		if (attach == null) {
			return result;
		} 
		
		// 2. 파일을 HDD에 저장
		for(MultipartFile f:attach ) {
			if (f.isEmpty()) {
				continue;
				
			}
			String fileName = filemanager.fileSave(name, f);
			// 3. 파일의 정보를 DB에 저장
			
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setBoardNum(boardDTO.getBoardNum());
			noticeFileDTO.setOriName(f.getOriginalFilename());
			noticeFileDTO.setFileName(fileName);
			
			result = noticeMapper.createFile(noticeFileDTO);
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile [] attach) throws Exception {
		int result = noticeMapper.update(boardDTO);
		
		
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// 파일명 조회
		boardDTO = noticeMapper.detail(boardDTO);
		
		// 파일 개수 조회 및 삭제
		for (FileDTO fileDTO:boardDTO.getList()) {
			filemanager.fileDelete(name, fileDTO);
			
		}
		// DB에서 삭제
		int result = noticeMapper.delete(boardDTO);
		return result;
	}
	
	
}
