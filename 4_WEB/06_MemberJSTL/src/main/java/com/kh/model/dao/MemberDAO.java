package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {
	// DAO 개발할 때 중요한 건
	// 매개변수(파라미터) 뭘 가지고 와야 되는지, 리턴 타입 결과 출력이 어떤게 필요한지
	public boolean checkId(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM member WHERE id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			return true;
		}
		return false;
	}
	public Member checkId(String id, String pwd) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM member WHERE id=? AND password=?");
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member = new Member(rs.getString("id"),rs.getString("password"),rs.getString("name"));
		}
		return member;
	}
	// 회원가입 -member 스키마의 member 테이블
	public boolean resisterMember(String id, String pwd, String name) throws ClassNotFoundException, SQLException {
		if(!(checkId(id))) {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("INSERT INTO member(id, password, name) VALUES (?,?,?)");
		ps.setString(1, id);
		ps.setString(2, pwd);
		ps.setString(3, name);
		ps.executeUpdate();
		conn.close();
		ps.close();
		return true;
		}
		else return false;
	}
	public ArrayList<Member> viewMember() throws SQLException, ClassNotFoundException {
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

