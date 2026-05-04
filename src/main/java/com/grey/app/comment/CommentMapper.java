package com.grey.app.comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

	public List<CommentDTO> list(CommentDTO commentDTO) throws Exception;
	
	public int create(CommentDTO commentDTO) throws Exception;
	
	public int delete(CommentDTO commentDTO) throws Exception;
	
	public int update(CommentDTO commentDTO) throws Exception;
}
