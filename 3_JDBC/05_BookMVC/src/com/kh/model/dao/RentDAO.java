package com.kh.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Book;
import com.kh.model.vo.BookRent;

import config.ServerInfo;

public class RentDAO {
	Properties p = new Properties();
	public RentDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			p.load(new FileInputStream("src/config/jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps,conn);
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	public boolean rentBook(int memberNo, int bookNo) throws SQLException {
		Connection conn = connect();
		String query = "INSERT INTO rent(rent_mem_no, rent_book_no) VALUES(?, ?) ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, memberNo);
		ps.setInt(1, bookNo);
		ps.executeUpdate();
		closeAll(ps, conn);
		
		return true;
		
	}
	// 2. 내가 대여한 책 조회
	public ArrayList<BookRent> printRentBook(int memberNo) throws SQLException {
		Connection conn = connect();
		String query = "SELECT * FROM rent JOIN book ON (rent_book_no = bk_no) WHERE rent_mem_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1,  memberNo);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<BookRent> list = new ArrayList<>();
		while(rs.next()) {
			BookRent rent = new BookRent();
			rent.setRentNo(rs.getInt("rent_no"));
			rent.setRentDate(rs.getDate("rent_date"));
			
			Book book = new Book();
			book.setBkTitle(rs.getString("bk_title"));
			book.setBkAuthor(rs.getString("bk_author"));
			rent.setRentNo(memberNo);
			list.add(rent);
		}
		return list;
	}
	
	// 3. 대여 취소
	public int deleteRent(int no) throws SQLException {
		Connection conn = connect();
		String query = "DELETE FROM rent WHERE rent_no = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, no);
		
		int result = ps.executeUpdate();
		closeAll(ps,conn);
		return result;
	}
	
	public void deleteMember(int memberNo) throws SQLException {
		Connection conn = connect();
		String query = "DELETE FROM member WHERE member_no = ?";
		PreparedStatement ps  = conn.prepareStatement(query);
		ps.setInt(1, memberNo);
		ps.executeUpdate();
	}
}
	
	

