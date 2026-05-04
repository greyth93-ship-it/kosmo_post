package com.grey.app.aop.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class TransportTest {

	@Autowired
	private Transport transport;
	
	@Autowired
	private Card card;
	
	@Test
	@Rollback(false)
	void test() {
		
		transport.takeSubway("yellow");
		
		transport.takeBus(50);
	}

}
