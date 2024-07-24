package com.kh;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.model.BookJoin;
import com.kh.model.vo.Book;
import com.kh.model.vo.BookRent;

// 스키마 : sample
// 테이블 : member, book, publisher, rent

public class Application {
	BookController bc = new BookController();
	BookJoin bj = new BookJoin();
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {

		Application app = new Application();
		app.mainMenu();

	}

	public void mainMenu() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		System.out.println("===== 도서 관리 프로그램 =====");

		boolean check = true;
		while (check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

	// 1. 전체 책 조회
	public void printBookAll() throws SQLException, ClassNotFoundException {
		// 반복문을 이용해서 책 리스트 출력
		bc.printBookAll();
		}
	

	// 2. 책 등록
	public void registerBook() throws SQLException {
		System.out.print("책 제목 : ");
		String bkTitle = sc.nextLine();
		bj.setBkTitle(bkTitle);
		System.out.print("책 저자 : ");
		String bkAuthor = sc.nextLine();
		bj.setBkAuthor(bkAuthor);
		bc.registerBook(bj.getBkTitle(), bj.getBkAuthor());
		if(!(bc.registerBook(bkTitle, bkAuthor))) {
			System.out.println("성공적으로 책을 등록했습니다");
		}else {
			System.out.println("책을 등록하는데 실패했습니다");
		}
		
		// 책 제목, 책 저자를 사용자한테 입력 받아
		// 기존 제목, 저자 있으면 등록 안되게
		// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
		// 실패하면 "책을 등록하는데 실패했습니다." 출력
	}

	// 3. 책 삭제
	public void sellBook() throws SQLException, ClassNotFoundException {
		bc.printBookAll();
		System.out.print("다음 책 중 삭제할 책을 골라주세요 : ");
		int bk_no = Integer.parseInt(sc.nextLine());
		bj.setBkNo(bk_no);
		boolean logic = bc.sellBook(bj.getBkNo());
		if(logic == true) {
			System.out.println("성공적으로 책을 삭제했습니다");
		}else {
			System.out.println("책을 삭제하는데 실패했습니다");
		}
		// printBookAll로 전체 책 조회를 한 후
		// 삭제할 책 번호 선택을 사용자한테 입력 받아
		// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
		// 실패하면 "책을 삭제하는데 실패했습니다." 출력
	}

	// 4. 회원가입
	public void registerMember() throws SQLException {
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		// 실패하면 "회원가입에 실패했습니다." 출력
		System.out.print("아이디 입력 : ");
		String member_id = sc.nextLine();
		bj.setMemberId(member_id);
		System.out.print("비밀번호 입력 : ");
		String member_pwd = sc.nextLine();
		bj.setMemberPwd(member_pwd);
		System.out.print("이름 입력 : ");
		String member_name = sc.nextLine();
		bj.setMemberName(member_name);
		boolean sign = bc.registerMember(bj.getMemberId(), bj.getMemberPwd(), bj.getMemberName());
		if(sign) {
			System.out.println("성공적으로 회원가입을 완료하였습니다");
		}else {
			System.out.println("회원가입에 실패했습니다");
		}
	}

	// 5. 로그인
	public void login() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		System.out.print("아이디 입력 : ");
		String member_id = sc.nextLine();
		bj.setMemberId(member_id);
		System.out.print("비밀번호 입력 : ");
		String member_pwd = sc.nextLine();
		bj.setMemberPwd(member_pwd);
		bc.loginInfo(bj.getMemberId(), bj.getMemberPwd());
		String name = bc.login(bj.getMemberId(), bj.getMemberPwd());
		try {
			if(!(name.equals(null))) {
				System.out.println(name + "님, 환영합니다!");
				memberMenu();
			}
		}catch(NullPointerException e) {
			System.out.println("로그인에 실패했습니다");
			login();
		}
		// 아이디, 비밀번호를 사용자한테 입력 받아 
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
	}

	public void memberMenu() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		boolean check = true;
		while (check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			}
		}
	}

	// 1. 책 대여
	public void rentBook() throws SQLException, ClassNotFoundException {
		bc.printBookAll();
		System.out.print("대여하실 책을 골라주세요 :");
		int bkNo = Integer.parseInt(sc.nextLine());
		bj.setBkNo(bkNo);
		
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
	}

	// 2. 내가 대여한 책 조회
	public void printRentBook() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		bc.printRentBook();
		
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
	}

	// 3. 대여 취소
	public void deleteRent() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
		printRentBook();
		System.out.print("대여 취소하실 책을 골라주세요 :");
		int rentNo = Integer.parseInt(sc.nextLine());
		bj.setRentNo(rentNo);
		boolean rn = bc.deleteRent(bj.getRentNo());
		if(rn) {
			System.out.println("성공적으로 대여를 취소했습니다");
		}else {
			System.out.println("실패.");
		}
	}

	// 4. 회원탈퇴\
	public void deleteMember() {
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
	}

}
