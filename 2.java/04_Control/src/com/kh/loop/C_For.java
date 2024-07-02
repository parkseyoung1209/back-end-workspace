package com.kh.loop;

import java.util.Scanner;

public class C_For {
	
	Scanner sc = new Scanner(System.in);

	/*
	 * for문 
	 * 
	 * for(초기식; 조건식; 증감식) {
	 * 		실헹 코드
	 * }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문
	 * - 초기식 : 반복문이 수행될 때 단 한 번만 실행,
	 * 			반복문 안에서 사용할 변수를 선언하고 초기값 대입
	 * - 조건식 : 결과가 true이면 실행 코드를 실행, 
	 * 			false이면 실행하지 않고 반복문을 빠져나감
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용
	 */
	
	// 1 ~ 5 출력
	public void method1() {
		for(int i = 1; i<6; i++) {
			System.out.println(i);
		}
	}
	
	// 1~ 5 반대로 출력
	public void method2() {
		for(int i = 5; i>0; i--) {
			System.out.println(i);
		}
	}
	public void method3() {
	// 1~10 사이의 홀수만 출력
		for(int i = 1; i <=10; i++) {
			if(i%2 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}
	
	/*
	 * continue문
	 * - continue문은 반복문 안에서 사용
	 * - 반복문 안에서 continue를 만나면 '현재 구문' 종료
	 * - 반복문을 빠져나가는 건 아님! 다음 반복을 계속 수행
	 * 
	 */
	public void method4() {
		int number = 0;
		for(int i = 1; i <=10; i++) {
			number += i; //== number = number + i;
		}
		System.out.println(number);
	}
	
	public void method5() {
		System.out.println("1부터 n까지의 수의 합을 구해보자 / n입력 : ");
		int n = sc.nextInt();
		int result = 0;
		for(int i=1; i<=n; i++) {
			result += i;
		}
		System.out.println(result);
	}
	public void method6() {
		/*
		 * java.lang.Math 클래스에서 제공하는 random() 메서드
		 * 호출할 때 마다 매번 다른 랜덤값을 얻어낼 수 있음
		 */
		double random = Math.random(); //0.0 <= random < 1.0
		random = Math.random() * 10; //0.0 <= random <10.0
		random = Math.random() * 10 +1 ; //1.0 <= random <11.0
		System.out.println((int)random); // int로 바꿔서 소수점은 제외
		
		// 결론적으로 1부터 10 사이의 수가 랜덤하게 출력된다
		
	}
	public void method7() {
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		
		
		for(int i = 0; i <= (str.length()-1); i++) {
			System.out.println(str.charAt(i));
		}
		
		/*
		 * 향상된 for문
		 * for(데이터타입 변수 : 배열) {
		 * 		변수 : 배열의 값을 하나씩 가지고 옴
		 * }
		 * 
		 * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열
		 * - String.charAt(int index) : 인덱스에 있는 문자를 char 형식으로 변환
		 * - String.toCharArray() : 모든 문자가 들어있는 char[] 형식의 데이터 반환
		 * - String.matches("정규분포식") : 특정 문자나 숫자만 오게끔 가능
		 */
		char[] arr = str.toCharArray();
		for(char ch : arr) {
			System.out.println(ch);
		}
	}
	// 구구단 - 2단 출력
	public void method8() {
		int num = 0;
		for(int i=2; i<=2; i++) {
			for(int j = 1; j<=9; j++) {
				num = i*j;
				System.out.println(i + "*" + j + "=" + num);
			}
		}
	}
	public void method9() {
		int num = 0;
		for(int i =2; i<10; i++) {
			for (int j=1; j<=9; j++) {
				num = i*j;
				System.out.println(i + "*" + j + "=" + num);
			}
		}
	}
	public void method10() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void method11() {
		
		for(int i = 0; i <5; i++) {
			for(int j = 0; j < 5; j++) {
				if(i == j) {
					System.out.print(i+1);
				}else {
					System.out.print("*");
				}
			}System.out.println();
		}
	}
	public void method12() {
		for(int i = 1; i < 7; i++) {
			for(int j = 1; j <=i; j++ ) {
				System.out.print("*");
			}System.out.println();
		}
	}
	
	public void method13() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(j>=4-i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}System.out.println();
		}
	}
	public static void main(String[] args) {
		C_For c= new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
//		c.method11();
//		c.method12();
//		c.method13();

		
	}
}
