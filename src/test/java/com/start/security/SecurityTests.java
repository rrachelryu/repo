package com.start.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.start.security.util.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SecurityTests {

	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Test
	public void test1() {
		String pw = "1111";
		
		String salt = pwEncoder.getSalt();
		
		log.info(salt);
		
		String enPw = pwEncoder.enPassword(pw, salt);
		
		boolean matched = pwEncoder.isEquaslPassword(pw, enPw, salt);
		
		log.info(matched);
		
		log.info(enPw);
	}
}
