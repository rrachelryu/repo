package com.start.spring.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.start.member.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	TimeMapper mapper;
	@Autowired
	MemberMapper memMapper;
	
	@Test
	public void getMemberTest() {
		log.info(memMapper.findById(1L));
	}
	
	
	@Test
	public void testGetTime2() {
		log.info(mapper.getTime2());
	}
	
	@Test
	public void testGetTime() {
		log.info(mapper.getTime());
	}

}
