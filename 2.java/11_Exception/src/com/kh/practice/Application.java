package com.kh.practice;

import java.util.Scanner;

import com.kh.practice.controller.MemberController;
import com.kh.practice.exception.DuplicateNameException;
import com.kh.practice.exception.RecordNotFoundException;
import com.kh.practice.model.Member;

public class Application {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	private Member member = new Member();

	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
		
	}
	/*
	 * 회원 수는 3명이 최대 등록 가능
	 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다." 와 함께
	 * 1. 새 회원 등록하지 못하게 화면상 보이지 않게 처리
	 * 
	 * 최대 등록 가능한 회원 수는 3명입니다.
	 * 현재 등록된 회원 수는 ~~명입니다.
	 * 1. 새 회원 등록 -> insertMember()
	 * 2. 회원 정보 수정 -> updateMember()
	 * 3. 전체 회원 정보 출력 -> printAll()
	 * 9. 끝내기 -> 프로그램 종료
	 * 그 외의 번호 -> 잘못 입력하셨습니다.
	 * 
	 * 메뉴 번호 :
	 * 
	 */
	
	public void mainMenu() {
		int logic = 1;
		while(logic == 1) {
				System.out.printf("최대 등록 가능한 회원 수는 %d명입니다.\n", 3);
				System.out.printf("현재 등록된 회원 수는 %d명입니다.\n", mc.count);
				if(mc.count < 3) {
					System.out.println("1. 새 회원 등록");
				} else {
					System.out.println("회원 수가 모두 꽉 찾기 때문에 일부 메뉴만 오픈됩니다.");
				}
				System.out.println("2. 회원 정보 수정");
				System.out.println("3. 전체 회원 정보 출력");
				System.out.println("9. 끝내기");
				System.out.print("번호를 입력해주세요 : ");
				try {
				int enter = Integer.parseInt(sc.nextLine());
					switch(enter) {
					case 1 :
						insertMember();
						break;
					case 2 :
						updateMember();
						break;
					case 3 :
						printAll();
						break;
					case 9 :
						System.out.print("프로그램을 종료합니다");
						logic = 0;
						break;
					
					default :
						System.out.println("잘못입력했습니다");
						break;
				}
			}catch(NumberFormatException e) {
				System.out.println("잘못입력했습니다");
			}
			
		}
		
	}
		
	
	/* 멤버 정보 추가 기능 모두!
	 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
	 * "중복된 아이디입니다. 다시 입력해주세요." 출력 후
	 * 다시 아이디 입력부터 나올 수 있게 처리
	 * 
	 * 아이디 :
	 * 이름 :
	 * 비밀번호 :
	 * 이메일 :
	 * 성별(m/f) :
	 * 나이 :
	 */
	public void insertMember() {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			
			try {
				if(mc.checkId(id)!=-1) {
				}else {
				System.out.print("이름 : ");
				String name = sc.nextLine();
				System.out.print("비밀번호 : ");
				String pwd = sc.nextLine();
				System.out.print("이메일 : ");
				String email = sc.nextLine();
				System.out.print("성별(m/f) : ");
				char gender = sc.nextLine().charAt(0);
				System.out.print("나이 : ");
				int age = Integer.parseInt(sc.nextLine());
				Member m = new Member(id, name, pwd, email, gender, age);
				mc.MemberController(m);
				}
			} catch(DuplicateNameException e) {
				System.out.println(e.getMessage());
				insertMember();
			}
			
			
	}
	/*
	 * 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
	 * "회원 정보가 없습니다." 출력 후 다시 메인 화면으로
	 * 
	 * 수정할 회원의 아이디:
	 * 수정할 이름:
	 * 수정할 이메일:
	 * 수정할 비밀번호:
	 */
	public void updateMember() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		try {
		if(mc.checkUpdateId(id) == -1) {
			System.out.println("회원 정보가 없습니다");
			return;
		}
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String pwd = sc.nextLine();
		mc.updateMember(id, name, pwd, email);
		}catch(RecordNotFoundException e) {
			e.getMessage();
		}
	}
	/*
	 * 전체 회원 정보 출력 (반복문 사용)
	 * 
	 */
	public void printAll() {
		Member[] arr = mc.printAll();
		for(Member m : arr) {
			if(m!=null) System.out.println(m);
		}
	}
	public void error() throws NumberFormatException{
		
	}
}

