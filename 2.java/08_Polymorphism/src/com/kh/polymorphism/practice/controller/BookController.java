package com.kh.polymorphism.practice.controller;

import com.kh.polymorphism.practice.model.Member;
import com.kh.polymorphism.practice.model.parents.Book;

public class BookController {
	public int num = 0;
	Member member = new Member();
	Book book = new Book();
	Book[] books = {new Book("밥을 지어요," , true, 0), new Book("오늘은 아무래도 덮밥" , false, 0), new Book("원피스 108", false, 15),
			new Book("귀멸의 칼날 23" , false, 19)};
	
	public void addMember(String name, int age) {
		member.setName(name);
		member.setAge(age);
	}
	
	public Member myPage() {
		return member;
		}
	}
	
	
	

