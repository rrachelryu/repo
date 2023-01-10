package com.start.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.start.member.dto.MemberDTO;
import com.start.security.service.SecurityService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequiredArgsConstructor
public class LoginController {
	
	private final SecurityService securityService;

	@GetMapping("/login")
	public String loginPage(HttpServletRequest request) {
		log.info("login.....");
		HttpSession session = request.getSession(false);
		if(session != null) session.invalidate();
		return "/loginpage";
	}
	
	@PostMapping("/log-out")
	public String loginOut(HttpServletRequest request) {
		log.info("log-out.....");
		HttpSession session = request.getSession(false);
	    session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("/login-success")
	public String loginSuccess(HttpServletRequest request, Model model) {
		log.info("login-success.....");
		HttpSession session = request.getSession(false);
		log.info(session.toString());
//	    if(session == null) {
//	        return "redirect:/login";
//	    }
	    String username = (String)session.getAttribute("LOGIN_MEMBER");
	    
	    MemberDTO memberInfo = securityService.loginCheck(username);
	    
	    if(memberInfo == null) {
	    	return "redirect:/login";
	    }
	    
	    model.addAttribute("memberInfo", memberInfo);
	    
		return "/loginSuccess";
	}
	
	@GetMapping("/signup")
	public String signup(HttpServletRequest request) {
		log.info("signup.....");
		HttpSession session = request.getSession(false);
	    session.invalidate();
		return "/signup";
	}
}
