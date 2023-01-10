package com.start.security.mapper;

import java.util.Optional;

import com.start.member.dto.MemberDTO;
import com.start.security.dto.SecurityDTO;

public interface SecurityMapper {
	
	Optional<MemberDTO> loginCheck(String username);
	
	SecurityDTO login(SecurityDTO paramDTO);

	int insertUserInfo(SecurityDTO paramDTO);
	
	int updateUserInfo(SecurityDTO paramDTO);
	
	int deleteUserInfo(SecurityDTO paramDTO);
}
