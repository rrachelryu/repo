package com.start.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.start.member.dto.MemberDTO;
import com.start.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	@GetMapping("/list")
	public void member(Model model) {
		model.addAttribute("list", service.findMember(1L));
		log.info("_____________"+model);
	}
	
	@PostMapping("/join")
	public String memberJoin(MemberDTO dto, RedirectAttributes rttr) {
		
		service.join(dto);
		rttr.addFlashAttribute("result", dto.getMno());
		
		return "redirect:/member/find";
	}
}
