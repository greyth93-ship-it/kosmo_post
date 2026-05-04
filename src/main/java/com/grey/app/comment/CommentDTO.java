package com.grey.app.comment;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

	private Long commentNo;
	private String commentContent;
	private Long commentStar;
	private LocalDateTime commentDate;
	private String username;
	private Long goodsNo;
	
}
