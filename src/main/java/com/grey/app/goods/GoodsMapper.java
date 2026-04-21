package com.grey.app.goods;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.grey.app.pager.Pager;

@Mapper
public interface GoodsMapper {
	
	public int createFile(GoodsFileDTO goodsFileDTO) throws Exception;
	
	public Long getCount(Pager pager) throws Exception;

	public List<GoodsDTO> list(Pager pager) throws Exception;
	
	public int create(GoodsDTO goodsDTO) throws Exception;
	
	public GoodsDTO detail(GoodsDTO goodsDTO) throws Exception;
}
