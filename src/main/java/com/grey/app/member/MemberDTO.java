package com.grey.app.member;

import java.time.LocalDate;

import org.checkerframework.checker.regex.qual.Regex;
import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	
	@NotBlank(message = "ID는 필수입니다.")
	private String username;
//	@NotBlank
	private String name;
	@Size(min=2,max=10)
	@NotBlank
	private String password;
	
	private String passwordCheck;
	
	private String phone;
//	@Email
	private String email;
//	@Past
	private LocalDate birth;
	
	private ProfileDTO profileDTO;
	
}
