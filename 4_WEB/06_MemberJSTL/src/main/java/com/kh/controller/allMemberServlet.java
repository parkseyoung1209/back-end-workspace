package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/allmember")
public class allMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			try {
				MemberDAO mDao = new MemberDAO();
				ArrayList<Member> list = null;
				list = mDao.viewMember();
				request.setAttribute("allList", list);
				request.getRequestDispatcher("/views/allMember.jsp").forward(request, response);
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		
		
	}

}