package com.kh.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.BookRent;
public class Controller2 {
	
	private RentDAO rent = new RentDAO();
	// 1. 책 대여
	public boolean rentBook(int memberNo, int bookNo) {
		
		try {
			if(!rent.rentBook(memberNo, bookNo)) {
				// 이미 대여된 책이 없으면 대여 가능!
				rent.rentBook(memberNo, bookNo);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	// 2. 내가 대여한 책 조회
	public ArrayList<BookRent> printRentBook(int memberNo) {
		try {
			rent.printRentBook(memberNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 3. 대여 취소
	public boolean deleteRent(int no) {
		try {
			if(rent.deleteRent(no) == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 5. 회원 탈퇴
	public void deletemember(int memberNo) {
		if(member.deleteMember(memberNo())) {
			// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
			System.out.println("회원탈퇴 하였습니다 ㅠㅠ");
		} else {
			;// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
		}
		//
	}
}
