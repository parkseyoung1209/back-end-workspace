package com.kh.step3;

public class Application {

	public static void main(String[] args) {
		/*
		 * 변수 호출 방법
		 * - 참조변수.변수;
		 * 
		 * 메서드 호출 방법
		 * - 참조변수.메서드명();
		 * - 참조변수.메서드명(값1,2, ...); // 매게변수가 있는 경우
		 * 
		 */
		Calculator c = new Calculator();
		c.a = 11;
		c.b = 3;
		System.out.println("더하기 : " + c.add());
		System.out.println("빼기 : " + c.substract());
		System.out.println("곱하기 : " + c.multiply(100, 200));
		System.out.println("나누기 : " + Calculator.devide(c.b, c.a));
		
		System.out.println(c.factorial(4));
		System.out.println("팩토리얼: " + c.factorial2(4));
	}

}
