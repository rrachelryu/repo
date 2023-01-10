package com.start.member.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDTO {

	private long mno;
	private String memNm;
	private String username;
	private Grade grade;
	private String regDate;
	private String chgDate;
	
}
