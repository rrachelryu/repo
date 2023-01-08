package com.start.security.mapper;

import com.start.security.dto.SecurityDTO;

public interface SecurityMapper {
	
	SecurityDTO login(SecurityDTO paramDTO);

	int insertUserInfo(SecurityDTO paramDTO);
	
	int updateUserInfo(SecurityDTO paramDTO);
	
	int deleteUserInfo(SecurityDTO paramDTO);
}
