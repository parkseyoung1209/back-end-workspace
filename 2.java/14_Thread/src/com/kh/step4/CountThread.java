package com.kh.step4;

public class CountThread extends Thread{
	InputThreadTest process;
	
	public CountThread(InputThreadTest process) {
		this.process = process;
	}

	public void run() {
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
