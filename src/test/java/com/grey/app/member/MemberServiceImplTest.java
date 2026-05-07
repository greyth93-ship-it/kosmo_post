package com.grey.app.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class MemberServiceImplTest {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	void setPassword() throws Exception {
		String s = passwordEncoder.encode("aa");
		System.out.println(s);
	}

}
