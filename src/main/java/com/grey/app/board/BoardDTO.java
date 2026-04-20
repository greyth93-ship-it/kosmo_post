package com.grey.app.board;

import java.time.LocalDateTime;
import java.util.List;

import com.grey.app.file.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {

	private Long boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private LocalDateTime boardDate;
	private Long boardHit;
	
	// 파일을 가지고 있다
	private List<FileDTO> list;
	
}
