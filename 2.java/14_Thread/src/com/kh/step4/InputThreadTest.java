package com.kh.step4;

import javax.swing.JOptionPane;
// 프로세스 - 두 스레드 간의 communication은 프로세스의 자원으로 해야한다.
public class InputThreadTest {
	boolean check = false;
	
	
	public static void main(String[] args) {
		InputThreadTest process = new InputThreadTest();
		// 1. 데이터 입력 작업
	
		InputThread input = new InputThread(process);
		input.start();
		
		CountThread count = new CountThread(process);
		count.start();

		
		// 2. 카운팅 작업
		for(int i =10; i > 0; i--) {
			if(process.check) break;
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}
		
	}

}
