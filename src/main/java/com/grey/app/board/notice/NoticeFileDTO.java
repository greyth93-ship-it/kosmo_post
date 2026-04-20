package com.grey.app.board.notice;

import com.grey.app.file.FileDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeFileDTO extends FileDTO {

	private Long boardNum;
}
