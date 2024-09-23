package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.semi.youtube.model.vo.Member;
import com.semi.youtube.security.config.TokenProvider;
import com.semi.youtube.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	// 중복확인
	@Autowired
	private MemberService member;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@ResponseBody
	@PostMapping("/check")
	public boolean check(String id) {
		return member.check(id);
	}
	// 로그인
	@ResponseBody
	@PostMapping("/login")
	public String login(Member vo) {
		Member result = member.login(vo);
		if(result!=null) {
			String token = tokenProvider.create(result);
			System.out.println(token);
		}
		return "login";
	}
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
