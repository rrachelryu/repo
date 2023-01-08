package com.start.spring.mapper;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	
	@Test
	public void testConn2() throws Exception{
		
		SqlSession session = sqlSessionFactory.openSession();
		
		log.info(session);
		
		session.close();
		
	}
	
	
	@Test
	public void testConn() throws Exception{
		
		Connection con = ds.getConnection();
		
		log.info(con);
		
		con.close();
		
	}
}
