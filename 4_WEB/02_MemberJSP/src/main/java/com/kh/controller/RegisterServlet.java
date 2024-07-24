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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	MemberDAO mDao = new MemberDAO();
	Member member = new Member();
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.jsp에서 /register로 요청하여
		// 요청 받은 아이디(id), 비밀번호(pwd), 이름을 받는다(name).
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		member.setId(id);
		String pwd = request.getParameter("pwd");
		member.setPassword(pwd);
		String name = request.getParameter("name");
		member.setName(name);
		
			String check = "";
			try {
				boolean logic = mDao.resisterMember(new Member(member.getId(),member.getPassword(),member.getName()));
				check = logic == true ? "true" : "false";
				request.setAttribute("check", check);
				request.setAttribute("name", name);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
//			if(check) {
//				request.setAttribute("name", name);
//				request.getRequestDispatcher("result.jsp").forward(request, response);
//			}else {
//				request.getRequestDispatcher("failedResult.jsp").forward(request, response);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		}
		
		//바인딩 : 결과 페이지에 서버에서 받은 값 보냄
		
		
		// 결과 페이지 지정 - result.jsp
//		response.sendRedirect("result.jsp");
		// 만약 결과 페이지로 서버에서 받은 값 보여주려면 -> RequesDispatcher().forward 방식으로 보내야 함
		
		
	


