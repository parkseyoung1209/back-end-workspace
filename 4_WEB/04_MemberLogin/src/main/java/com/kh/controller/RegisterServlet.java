package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	MemberDAO mDao = new MemberDAO();
	Member member = new Member();
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		
		String pwd = request.getParameter("pwd");
	
		String name = request.getParameter("name");
		
		
			try {
				boolean logic = mDao.resisterMember(new Member(id,pwd,name));
				session.setAttribute("resister", logic);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		response.sendRedirect("../index.jsp");
	}
}
		
		//바인딩 : 결과 페이지에 서버에서 받은 값 보냄
		
		
		// 결과 페이지 지정 - result.jsp
//		response.sendRedirect("result.jsp");
		// 만약 결과 페이지로 서버에서 받은 값 보여주려면 -> RequesDispatcher().forward 방식으로 보내야 함
		
		
	


