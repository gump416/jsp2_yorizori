package ezen.yorizori.web.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ezen.yorizori.domain.common.factory.DaoFactory;
import ezen.yorizori.domain.member.dto.Member;
import ezen.yorizori.domain.member.service.MemberService;
import ezen.yorizori.domain.member.service.MemberServiceImpl;
import ezen.yorizori.web.common.YZRuntimeException;

/**
 * 로그인 화면과 로그인 처리 컨트롤러
 */
@WebServlet(value = { "/member/login.do", "/member/logout.do" }) // value=은 생략가능해서 안쓴거고, 2개이상도 저장가능,베열로서..
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 비즈니스 객체 사용
	private MemberService memberService = new MemberServiceImpl();

	private String referer;
	
	/**
	 * 로그인 화면 처리 /로그아웃 처리
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		referer = request.getHeader("referer"); //header정보(이전페이지기록)중 하나인 referer, get방식으로 왔을때 사용가능하고 보안에 취약함
		
		String requestURI = request.getRequestURI();
		// /member/login.do
		String uri = requestURI.substring(requestURI.lastIndexOf("/") + 1);
		// login.do
		RequestDispatcher rd = null;
		if (uri.equals("login.do")) {// 로그인 화면 요청시
			rd = getServletContext().getRequestDispatcher("/WEB-INF/views/member/loginForm.jsp");
			rd.forward(request, response);
		} else {// 로그아웃 요청시
			request.getSession().invalidate();
			response.sendRedirect("/index.do");
		}

	}

	/**
	 * 로그인 처리
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String loginId = request.getParameter("id");
		String loginPw = request.getParameter("password");
		String saveId = request.getParameter("saveid");

		Member loginMember = memberService.isMember(loginId, loginPw);
		//회원인 경우
		if (loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			if (saveId != null) {
				Cookie cookie = new Cookie("saveId", loginId); // loginMember.getId()라고 써도되고 위에 변수 처리한값으로 써줘도됨
				cookie.setMaxAge(60 * 60 * 24 * 2);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
//			response.sendRedirect("/index.do"); // 요청파일이없다는뜻인데, index.jsp에 등록된 forword타고 진짜 index.jsp불러들임, url에 경로
			// 표시안됨
			response.sendRedirect(referer);
		} else { //회원이 아닌경우
			//비즈니스 로직 예외 강제 발생
			throw new YZRuntimeException("사용자 로그인에 실패하였습니다.<br/>로그인 정보를 확인하세요");
		}

	}

}
