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

@WebServlet("/views/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mDao = new MemberDAO();
		//1. 폼 값 받는다.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id =request.getParameter("id");
		String password = request.getParameter("pwd");
		
		
		HttpSession session = request.getSession();
		
		try {
			if(mDao.checkId(id, password)==true) {
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			response.sendRedirect("../index.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
