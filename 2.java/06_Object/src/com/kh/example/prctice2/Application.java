package com.kh.example.prctice2;
import java.util.*;

import com.kh.example.prctice2.controller.SnackController;
import com.kh.example.prctice2.model.Snack;

public class Application {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Snack snack = new Snack();
	
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류 : " );
		String kind = sc.nextLine();
		System.out.print("이름 : " );
		String name = sc.nextLine();
		System.out.print("맛 : " );
		String flavor = sc.nextLine();
		System.out.print("개수 : " );
		int numOf = sc.nextInt();
		System.out.print("가격 : " );
		int price = sc.nextInt();
		SnackController sn = new SnackController();
		System.out.println(sn.saveData(kind, name, flavor, numOf, price));
		System.out.println(sn.confirmData());
		
	}

}
