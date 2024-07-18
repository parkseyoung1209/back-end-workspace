package com.kh.socket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 키보드로 입력받은 데이터를 읽어서 서버로 보낸다
 * 다시 서버가 보낸 매세지를 받아서 클라이언트 자신의 콘솔창에 출력한다
 * 
 */

public class ChattClient {

	public static void main(String[] args) {
		
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			Socket s = new Socket(ip.getHostAddress(), 60000);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			
			BufferedReader br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));

			while(true) {
				String line = br.readLine();
				pw.println(line);
				
				String serverMsg = br2.readLine();
				System.out.println("니가 보낸 매세지 : " +serverMsg);
			}
			
		} catch (Exception e) {
			System.out.println("서버와의 연결에 실패했습니다");
		}
		
	}

}
