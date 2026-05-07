package com.grey.app.member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.checkerframework.checker.regex.qual.Regex;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class MemberDTO implements UserDetails{
	
	
	@NotBlank(groups = GroupAdd.class, message = "ID는 필수입니다.")
	private String username;
	
	@NotBlank(groups = {GroupAdd.class, GroupUpdate.class})
	private String name;
	
	@Size(groups =GroupAdd.class,  min=2,max=10)
	@NotBlank(groups =  GroupAdd.class)
	private String password;
	
	private String passwordCheck;
	
	private String phone;
	
	@Email(groups = {GroupAdd.class, GroupUpdate.class})
	private String email;
	
	@Past(groups = {GroupAdd.class, GroupUpdate.class})
	private LocalDate birth;
	
	private boolean accountNonExpired;
	
	private boolean accountNonLocked;
	
	private boolean credentialsNonExpired;
	
	private boolean enabled;
	
	
	private ProfileDTO profileDTO;
	
	private List<RoleDTO> roles; 


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> ar = new ArrayList<>();
		
		for(RoleDTO roleDTO:roles) {
			GrantedAuthority g = new SimpleGrantedAuthority(roleDTO.getRoleName());
			ar.add(g);
		}
		
		return ar;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return UserDetails.super.isAccountNonExpired();
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return UserDetails.super.isAccountNonLocked();
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return UserDetails.super.isCredentialsNonExpired();
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return UserDetails.super.isEnabled();
	}

	
	
	
	
	
}
