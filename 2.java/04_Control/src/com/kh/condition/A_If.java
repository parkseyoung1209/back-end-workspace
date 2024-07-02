package com.kh.condition;

import java.util.Scanner;

public class A_If {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * 
	 * if문
	 * 
	 * if(조건식) {
	 * 	조건식이 참(true)일 때 실행
	 * }else {
	 * 	조건식이 거짓(false)일 때 실행 {
	 * }
	 * 
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	 */
	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다"를 출력
		System.out.println("성적 입력 : ");
		int score = Integer.parseInt(sc.nextLine());
		
		if(score >= 60) {
			System.out.println("합격입니다.");
		}
		// if(score >= 60) System.out.println("합격입니다") <- 이렇게도 사용 가능하다(한 줄일 경우만)
		
	}
	
	public void method2() {
		// 입력받은 성적이 60점 이상이면 "합격입니다", 아니면 "불합격입니다"를 출력
		System.out.println("성적 입력 : ");
		int score2 = Integer.parseInt(sc.nextLine());
		/*if(score2 >= 60 && score2 <=100) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}*/
		
		// 삼항연산자
		String result = score2 >=60 ? "합격입니다" : "불합격입니다";
		System.out.println(result);
	}
	public void method3() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"를 출력
		System.out.println("이름을 입력하시오 : ");
		String name = sc.nextLine();
		
		System.out.println(System.identityHashCode(name));
		System.out.println(System.identityHashCode("박세영"));
		if(name.equals("박세영")) {
			System.out.println("본인이다");
		}else {
			System.out.println("본인이 아니다");
		}
			
	}
	/*
	 * if - else if - else문
	 * 
	 * if(조건식1) {
	 * 	조건식1이 참(true)일 때 실행
	 *}else if (조건식 2) {
	 *	조건식1이 거짓(false) {
	 *}else { 
	 *	조건식1, 조건식2 모두 거짓(false)일 때 실행
	 * }
	 *	- else if는 수가 제한이 없다
	 */
	public void method4() {
		// 입력 받은 숫자가 0보다 크면 "양수" 0이면 "0이다" 작으면 "음수" 출력
		System.out.println("숫자 입력 : ");
		int number = Integer.parseInt(sc.nextLine());
		
		if (number>0) {
			System.out.println("양수");
		}else if(number == 0) {
			System.out.println("0이다");
		}else {
			System.out.println("음수");
		}
		
		// 삼항연산자
		String result = number>0 ? "양수" : number == 0 ? "0이다" : "음수";
		System.out.println(result);
		
		// if문
		if(number > 0) {
			System.out.println("양수");
		} else {
			if(number == 0) {
				System.out.println("0이다");
			} else {
				System.out.println("음수");
			}
		}
	} // => if문을 중첩해서 사용은 가능하나, 가급적으로는 사용을 권장하지 않는 코드이다.
	
	public void practice1() {
		/*
		 *  사용자에게 점수(0~100)를 입력받아서 점수별로 등급 출력
		 * 90점 이상은 a
		 * 90점 미만 80점 이상은 b
		 * 80>c>=70
		 * 70>d>=d
		 * 60>f
		 */
		System.out.println("점수 입력 : ");
		int score = Integer.parseInt(sc.nextLine());
	if(score <=100 && score >=0) {
		if (score >= 90) {
			System.out.println("A");
		}else if(score>=80) {
			System.out.println("B");
		}else if(score>=70) {
			System.out.println("C");
		}else if (score>=60) {
			System.out.println("D");
		}else{
			System.out.println("F");
		}
	}else {
			System.out.println("점수를 잘못 입력했습니다.");
	  }
	}
	
	public void practice2() {
		/*
		 * 세 정수를 입력했을 때 짝수만 출력
		 * 
		 * num1 입력 : 3
		 * num2 입력 : 4
		 * num3 입력 : 6
		 * 4
		 * 6
		 * 
		 */
		System.out.println("숫자 1 입력 :");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("숫자 2 입력 :");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.println("숫자 3 입력 :");
		int num3 = Integer.parseInt(sc.nextLine());
		
	
		
		if(num1%2 == 0 ) {
			System.out.println(num1);
		} 

		if(num2%2 == 0 ) {
			System.out.println(num2);
		} 
	
		if(num3%2 == 0 ) {
			System.out.println(num3);
		} 
	}
	public void practice3() {
		/*
		 * 정수 1개를 입력했을 때 음(minus), 양(plus), 0, 짝(even)/홀(odd) 출력
		 * 
		 * 정수 입력 : -3
		 * minus
		 * odd
		 * 
		 */
		System.out.println("정수 입력 :");
		int number3 = Integer.parseInt(sc.nextLine());
		
	
		if(number3>0) {
			System.out.println("plus");
			if(number3%2 == 0 && number3 != 0) {
				System.out.println("even");
			}else if (number3%2 != 0){
				System.out.println("odd");
			}else {
				System.out.println("");
			}
		}else if(number3 == 0) {
			System.out.println("zero");
		}else {
			System.out.println("minus");
			if(number3%2 == 0 && number3 != 0) {
				System.out.println("even");
			}else if (number3%2 != 0){
				System.out.println("odd");
			}else {
				System.out.print("");
			}
		}
		
	}
	public static void main(String[] args) {
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.practice1();
//		a.practice2();
		a.practice3();
	}

}
