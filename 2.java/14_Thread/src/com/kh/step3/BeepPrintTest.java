package com.kh.step3;

import java.awt.Toolkit;

public class BeepPrintTest {

	public static void main(String[] args) {
		// 경고음 5번 울리는 작업
		BeepThread bt = new BeepThread();
		Thread bT = new Thread(bt);
		BeepThread2 bt2 = new BeepThread2();
		Thread bT2 = new Thread(bt2);
		
		// 띵띵띵띵띵을 5번 출력하는 작업
		bT.start();
		bT2.start();
		
		
	}

}
