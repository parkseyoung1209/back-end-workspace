package com.kh.practice1;

import com.kh.practice1.model.Member;

public class Application {
	public static void main(String[] args) {
		Member member = new Member();
		member.changeName("박세영");
		member.printName();
	}
}
