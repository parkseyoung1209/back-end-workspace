package com.kh.practice.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.kh.practice.exam.controller.SongController;
import com.kh.practice.exam.model.Song;


public class Application {
	
	Scanner sc = new Scanner(System.in);
	Song song = new Song();
	SongController ssc = new SongController();

	public static void main(String[] args) {
		Application app = new Application();
		Song song = new Song();
		app.mainMenu();
		
	}
	public void mainMenu() {
		
		boolean logic = true;
		while(logic) {
			System.out.println("=====메인 메뉴=====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 가수 명 내림차순 정렬");
			System.out.println("8. 곡 명 오름차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력:");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				song.setMenu(menu);
				switch(menu) {
				case 1 :
					add1(); // 작동 됨
					break;
				case 2 :
					add2(); // 작동 됨
					break;
				case 3 :
					search();// 작동 됨
					break;
				case 4 :
					titleSearch();//작동됨
					break;
				case 5 :
					titleDelete(); 
					break;
				case 6 :
					titleReplace();
					break;
				case 7 :
					ssc.sort(menu);
					break;
				case 8 : 
					ssc.sort(menu);// 작동 됨
					break;
				case 9 : // 작동 됨
					System.out.println("종료.");
					logic = false;
					break;
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요"); // 작동 됨
					break;
				}
			}catch(NumberFormatException e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	public void add1() {
			System.out.println("*****마지막 위치에 곡 추가*****");
			System.out.print("곡 명 : ");
			String title = sc.nextLine();
			song.setTitle(title);
			System.out.print("가수 명 : ");
			String singer = sc.nextLine();
			song.setSinger(singer);
			System.out.println("추가완료");
			ssc.songlistF(song.getTitle(), song.getSinger());
			
	}
	public void add2() {
		System.out.println("*****마지막 위치에 곡 추가*****");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		song.setTitle(title);
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		song.setSinger(singer);
		System.out.println("추가완료");
		ssc.songlistL(song.getTitle(), song.getSinger());
		
	}
	public void titleSearch() {
		System.out.println("******특정 곡 검색******");
		System.out.print("검색할 곡 명 : ");
		String titleSearch = sc.nextLine();
		song.setTitleSearch(titleSearch);
		ssc.titleSearch(titleSearch);
		
	}
	public void titleDelete() {
		System.out.println("******특정 곡 삭제******");
		System.out.print("검색할 곡 명 : ");
		String titleSearch = sc.nextLine();
		song.setTitleSearch(titleSearch);
		ssc.titleDelete(titleSearch);
	}
	public void titleReplace() {
		System.out.println("******특정 곡 수정******");
		System.out.print("검색할 곡 명 : ");
		String titleSearch = sc.nextLine();
		song.setTitleSearch(titleSearch);
		System.out.print("수정할 곡 명 : ");
		String title = sc.nextLine();
		song.setTitle(title);
		System.out.print("수정할 가수 : ");
		String singer = sc.nextLine();
		song.setSinger(singer);
		ssc.titleReplace(song.getTitleSearch(), song.getTitle(),song.getSinger());
	}
	public void search() {
		System.out.println("******전체 곡 리스트 출력******");
		for(Song s : ssc.info()) {
			System.out.println(s);
			}
		}
	
}

