package com.kh.controller.component;

import java.io.IOException;
import java.sql.SQLException;

import com.kh.controller.Controller;
import com.kh.controller.ModelAndView;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO md = new MemberDAO();
		
		String id = request.getParameter("id");
		Member member = new Member();
		try {
			member = md.searchMember(id);
			if(member!=null) {
			request.setAttribute("member", member);
			return new ModelAndView("/views/search_ok.jsp");
			}else {
			return new ModelAndView("views/search_fail.jsp", true);
			}
		} catch (SQLException | ClassNotFoundException e) {
		}
		return null;
	}
}
