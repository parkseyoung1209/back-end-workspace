package com.kh.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

class LoopPractice {
	Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
//		l.method6();
		l.method7();
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("사용자 입력 : ");
    	int number = sc.nextInt();
    	int result = 0;
    	if(number>100) return;
    	for(int i = 0; i < number; i++) {
    		result = number - i;
    		System.out.println(result);
    	}
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 
    // 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    
    // ex)1 -1 2 -2 3 -3 4...
    public void method2() {
    	int total = 0;
    	for(int i = 1; i>0; i++) {
    		if(i%2 != 0) {
    			total = total+i;
    		}else if(i%2 == 0) {
    			total = total-i;
    		}
    		if(total>=100) {
    			System.out.println(i);
    			break;
    		}
    	}
    }
    
    
    			

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	int result = 0;
    	System.out.print("뮨자열 : ");
    	String str = sc.nextLine();
    	System.out.print("문자 : ");
    	String str2 = sc.nextLine();
    	char ch = str2.charAt(0);
    	
    	for(int i = 0; i<str.length(); i++) {
    		if(str.charAt(i) == ch) {
    			result++;
    		}
    	
    	}
    	System.out.println(str + " 안에 포함된 " + str2 + " 개수 : " +  result);
    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    
		while(true
				) {
			double random = Math.random();
			random = random * 11;
			int random2 = (int)random;
			if(random2 !=0) {
				System.out.println(random2);
			}else {
				System.out.println(random2);
				break;
			}
		}
    	
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
    	for(int i = 1; i <=11; i++) {
    		if(i<=10) {
    			double random = Math.random();
    			random =random * 6 + 1.0;
    			int random2 = (int)random;
  
    				if(random2 == 1) {
    					count1++;
    				
    				}
    				if(random2 == 2) {
    					count2++;
    				}
    				if(random2 == 3) {
    					count3++;
    				
    				}
    				if(random2 == 4) {
    					count4++;
    				}
    				if(random2 == 5) {
    					count5++;
    				
    				}
    				if(random2 == 6) {
    					count6++;
    				}
    		
    		}else {
    			break;
    		}
    	}
    	System.out.println("1: " + count1);
    	System.out.println("2: " + count2);
    	System.out.println("3: " + count3);
    	System.out.println("4: " + count4);
    	System.out.println("5: " + count5);
    	System.out.println("6: " + count6);
    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
    	int win = 0;
    	int lose = 0;
		int equal = 0;
		while(true) {
			double random = Math.random();
			random =random * 3 + 1;
			int random2 = (int)random;
			String game1 = random2 == 1 ? "가위" : random2 == 2 ? "바위" : random2 == 3? "보" : "없음";
			
			System.out.print("당신의 이름을 입력해주세요 : ");
	    	String str = sc.nextLine();
	    	System.out.print("가위바위보 : ");
	    	String game2 = sc.nextLine();
	    	System.out.println("컴퓨터 : " + game1);
	    	int number = game2.equals("가위") ? 1 :game2.equals("바위") ? 2 : game2.equals("보") ? 3 : 4;
	    	boolean logic1 = (random2 == 1 && number == 2) || (random2 == 2 && number == 3) || (random2 == 3 && number == 1);
	    	boolean logic2 = (random2 == 1 && number == 3) || (random2 == 2 && number == 1) || (random2 == 3 && number == 2);
	    	if(game1.equals(game2)) {
	    		equal++;
	    		System.out.println("비겼습니다");
	    	}else if(logic1){
	    		win++;
	    		System.out.println("이겼습니다");
		
	    	}else if(logic2) {
	    		lose++;
	    		System.out.println("졌습니다");
	    	}
	    	System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d\n", equal,lose,win);
	    }
		
		}
    public void method7() {
    	String str = sc.nextLine();
    	char ch = ' ';
    	int check = (int)ch;
    	int count = 0;
    	for(int i = 0; i<str.length()-1; i++) {
    		if((int)str.charAt(i) == check) {
    			count++;
    		}
    	}
    	System.out.println(count+1);
    }
  
           
}
 


