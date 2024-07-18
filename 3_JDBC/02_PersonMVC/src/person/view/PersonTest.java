package person.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import person.controller.PersonController;
import person.model.Person;

public class PersonTest {
	PersonController pc = new PersonController();
	Person person = new Person();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonTest pt = new PersonTest();
		while(true) {
			System.out.println("=====원하시는 메뉴를 골라주세요=====");
			System.out.println("1.회원 추가");
			System.out.println("2.회원 정보 수정");
			System.out.println("3.회원 삭제");
			System.out.println("4.전체 고객 정보");
			System.out.println("5.특정 고객 정보");
			try {
				System.out.print("메뉴를 골라주세요 : ");
			int menu = Integer.parseInt(sc.nextLine());
				switch(menu) {
				case 1:
					pt.addPerson();
					break;
				case 2:
					pt.updatePerson();
					break;
				case 3:
					pt.removePerson();
					break;
				case 4:
					pt.searchAllPerson();
					break;
				case 5:pt.searchPerson();
				default : 
					System.out.println("잘못 입력했습니다");
					break;
				}
			}catch(NumberFormatException e) {
				System.out.println("잘못 입력했습니다");
			}
		}
		// 이 부분은 테스트 용도로만!
	}
	// 리턴 타입이나 매개변수(파라미터) 자유롭게 변경 가능!
	/*
	 * 
	 * 1. 드라이버 로딩 ㅇ
	 * 2. DB 연결 ㅇ
	 * 3. PreparedStatement - 쿼리
	 * 4. 쿼리 실행
	 */
	// person 테이블에 데이터 추가 - INSERT
	public void addPerson() {
		// ~~님, 회원가입 완료!
		pc.addPerson();
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() {
		// ~~님 정보 수정 완료!
		pc.updatePerson();
	}
	
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() {
		pc.removePerson();
	}
	
	// person 테이블에 있는 전체 보여주기 - SELECT
	public void searchAllPerson() {
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person i : list) {
			System.out.println(i);
			
		}
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson() {
		pc.searchPerson();
		
	}
	
}
