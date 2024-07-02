package com.kh.condition;

import java.util.Scanner;

public class B_Switch {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * switch문
	 * 
	 * switch(조건식) {
	 * 		case 값1 : 
	 * 			조건식의 결과가 값1과 같은 경우 실행
	 * 			break;
	 * 		case 값2 : 
	 * 			조건식의 결과가 값2와 같은 경우 실행
	 * 			break;
	 * 		default :
	 * 			조건식의 결과와 일치하는 case문이 없을 때 실행
	 * }
	 * 
	 * - case문의 수는 제한이 없다
	 * - 조건식 결과는 정수, 문자, 문자열이어야 한다
	 * - 조건문을 빠져나가려면 break가 필요하다
	 * - default문은 생략 가능하다
	 * 
	 */
	public void method1() {
		/*
		 * 숫자를 입력받아
		 * 1일 경우 "빨간색입니다"
		 * 2일 경우 "파란색입니다"
		 * 3일 경우 "초록색입니다"
		 * 잘못입력했을 경우 "잘못입력했습니다"
		 * 
		 */
		System.out.print("숫자를 입력해보세요 : ");
		String number = sc.nextLine();
		
		switch(number) {
		case "1" : 
			System.out.println("빨간색입니다");
			break;
		case "2" : 
			System.out.println("파란색입니다");
			break;
		case "3" : 
			System.out.println("초록색입니다");
			break;
		default :
			System.out.println("잘못입력했습니다");
		}
	}
	public void practice1() {
		/*
		 * 주민번호를 입력받아 "남자"인지 "여자"인지 출력
		 * 주민번호 입력 : 100000-3000000
		 * 남자
		 * 
		 * String.valueOf : 문자열로 변환
		 * Integer.parseInt : 정수로 변환
		 */
		
		System.out.print("주민번호를 입력하세요('-'포함) : ");
		String no = sc.nextLine();
		String result = "";
	if (no.length() == 14 && no.charAt(6) == '-') {
		switch(no.charAt(7)) {
		case '1' :
			result = "남자";
			break;
		case '2' :
			result = "여자";
			break;
		case '3' :
			result = "남자";
			break;
		case '4' :
			result = "여자";
			break;
		default :
			result = "한국인이 아닌듯";
		}
		System.out.println(result);
	}else {
		System.out.println("형식이 잘못되었습니다");
	}
			
	}
	public void practice2() {
		/*
		 * 등급별 권한
		 * 1. 관리 권한, 글쓰기 권한, 읽기 권한
		 * 2. 글쓰기 권한, 읽기 권한
		 * 3. 읽기 권한
		 * 
		 * 등급 입력 : 1
		 * 관리 권한
		 * 글쓰기 권한
		 * 읽기 권한
		 */
		System.out.print("등급 입력 : ");
		int grade = Integer.parseInt(sc.nextLine());
		String admin = "관리 권한";
		String write = "글쓰기 권한";
		String read = "읽기 권한";
		switch(grade) {
		case 1 :
			System.out.printf("%s\n%s\n%s\n", admin, write, read);
			break;
		case 2 :
			System.out.printf("%s\n%s\n", write, read);
			break;
		case 3 :
			System.out.print(read);
		}

	
		
		
	}
	public static void main(String[] args) {
		B_Switch b = new B_Switch();
//		b.method1();
//		b.practice1();
		b.practice2();
	}

}
