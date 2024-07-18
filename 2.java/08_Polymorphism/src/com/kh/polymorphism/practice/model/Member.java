package com.kh.polymorphism.practice.model;

import java.util.Arrays;

import com.kh.polymorphism.practice.model.parents.Book;

public class Member extends Book{
	private String name;
	private int coupon;
	private int age;
	private Book[] booklist = new Book[2];
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String name, int coupon, int age, Book[] booklist) {
		super();
		this.name = name;
		this.coupon = coupon;
		this.age = age;
		this.booklist = booklist;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book[] getBooklist() {
		return booklist;
	}
	public void setBooklist(Book[] booklist) {
		this.booklist = booklist;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", booklist="
				+ Arrays.toString(booklist) + "]";
	}
	
	

}
