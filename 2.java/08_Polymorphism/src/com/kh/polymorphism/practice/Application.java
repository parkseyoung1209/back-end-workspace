package com.kh.polymorphism.practice;

import java.util.Scanner;

import com.kh.polymorphism.practice.controller.BookController;
import com.kh.polymorphism.practice.model.Member;
import com.kh.polymorphism.practice.model.parents.Book;

public class Application {
	Scanner sc = new Scanner(System.in);
	Book[] books = {new Book("밥을 지어요," , true, 0), new Book("오늘은 아무래도 덮밥" , false, 0), new Book("원피스 108", false, 15),
			new Book("귀멸의 칼날 23" , false, 19)};
	BookController bc = new BookController();
	Member member = new Member();
	
	public static void main(String[] args) {
		Application app = new Application();
		app.menu();
	}
	public void menu() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		member.setName(name);
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		member.setAge(age);
		bc.addMember(member.getName(), member.getAge());
		boolean logic = true;
		while(logic) {
			System.out.println("====메뉴====");
			System.out.println("1.마이페이지");
			System.out.println("2.도서 대여하기");
			System.out.println("3.프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			try {
				int menu = Integer.parseInt(sc.nextLine());
					switch(menu) {
					case 1 : 
						bc.myPage();
						break;
					case 2 : 
						
						bookInfo();
						break;
					case 3:
						logic = false;
						break;
					default :
						System.out.println("잘못 입력하셨습니다");
						break;
					}
				}catch(NumberFormatException e) {
					System.out.println("잘못 입력하셨습니다");
				}
		}
	}
	
	public void bookInfo() {
		if(bc.num<member.getBooklist().length) {
			for(int i = 0; i < books.length; i++) {
				System.out.println((i+1) + "번 도서 : " + books[i]);
			}
			System.out.print("대여할 도서 번호 선택 : ");
			int select = Integer.parseInt(sc.nextLine());
			for(int j = 0; j<books.length; j++) {
				if(books[select-1].equals(member.getBooklist()[j])) {
					System.out.println("이미 대여한 도서입니다");
					break;
				}else {
					member.getBooklist()[bc.num] = books[select-1];
					if(books[0].isCoupon()) {
					
					}
					bc.num++;
					break;
				}
				
			}
		}else {
			System.out.println("더 이상 채울 수가 없습니다");
		}
	}
}
