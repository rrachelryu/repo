package com.start.security.service;

import com.start.member.dto.MemberDTO;
import com.start.security.dto.SecurityDTO;

public interface SecurityService {

	SecurityDTO login(SecurityDTO paramDTO);
	
	int insertUserInfo(SecurityDTO securityDTO);
	
	int updateUserInfo(SecurityDTO paramDTO);
	
	int deleteUserInfo(SecurityDTO paramDTO);
}
