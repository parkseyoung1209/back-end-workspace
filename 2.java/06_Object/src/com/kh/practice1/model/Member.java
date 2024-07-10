package com.kh.practice1.model;

import java.util.Scanner;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	public Member() {}
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public void printName() {
		System.out.println(name);
		
	}
	
}