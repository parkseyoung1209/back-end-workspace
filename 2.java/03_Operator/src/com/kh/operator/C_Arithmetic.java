package com.kh.operator;

public class C_Arithmetic {
	/*
	 * 산술 연산자
	 *  + : 더하기
	 *  - : 빼기
	 *  * : 곱하기
	 *  / : 나누기
	 *  % : 나머지
	 * */

	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
		c.method1();
		c.method2();
	}
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println(" +  : " + (num1 + num2)); // 13
		System.out.println(" -  : " + (num1 - num2)); // 7
		System.out.println(" *  : " + (num1 * num2)); // 30
		System.out.println(" /  : " + (num1 / num2)); // 3
		System.out.println(" %  : " + (num1 % num2)); // 1
		
	}
	// 코드 정렬 깔끔하게 하고 싶다면!
	// 해당 영역 잡고! ctrl + shift + f
	// 그냥 하시면 주석까지 정렬을 해서 망가져요
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b; // c=16
		int d = c / a; // 16/6 = d=2
		int e = c % a; // e = 4
		int f = e++; // 4
		int g = (--b) + (d--); // g=9+2= 11
		int h = c-- * b; // h = 16 * 9 = 144
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); // 6 + 30 = 36
		
		
		// i 값은 얼마일까요?
		// 
		System.out.println(i);
	}
}
