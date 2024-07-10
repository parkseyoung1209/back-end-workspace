package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

	public static void main(String[] args) {
		/*ArrayList<Integer> list = new ArrayList();
		for(int i = 1; i<46; i++) {
			list.add(i);
		}
		int num = 0;
		
		List test1 = new ArrayList();
		List test2 = new ArrayList();
		HashSet set2 = new HashSet();
		boolean logic = true;
		while(logic) {
			HashSet set = new HashSet();
			
			while(set.size()<6) {
				int random = (int)(Math.random()*45);
				set.add(list.get(random));
			}
			
			while(set2.size()<6) {
				int random = (int)(Math.random()*45+1);
				set2.add(random);
			}
			System.out.println("로또 번호 : " + set2);
			System.out.println("내 번호 : " + set);
			num++;
			if(set2.equals(set)) logic = false;
		}
		System.out.println("횟수 : " + num);
		*/
		
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		
		while(lotto.size() < 7) {
			int num = (int)(Math.random() * 45 +1);
			if(!lotto.contains(num)) { 
				lotto.add(num);
			}
		}
		
		List<Integer> lottoList = lotto.subList(0, 6);
		int bonus = lotto.get(6);
		
		int count = 0;
		
		while(lotto.size()<6) {
			int num = (int)(Math.random() * 45 +1);
			if(!lotto.contains(num)) { // contains : 괄호에 있는 값이 포함되어 있는가의 여부를 따지는 명령어
				lotto.add(num);
			}
		}
		while(true) {
			count++;
			ArrayList<Integer> myLotto = new ArrayList<>();
			
			while(myLotto.size() < 6) {
				int num = (int)(Math.random() * 45 +1);
				if(!myLotto.contains(num)) { 
					myLotto.add(num);
				}
			}
			
			System.out.println("로또 번호 : " + lottoList);
			System.out.println("내 번호 : " + myLotto);
			
			Collections.sort(lottoList);
			Collections.sort(myLotto);
			
			if(lottoList.equals(myLotto)) {
				System.out.println("1등 당첨! 횟수 : " + count);
				break;
			}
			
			int match = 0;
			for(Integer num : lottoList) {
				if(myLotto.contains(num)) {
					match++;
				}
			}
			if(match == 5) {
				if(myLotto.contains(bonus)) {
				System.out.println("2등 당첨! 보너스 번호 : " + bonus + " 횟수 : " + count);
				break;
			   }else {
				   System.out.println("3등 당첨! 횟수 :" + count);
				   break;
			   }
			}else if(match == 4) {
				System.out.println("4등 당첨! 횟수 : " + count);
				break;
			}else if(match == 3) {
				System.out.println("5등 당첨! 횟수 : " + count);
				break;
			}
		}
		
	}
}


