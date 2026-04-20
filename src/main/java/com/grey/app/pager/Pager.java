package com.grey.app.pager;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Pager {
	
	// 검색어
	private String search="";
	
	// 검색칼럼
	private String kind;
	
	// page 번호
	private Long page;
	
	private Long perPage;
	
	private Long startNum;
	
	private Long start;
	private Long end;
	
	// 이전 블럭의 유무
	private boolean pre =true; // true면 이전블럭 존재
	
	// 다음 블럭의 유무
	private boolean next=true; // true면 다음블럭 존재
	
	
	public Long getPage () {
		if (page == null || page < 1) {
			this.page = 1L;
		}
		return this.page;
		
	}
	
	public Long getPerPage() {
		
		if (perPage == null || perPage < 1) {
			this.perPage = 5L;
		}
		return this.perPage;
	}
	
	public void makePageNum(Long totalCount) {
		// 1. 총 페이지 수
		Long totalPage = (long)(Math.ceil((double)totalCount/this.getPerPage()));
	
		// 2. 총 블럭 수
		Long perBlock = 10L;
		Long totalBlock = totalPage/perBlock;
		
		if (totalPage%10 !=0) {
			totalBlock++;
		}
		
		// 3. 페이지 번호로 현재 블럭 번호 구하기
		Long curBlock = this.getPage()/perBlock;
		if (this.page%perBlock != 0) {
			curBlock++;
		}
		
		// 4. 현재 블럭 번호로 시작번호, 끝번호 구하기
		start=(curBlock-1)*perBlock+1;
		end= curBlock*perBlock;
	
		// 5. 현재 블럭 번호가 총 블럭과 같다면
		if (curBlock == totalBlock) {
			end= totalPage;
			next=false;
		}
		
		// 6. 블럭 유무
		if (curBlock < 2) {
			pre=false;
		}
	
	}

	// 변수
	public void makeStartNum() {
		this.startNum = (this.getPage()-1)*this.getPerPage();
		
	}



}



