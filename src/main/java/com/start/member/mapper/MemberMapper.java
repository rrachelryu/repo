package com.start.member.mapper;

import java.util.List;

import com.start.member.dto.MemberDTO;
import com.start.security.dto.SecurityDTO;

public interface MemberMapper {

	void join(MemberDTO member);
	MemberDTO findById(Long memberId);
	int insertMemberInfo(MemberDTO paramDTO);
	
}
