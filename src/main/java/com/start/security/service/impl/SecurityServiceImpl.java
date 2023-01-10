package com.start.security.service.impl;

import java.security.MessageDigest;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.start.member.dto.MemberDTO;
import com.start.member.mapper.MemberMapper;
import com.start.member.service.MemberService;
import com.start.security.dto.SecurityDTO;
import com.start.security.mapper.SecurityMapper;
import com.start.security.service.SecurityService;
import com.start.security.util.PasswordEncoder;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
public class SecurityServiceImpl implements SecurityService {

	private final SecurityMapper securityMapper;

	private final MemberMapper memberMapper;

//	private final org.springframework.security.crypto.password.PasswordEncoder pwEncoder;

	private final PasswordEncoder pwEncoder;

	@Override
	public MemberDTO loginCheck(String username) {
		Optional<MemberDTO> loginCheck = securityMapper.loginCheck(username);
		MemberDTO memberInfo = loginCheck.orElse(null);
		return memberInfo;
	}

	@Override
	public SecurityDTO login(SecurityDTO paramDTO) {

		SecurityDTO userInfo = securityMapper.login(paramDTO);

		boolean pwCheck = pwEncoder.isEquaslPassword(paramDTO.getPassword(), userInfo.getPassword(),
				userInfo.getPwSalt());

		if (!pwCheck) {
			log.info("Not Matched!!!!!!!!!!!");
			return null;
		}
		;

		return userInfo;
	}

	@Override
	@Transactional
	public int insertUserInfo(SecurityDTO securityDTO, MemberDTO memberDTO) throws Exception {
		int resultCnt = 0;
//		String enPw = pwEncoder.encode(securityDTO.getPassword());
		String salt = pwEncoder.getSalt();
		String enPw = pwEncoder.enPassword(securityDTO.getPassword(), salt);
		securityDTO.setPassword(enPw);
		securityDTO.setPwSalt(salt);

		memberDTO.setUsername(securityDTO.getUsername());
		resultCnt += securityMapper.insertUserInfo(securityDTO);
		resultCnt += memberMapper.insertMemberInfo(memberDTO);

		if (resultCnt != 2) {
			throw new Exception("Fail Singup......");
		}

		return resultCnt;
	}

	@Override
	public int updateUserInfo(SecurityDTO securityDTO) {
		return securityMapper.updateUserInfo(securityDTO);
	}

	@Override
	public int deleteUserInfo(SecurityDTO securityDTO) {
		return securityMapper.deleteUserInfo(securityDTO);
	}

}
