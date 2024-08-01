package com.kh.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	public List<Member> allMember() {
		return memberMapper.allMember();
	}
	public void register(Member member) {
		memberMapper.register(member);
	}
	public Member login(Member member) {
		return memberMapper.login(member);
	}
	public void update(Member member) {
		memberMapper.update(member);
	}
	public List<Member> search(SearchDTO dto) {
		return memberMapper.search(dto);
	}
	public void delete(List<String> idList) {
			memberMapper.delete(idList);
	}
}
