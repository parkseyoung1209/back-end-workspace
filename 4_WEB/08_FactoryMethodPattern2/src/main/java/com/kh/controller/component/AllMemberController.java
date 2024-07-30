package com.kh.controller.component;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AllMemberController implements Controller{
	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			try {
				MemberDAO mDao = new MemberDAO();
				ArrayList<Member> list = null;
				list = mDao.viewMember();
				request.setAttribute("allList", list);
				return new ModelAndView("/views/allMember.jsp");
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
}
