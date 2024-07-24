package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	public boolean checkId(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM member");
		ResultSet rs = ps.executeQuery();
		String checkId = "";
		if(rs.next()) {
			checkId = id;
			if(rs.getString("id").equals(checkId)) return true;
		}
		return false;
	}
	
	// 회원가입 -member 스키마의 member 테이블
	public boolean resisterMember(Member m) throws ClassNotFoundException, SQLException {
		if(!checkId(m.getId())) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("INSERT INTO member(id, password, name) VALUES (?,?,?)");
		ps.setString(1, m.getId());
		ps.setString(2, m.getPassword());
		ps.setString(3, m.getName());
		ps.executeUpdate();
		conn.close();
		ps.close();
		return true;
		}
		return false;
	}
	public ArrayList<Member> viewMember() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM member");
		ResultSet rs = ps.executeQuery();
		ArrayList<Member> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new Member(rs.getString("id"),rs.getString("password"),rs.getString("name")));
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}
	public Member searchMember(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM member WHERE id=?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member= new Member(rs.getString("id"),rs.getString("password"),rs.getString("name"));
		}
		return member;
	}
	
}
