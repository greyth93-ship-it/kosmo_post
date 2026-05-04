package com.grey.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.grey.app.board.BoardDTO;
import com.grey.app.board.BoardService;
import com.grey.app.file.FileDTO;
import com.grey.app.file.FileManager;
import com.grey.app.pager.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.upload.base}")
	private String base;
	
	
	@Value("${app.board.qna}")
	private String name;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makePageNum(qnaMapper.getCount(pager));
		pager.makeStartNum();
			
		return qnaMapper.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.detail(boardDTO);
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile [] attach) throws Exception {
		
		int result = qnaMapper.create(boardDTO);
		
		if (attach == null) {
			return result;
		}
		
		for (MultipartFile f:attach) {
			if(f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(name, f);
			
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(boardDTO.getBoardNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(f.getOriginalFilename());
			
			result = qnaMapper.createFile(qnaFileDTO);
			
		}
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO, MultipartFile [] attach ) throws Exception {
		int result = qnaMapper.update(boardDTO);
		
		
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		//파일명 조회
		boardDTO = qnaMapper.detail(boardDTO);
		
		//HDD에서 파일 삭제
		for(FileDTO fileDTO:boardDTO.getList()) {
			fileManager.fileDelete(name, fileDTO);
			//qnaMapper.fileDelete(fileDTO);
		}
		
		qnaMapper.fileDeleteFor(boardDTO.getList());
		
		//DB에서 삭제
		int result = qnaMapper.delete(boardDTO);
		return result;
	}
	
	@Override
	public FileDTO fileDetail(FileDTO fileDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaMapper.fileDetail(fileDTO);
	}
	

}
