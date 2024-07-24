package com.kh.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.kh.model.dao.BookDAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.BookRent;
import com.kh.model.vo.Publisher;

import config.ServerInfo;

public class BookController {
	Properties p = new Properties();
	public int a = 0;
	
	public BookController() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			p.load(new FileInputStream("src/config/jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
	}
	
	public void printBookAll() throws SQLException, ClassNotFoundException {
		BookDAO dao = new BookDAO(); 
		ArrayList<Book> list = dao.printBookAll();
		for(Book i : list) {
			System.out.println(i);
		}
		// 반복문을 이용해서 책 리스트 출력
		
	}
	public boolean idCheck(String bkTitle, String bkAuthor) throws SQLException {
		
		Connection conn = connect();
		String query = "SELECT * FROM book WHERE bk_title =? AND bk_author =?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, bkTitle);
		ps.setString(2, bkAuthor);
		ResultSet rs = ps.executeQuery();
		int checkId = 0;
		if (rs.next()) checkId = rs.getInt("bk_no");
		if (checkId != 0) return true;
		closeAll(rs, ps, conn);
		return false;
	}
	public boolean idCheck(String memberId, String memberPwd, String memberName) throws SQLException {
	Connection conn = connect();
	PreparedStatement ps = conn.prepareStatement(p.getProperty("member"));
	ps.setString(1, memberId);
	ps.setString(2, memberPwd);
	ps.setString(3, memberName);
	ResultSet rs = ps.executeQuery();
	String checkId = "";
	if(rs.next()) checkId = rs.getString("member_id");
	if(!(checkId.equals(null))) return true;
	closeAll(rs, ps, conn);
	return false;
	
	}
	public boolean registerBook(String bkTitle, String bkAuthor) throws SQLException {
		if (!idCheck(bkTitle, bkAuthor)) {
			int random = (((int)((Math.random()*20000+10000)))/100)*100;
			Connection conn = connect();
			String query = "INSERT INTO book(bk_title, bk_author, bk_price) VALUES(?, ?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, bkTitle);
			ps.setString(2, bkAuthor);
			ps.setInt(3, random);
			ps.executeUpdate();
			closeAll(ps, conn);
			return true;
		}
		return false;
	}
	public boolean sellBook(int bkNo) throws SQLException {
		Connection conn = connect();
		PreparedStatement ps1 = conn.prepareStatement(p.getProperty("deleteBook"));
		PreparedStatement ps2 = conn.prepareStatement(p.getProperty("book"));
		ResultSet rs = ps2.executeQuery();
		while(rs.next()) {
			if(rs.getInt("bk_no") == bkNo) {
			ps1.setInt(1, bkNo);
			ps1.executeUpdate();
			closeAll(rs ,ps1, conn);
			return true;
			}
		}
		return false;
	}
	public boolean registerMember(String memberId, String memberPwd, String memberName) throws SQLException {
		if((idCheck(memberId, memberPwd, memberName))) {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("newMember"));
		ps.setString(1, memberId);
		ps.setString(2, memberPwd);
		ps.setString(3, memberName);
		ps.executeUpdate();
		closeAll(ps, conn);
		return true;
		}
		return false;
	}
	public String login(String memberId, String memberPwd) throws SQLException {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("memberLogin"));
		ps.setString(1, memberId);
		ps.setString(2, memberPwd);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return rs.getString("member_name");
		closeAll(rs, ps, conn);
		return null;
	}
	public int loginInfo(String memberId, String memberPwd) throws SQLException {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement(p.getProperty("memberLogin"));
		ps.setString(1, memberId);
		ps.setString(2, memberPwd);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			a = rs.getInt("member_no");
			return rs.getInt("member_no");
		}
		closeAll(rs, ps, conn);
		return 0;
	}
	public boolean rentBook(int bkNo) throws SQLException {
		Connection conn = connect();
		PreparedStatement ps1 = conn.prepareStatement(p.getProperty("rentBook1"));
		ResultSet rs = ps1.executeQuery();
		if(rs.next()) {
			int rentmemno = rs.getInt("rent_mem_no");
			if(rentmemno == 0) {
				PreparedStatement ps2 = conn.prepareStatement(p.getProperty("rentBook2"));
				ps2.setInt(1, a);
				ps2.setInt(2, bkNo);
				ps2.executeUpdate();
				closeAll(ps2, conn);
				closeAll(rs, ps1, conn);
				return true;
			}else if(rentmemno != a | rentmemno == a){
				return false;
			}
		}
		return false;
	}
	public boolean rentBookNull(int bkNo) throws SQLException {
		if(rentBook(bkNo) == false) {
		Connection conn = connect();
		PreparedStatement ps1 = conn.prepareStatement(p.getProperty("rentBook1"));
		ResultSet rs = ps1.executeQuery();
		if(rs.next()) {
				PreparedStatement ps2 = conn.prepareStatement(p.getProperty("rentBook3"));
				ps2.setInt(1, a);
				ps2.setInt(2, bkNo);
				ps2.executeUpdate();
				closeAll(ps2, conn);
				closeAll(rs, ps1, conn);
				return true;
		}
		}
		return false;
	}
	public void printRentBook() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		BookDAO dao = new BookDAO(); 
		ArrayList<BookRent> list = dao.printRentBook(a);
		for(BookRent i  :list) {
			System.out.println(i);
		}
	}
	public boolean deleteRent(int rentNo) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Connection conn = connect();
		PreparedStatement ps1 = conn.prepareStatement(p.getProperty("printBook"));
		ps1.setInt(1, a);
		ResultSet rs = ps1.executeQuery();
		if(rs.next()) {
			PreparedStatement ps2 = conn.prepareStatement(p.getProperty("deleteRent"));
			ps2.setInt(1, rentNo);
			ps2.executeUpdate();
			closeAll(ps2, conn);
			return true;
			}
		return false;
	}
}

