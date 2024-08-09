package com.kh.ajax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ajax.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private mapper.MemberMapper memberMapper;
	
	public Member checkId(String id) {
		return memberMapper.checkId(id);
	}
	public void register(Member member) {
		memberMapper.register(member);
	}
}
