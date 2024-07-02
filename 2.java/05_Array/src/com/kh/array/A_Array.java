package com.kh.array;

import java.util.Scanner;

public class A_Array {
	Scanner sc = new Scanner(System.in);
	/*
	 *  변수 : 하나의 공간에 하나의 값을 담음
	 * 	배열 : 하나의 공간에 "여러개의 값"(같은 자료형의 값)을 담음
	 * 
	 * 	배열의 선언
	 * 	자료형[] 배열명;
	 * 	자료형 배열명[];
	 * 	- 배열을 선언한다고 해서 값을 저장할 공간이 생성되는 것이 아니라
	 * 	  배열을 다루는데 필요한 변수가 생성
	 * 
	 * 	배열의 초기화
	 * 	배열명 = new 자료형[배열크기];
	 *  - 생성된 배열에 처음으로 값을 저장
	 *  
	 *  배열의 선언과 초기화 동시 진행
	 *  자료형 [] 배열명 = new 자료형[배열크기];
	 *  
	 */
	public void method1() {
		int[] nums = new int[5]; // 배열크기 지정하지 않으면 에러가 난다
		System.out.println(nums);
		// 배열 생성하고 해당 값들은 초기화하지 않은 상태 -> 기본값이 들어감
		// 정수형 : 0, 실수형 : 0.0, 문자형 :\u0000, 논리형 : false, 참조형 : null
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		
		nums[0] = 100;
		nums[1] = 70;
		nums[2] = 90;
		nums[3] = 80;
		nums[4] = 60;
		
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
	}
	// 배열 선언과 동시에 값들 초기화
	public void method2() {
		int[] nums = {100, 70, 90, 80, 60};
		/*System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		System.out.println(nums[3]);
		System.out.println(nums[4]);
		*/
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		for(int value : nums) {
			System.out.println(value);
		}
	}
	public void method3() {
		/*
		 * 3명의 키를 입력받아 배열에 저장하고 3명의 키의 평균 값을 구하시오
		 * 키 입력 > 180
		 * 키 입력 > 177.3
		 * 키 입력 > 168.2
		 * 평균 : 175.2
		 */
		System.out.print("키 입력 > ");
		double cm1 = sc.nextDouble();
		System.out.print("키 입력 > ");
		double cm2 = sc.nextDouble();
		System.out.print("키 입력 > ");
		double cm3 = sc.nextDouble();
		
		double[] array1 = {cm1, cm2, cm3};
		double sum = 0;
		for(int i = 0; i < array1.length; i++) {
			sum += array1[i];
		}
		System.out.printf("%.1f", sum / array1.length);
	}
	public static void main(String[] args) {
		A_Array a = new A_Array();
//		a.method1();
//		a.method2();
		a.method3();
	}

}
