package com.semi.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.semi.youtube.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private MemberMapper member;
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	public boolean check(String id) {
		Member vo = member.check(id);
		if(vo!=null) return true;
		return false;
	}
	
	public Member login(Member vo) {
		Member member2 = member.login(vo);
		member2.setPassword(bcpe.encode(member2.getPassword()));
		
		System.out.println(vo);
		System.out.println(member2);
		if(member!=null && bcpe.matches(vo.getPassword(), member2.getPassword())) {
			return member2;
		}
		return null;
	}
}

