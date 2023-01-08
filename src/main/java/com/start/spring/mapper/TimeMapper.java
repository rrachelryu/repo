package com.start.spring.mapper;

import org.apache.ibatis.annotations.Select;

import com.start.member.dto.MemberDTO;

public interface TimeMapper {

	@Select("select sysdate from dual")
	String getTime();
	
	String getTime2();
	
	MemberDTO findById(Long memberId);
}
