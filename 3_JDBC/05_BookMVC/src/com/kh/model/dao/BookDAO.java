package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Book;
import com.kh.model.vo.BookRent;
import com.kh.model.vo.Publisher;

import config.ServerInfo;

/*
 * DAO(Data Access Object)
 * - DB에 접근하는 역할을 하는 객체
 * 
 */
public class BookDAO {
	Properties p = new Properties();
	
	public BookDAO() throws ClassNotFoundException {
		Class.forName(ServerInfo.DRIVER_NAME);
	}
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps, conn);
	}
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM book LEFT JOIN publisher ON (pub_no = bk_pub_no)");
		
		ArrayList<Book> list = new ArrayList();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			list.add(new Book(rs.getInt("bk_no"), rs.getString("bk_author"),rs.getString("bk_title") ,rs.getInt("bk_price"), 
					new Publisher(rs.getInt("pub_no"),rs.getString("pub_name"),rs.getString("phone"))));
		}
		
		return list;
	}
	
	public ArrayList<BookRent> printRentBook(int num) throws SQLException, FileNotFoundException, IOException {
		p.load(new FileInputStream("src/config/jdbc.properties"));
		int key = num;
		Connection conn = connect();
		PreparedStatement ps1 = conn.prepareStatement(p.getProperty("rentBook4"));
		ps1.setInt(1, key);
		ArrayList<BookRent> list = new ArrayList();
		ResultSet rs = ps1.executeQuery();
		
		while(rs.next()) {
			// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 조회
			list.add(new BookRent(rs.getInt("rent_no"),rs.getString("bk_title"),rs.getString("bk_author"),
					rs.getDate("rent_date"), rs.getDate("enroll_date")));
		}
		return list;
	}
	
}
