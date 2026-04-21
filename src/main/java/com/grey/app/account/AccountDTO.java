package com.grey.app.account;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

	private String accountNum;
	private String username;
	private Long goodsNo;
	private Long accountPw;
	private Long accountBalance;
	private LocalDate accountDate;
	
}
