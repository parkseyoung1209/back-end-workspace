package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/search")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO md = new MemberDAO();
		
		String id = request.getParameter("id");
		
		Member member = new Member();
			try {
				member = md.searchMember(id);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		request.setAttribute("member", member);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}
	}


