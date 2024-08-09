package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.model.vo.Member;
import com.kh.ajax.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class AjaxController {
	private int count=0;
	@Autowired
	private MemberService service;
	
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax로 요청이 들어옴!");
		return ++count;
	}
	
	@ResponseBody
	@GetMapping("/encoding")
	public String nickname(String nickname) {
		return nickname;
	}
	
	@ResponseBody
	@PostMapping("/register")
	public boolean checkId(String id, Member vo) {
		Member member = service.checkId(id);
		System.out.println(member);
		if(member!=null) {
			return false;
		}else {
			return true;
		}
	}
	
	@ResponseBody
	@PostMapping("/serial")
	public void register(Member vo) {
		System.out.println(vo);
		service.register(vo);
	}
}
