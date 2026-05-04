package com.grey.app.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	
	public List<CommentDTO> list(CommentDTO commentDTO) throws Exception{
		
		return commentMapper.list(commentDTO);
	}
	
	
	public int create(CommentDTO commentDTO) throws Exception{
		return commentMapper.create(commentDTO);
	}
	
	
	public int delete(CommentDTO commentDTO) throws Exception{
		return commentMapper.delete(commentDTO);
	}
	
	public int update(CommentDTO commentDTO) throws Exception{
		return commentMapper.update(commentDTO);
	}
}
