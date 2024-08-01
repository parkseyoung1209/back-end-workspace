package com.kh.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allMember", service.allMember());
		return "index";
	}
	@GetMapping("/register")
	public String register() {
		return "mypage/register";
	}
	
	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/";
	}
	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}
	@PostMapping("/login")
	public String login(HttpServletRequest request, Member vo) {
		HttpSession session = request.getSession();
		session.setAttribute("vo", service.login(vo));
		return "redirect:/";
	}
	@PostMapping("/update")
	public String update(HttpServletRequest request, Member vo) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		System.out.println(vo);
		if(vo.getId()==null && vo.getName()==null) {
			vo.setId(member.getId());
			vo.setName(member.getName());
			service.update(vo);
		}
		service.update(vo);
		session.setAttribute("vo", vo);
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String search(SearchDTO dto, Model model) {
		model.addAttribute("search", service.search(dto));
		return "index";
	}
	@PostMapping("/delete")
	public String delete(@RequestParam(name="idList", required=false) List<String> idList) {
		if(idList!=null) service.delete(idList);
		return "redirect:/";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		if(member!=null) session.invalidate();
		return "redirect:/";
	}
}
