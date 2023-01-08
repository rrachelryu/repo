package com.start.security.dto;

import java.sql.Date;

import com.start.member.dto.Grade;

import lombok.Data;

@Data
public class SecurityDTO {

	private String username;
	private String password;
	private String pwSalt;
	private String regDate;
	private String chgDate;
	
}
