package com.grey.app.goods;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GoodsDTO {

// DAO, Service, Controller 간의 데이터 전달	

	private Long goodsNo;
	private String goodsName;
	private String goodsContent;
	private String goodsCategory;
	private Double goodsRate;
	
	
}
