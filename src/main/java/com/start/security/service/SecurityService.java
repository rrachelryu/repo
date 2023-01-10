package com.start.security.service;

import com.start.member.dto.MemberDTO;
import com.start.security.dto.SecurityDTO;

public interface SecurityService {

	MemberDTO loginCheck(String username);

	SecurityDTO login(SecurityDTO paramDTO);
	
	int insertUserInfo(SecurityDTO securityDTO, MemberDTO memberDTO) throws Exception;
	
	int updateUserInfo(SecurityDTO paramDTO);
	
	int deleteUserInfo(SecurityDTO paramDTO);
}
