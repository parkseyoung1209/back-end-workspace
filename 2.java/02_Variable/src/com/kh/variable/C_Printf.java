package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {
		
		// System.out.print(출력하고자 하는 값); -- 출력만 함
		// System.out.println(출력하고자 하는 값); -- 출력 후 줄바꿈 발생 o
		System.out.println("hello");
		System.out.println("hello");

		System.out.println("-----------------");
		
		// System.out.printf("출력하고자 하는 형식(포맷)", 출력하고자 하는 값, 값, ...);
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20%
		System.out.println(iNum1 + "%" +" "+ iNum2 + "%");
		/*
		 * 포맷에 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 * */
		
		System.out.printf("%d%% %d%%", iNum1, iNum2);
		System.out.println();
		System.out.println("------------------");
		
		System.out.printf("%5d", iNum1); // 5칸 공간 확보 후 양수 오른쪽 정렬
		System.out.printf("%-5d\n", iNum2); // 5칸 공간 확보 후 음수 왼쪽 정렬
		System.out.println("-----------");
		
		// 키워드 알파벳 뒤에 숫자를 넣으면 그 숫자만큼 여백을 넣을 수 있다
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		System.out.printf("%f\t%f\n", dNum1, dNum2); // 무조건 소수점 아래 6번째 자리까지
		System.out.printf("%.8f\t%.2f\n", dNum1, dNum2);
		
		char ch = 'a';
		String str = "Hello";
		
		//a		Hello a
		System.out.printf("%-5c %1s %c", ch, str, ch);
		System.out.printf("%C %S", ch, str); // 키워드를 대문자로 작성하면 출력도 대뮨자로만 출력된다
	}

}
