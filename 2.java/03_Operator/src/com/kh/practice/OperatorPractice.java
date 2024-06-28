package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
    Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		OperatorPractice o = new OperatorPractice();
//		o.method1();
//		o.method2();
//		o.method3();
//		o.method4();
		o.method5();
		o.method6();
		o.method7();
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
	System.out.println("인원 수를 입력해주세요 : ");
	int people = Integer.parseInt(sc.nextLine());
	System.out.println("연필 개수를 입력해주세요 : ");
	int pencil = Integer.parseInt(sc.nextLine());
	int things = pencil/people;
	int charge = pencil%people;
	System.out.println("동일하게 나눠 가진 연필 개수 : " + things + " 남은 연필의 개수" + charge);
	

	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.println("숫자를 입력해주세요 : ");
		int number1 = Integer.parseInt(sc.nextLine());
		number1 = number1 - (number1%100);
		System.out.println(number1);
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.println("첫번째 숫자를 입력해주세요 : ");
		int number2 = Integer.parseInt(sc.nextLine());
		System.out.println("두번째 숫자를 입력해주세요 : ");
		int number3 = Integer.parseInt(sc.nextLine());
		System.out.println("세번째 숫자를 입력해주세요 : ");
		int number4 = Integer.parseInt(sc.nextLine());
		
		boolean result = number2 == number3 && number3 == number4;
		System.out.println(result);

	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.println("숫자를 입력해주세요 : ");
		int number5 = Integer.parseInt(sc.nextLine());
		String result = number5%2 == 0 & number5!=0 ? "짝수입니다" : "짝수가 아닙니다";
		System.out.println(result);
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		System.out.println("주민번호를 입력하세요(-포함) : ");
		String no = sc.nextLine();
		int result = no.charAt(7); 
		
	
		System.out.println(result); // 49 <-- 
		boolean women = no.length() == 14 && (result == 50 || result == 52);
		
		String result2 = no.length() == 14 && (result == 49 || result == 51) ? "남자" : women ? "여자" : "한국인이 아님";
		// 결론 : int result로 잡게 되면 문자열 '1', '2'... 등을 실제 정수 값 49, 50으로 변환시키기 때문에 result 값에 따옴표 없는 숫자를 넣고 싶다면 해당하는 실제 숫자값을 넣어야된다
		System.out.println(result2);
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.println("나이를 입력해보세요 : ");
		int age = Integer.parseInt(sc.nextLine());
		String result = age>19 ? "성인" : age<=19 && age >13 ? "청소년" : "어린이";
		
		System.out.println(result);
		
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.println("가지고 있는 사과 개수 : ");
		int apple = Integer.parseInt(sc.nextLine());
		System.out.println("바구니 크기 : ");
		int bascket = Integer.parseInt(sc.nextLine());
		
		int needs = apple/bascket;
		int result = apple%bascket == 0 ? needs : needs+1;
		
		System.out.println("필요한 바구니 수 : " + result);
		
	}
	
}