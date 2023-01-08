package com.start.member.service.impl;

import org.springframework.stereotype.Service;

import com.start.member.dto.MemberDTO;
import com.start.member.mapper.MemberMapper;
import com.start.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberMapper memMapper;
	
	@Override
	public void join(MemberDTO member) {
		
		memMapper.join(member);
		
	}

	@Override
	public MemberDTO findMember(Long memberId) {
		// TODO Auto-generated method stub
		
		return memMapper.findById(memberId);
	}

	
}
