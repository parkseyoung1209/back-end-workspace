package com.kh.loop;

import java.util.Scanner;

public class D_While {
	Scanner sc = new Scanner(System.in);
	/*
	 * while문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 *} 
	 * 
	 */
	// 1~5까지 출력 : for -> while
	public void method1() {
		/*for(int i =1; i<6; i++) {
			System.out.println(i);
		}*/
		int i =1;
		while(i<=5) {
			System.out.println(i);
			i++;
		}
	
	}
	/*
	 * 무한루프 & break 문
	 * -switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * -반복문의 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다.
	 */
	public void method2() {
		while(true) {
			System.out.println("숫자 입력 : ");
			int num = sc.nextInt();
			System.out.println(num);
			if(num == 0) break;
		}
	}
	
	/*
	 * do {
	 * 		실행 코드
	 * } while(조건식);
	 * 
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * - 거의 쓸 일이 없음... 
	 * 
	 */
	public void method3() {
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		
		do {
			System.out.println("do-while");
		} while(number == 0);
	}
	/*
	 * 숫자 맞히기 게임
	 * 1과 100사이의 값을 입력해서 임의로 지정한 random값을 맞히면 게임 끝!
	 * 게임이 끝나면 몇 번만에 맞혔는지 출력!
	 * 
	 * (예 : 57)
	 * 1과 100 사이의 값 입력 > 35
	 * 더 큰 수를 입력하세요
	 * 1과 100 사이의 값 입력 > 70
	 * 더 작은 수를 입력하세요.
	 * 1과 100 사이의 값 입력 > 57
	 * 3번 만에 성공했습니다.
	 */
	public void method4() {
		
		double random = Math.random();
		random = Math.random() * 100 + 1; //1.0 <= random <101.0
		int random2 = (int)random;
		int i = 1;
		System.out.println(random2);
		
		while(true) {
		
			System.out.println("1과 100 사이의 값 입력");
			int a = Integer.parseInt(sc.nextLine());
			if(random2 == a) {
				System.out.println(i + "번 만에 성공했습니다");
				break;
			}else if(random2 >a) {
				System.out.println("더 큰 수를 입력해주세요 " + i + "번 실패");
				i++;
			}else if(random2 < a){
				System.out.println("더 작은 수를 입력해주세요 " + i + "번 실패");
				i++;
			}
		}
	}
	/*
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택>1
	 * 예금액>5000
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택>2
	 * 출금액>2000
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택>3
	 * 잔고>3000
	 * ----------------------------------
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * ----------------------------------
	 * 선택>4
	 * 프로그램 종료
	 * 
	 */
	
	public void method5() {
		
		int money = 0;
		boolean logic = true;
		while(logic) {
		System.out.println("-----------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("-----------------------------");
		System.out.print("선택 > ");
		int num1 = sc.nextInt();
		switch(num1) {
			case 1 :
				System.out.print("예금액 > ");
				money += sc.nextInt();
				break;
			case 2 :
				System.out.print("출금액 > ");
				int num3 = sc.nextInt();
				if(num3>money) {
					System.out.println("잔액부족"); 
					break;
					}
				money = money-num3;
				break;
			case 3 :
				System.out.println("잔액 > " + money);
				break;
			case 4 :
				System.out.print("프로그램 종료");
				logic = false;
				break;
			}
		}
		
	}
	public void method6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해보세요 : ");
		int a = sc.nextInt();
		boolean logic1 = a%4 == 0 && (a%100 == 0 || a%400 == 0);
		boolean logic2 = a>=1 && a<=4000;
		
		if(logic1 && logic2) {
			System.out.println('1');
		}else {
			System.out.println('0');
		}

	}
	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
//		d.method5();
		d.method6();
	}

}
