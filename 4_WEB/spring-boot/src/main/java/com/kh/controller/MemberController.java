package com.kh.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.model.vo.Member;
import com.kh.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String index() {
		System.out.println("!!!!");
		return "index";
	}
	
	@GetMapping("register")
	public void register() {}
	
	@PostMapping("register")
	public String register(Member vo) throws ClassNotFoundException, SQLException {
		service.register(vo);
		return "redirect:/";
	}
	
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("login")
	public String login(Member vo, HttpServletRequest request) {
		try {
			Member member = service.login(vo);
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	@GetMapping("search")
	public void search() {}
	
	@GetMapping("find")
	public String find(@RequestParam("id") String id, Model model) {
		Member member = new Member();
		try {
			member = service.find(id);
			if(member!=null) {
			model.addAttribute(member);
			return "search_ok";
			}else {
			return "redirect:/fail";
			}
		} catch (SQLException | ClassNotFoundException e) {
		}
		return null;
	}
	@GetMapping("fail")
	public String fail() {
		return "search_fail";
	}
	
	@GetMapping("allMember")
	public String allMember(Model model) {
		try {
			List<Member> list = null;
			list = service.allMember();
			model.addAttribute("allList", list);
			return "allMember";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
}
