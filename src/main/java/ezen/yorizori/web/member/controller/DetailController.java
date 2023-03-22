package ezen.yorizori.web.member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ezen.yorizori.domain.member.dto.Member;
import ezen.yorizori.domain.member.service.MemberService;
import ezen.yorizori.domain.member.service.MemberServiceImpl;

/**
 * 회원 상세 처리 컨트롤러 서블릿
 */
@WebServlet("/member/detail.do") 
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//비즈니스 객체 사용
	
	private MemberService memberService = new MemberServiceImpl();
	/**
	 * 회원 상세 처리
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Member member = new Member();
//		request.setCharacterEncoding("utf-8");
		String id = (String)request.getParameter("id");
		
//		HttpSession session = request.getSession();
//		Member member =(Member)session.getAttribute("loginMember");
		
		
		Member member = memberService.findUserId(id);
			request.setAttribute("member", member);
			
//			session.setAttribute("member", member);
		
		RequestDispatcher rd =getServletContext().getRequestDispatcher("/WEB-INF/views/member/detail.jsp");
			rd.forward(request, response);
	
	}

	
	
	
	
}
