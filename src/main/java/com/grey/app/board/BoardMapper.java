package com.grey.app.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> list() throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	public int create(BoardDTO boardDTO) throws Exception;
	
	public int update(BoardDTO boardDTO) throws Exception;
	
	public int delete(BoardDTO boardDTO) throws Exception;
}
