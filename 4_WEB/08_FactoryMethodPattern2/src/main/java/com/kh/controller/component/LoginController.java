package com.kh.controller.component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO mDao = new MemberDAO();
		String id =request.getParameter("id");
		String password = request.getParameter("pwd");
		try {
			Member member = mDao.checkId(id, password);
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("index.jsp");
	}
}
