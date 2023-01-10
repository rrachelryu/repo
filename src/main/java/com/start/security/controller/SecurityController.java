package com.start.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.start.member.dto.MemberDTO;
import com.start.security.dto.SecurityDTO;
import com.start.security.service.SecurityService;
import com.start.security.util.SessionManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/security")
@RequiredArgsConstructor
public class SecurityController {

	private final SecurityService service;
	
	private final SessionManager sessionManager;
	
	private static final String sessionId = "LOGIN_MEMBER"; // 다른파일로 빼야함

	@PostMapping(value="/login",produces="application/json")
	public ResponseEntity<String> login(@RequestBody SecurityDTO securityDTO, HttpServletRequest request) {
		SecurityDTO userInfo = service.login(securityDTO);
	    
		HttpSession session = request.getSession();
	    session.setAttribute(sessionId, userInfo.getUsername());
		
		return new ResponseEntity<>(userInfo.getUsername(), HttpStatus.OK);
	}
	
	@PostMapping(value="login-check",produces="application/json")
	public ResponseEntity<String> login(HttpServletRequest request) {
		log.info("login-check..........");
		HttpSession session = request.getSession(false);
		log.info(session);
	    if(session == null) {
	        return new ResponseEntity<>("NOT LOGIN.....", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    String memberId = (String)session.getAttribute(sessionId);
	    log.info(memberId);
	    if(memberId == null || memberId.isEmpty()) {
	    	return new ResponseEntity<>("NOT LOGIN.....", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		return new ResponseEntity<>(memberId, HttpStatus.OK);
	}
	
	@PostMapping(value="/signup",produces="application/json")
	public ResponseEntity<String> signUp(@RequestBody ObjectNode jsonObject, HttpServletRequest request) {
		ObjectMapper mapper = new ObjectMapper();
		SecurityDTO securityDTO = null;
		MemberDTO memberDTO = null;
		
		try {
			securityDTO = mapper.treeToValue(jsonObject.get("securityDTO"), SecurityDTO.class);
			memberDTO = mapper.treeToValue(jsonObject.get("memberDTO"), MemberDTO.class);
		} catch (JsonProcessingException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		try {
			service.insertUserInfo(securityDTO, memberDTO);

			HttpSession session = request.getSession();
		    session.setAttribute(sessionId, securityDTO.getUsername());
		}  catch (DataAccessException de) {
			de.printStackTrace();
			log.info("Controller Data Exception..............");
			return new ResponseEntity<>("Fail SignUp........", HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			log.info("Controller Exception..............");
			e.printStackTrace();
			return new ResponseEntity<>("Fail SignUp........", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@PutMapping("/update-user-info")
	public ResponseEntity<Integer> updateUserInfo(SecurityDTO paramDTO) {

		Integer result = service.updateUserInfo(paramDTO);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-user-info")
	public ResponseEntity<Integer> deleteUserInfo(SecurityDTO paramDTO) {
		
		Integer result = service.deleteUserInfo(paramDTO);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
