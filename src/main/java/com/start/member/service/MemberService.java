package com.start.member.service;

import com.start.member.dto.MemberDTO;

public interface MemberService {

	void join(MemberDTO member);
	MemberDTO findMember(Long memberId);
}
