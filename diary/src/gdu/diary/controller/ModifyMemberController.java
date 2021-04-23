package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;


@WebServlet("/auth/modifyMember")
public class ModifyMemberController extends HttpServlet {
	private MemberService memberService;
	// 비밀번호 변경 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/auth/modifyMember.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 새 비밀번호 가져오기
		String memberPw = request.getParameter("memberPw");
		
		// 객체 생성
		Member member = new Member();
		this.memberService = new MemberService();
		
		//세션에서 member 가져오기
		HttpSession session = request.getSession();
		member = (Member)session.getAttribute("sessionMember");
		member.setMemberPw(memberPw);
		
		this.memberService.modifyMemberByKey(member);
		
		// 로그아웃 후 다시 로그인
		response.sendRedirect(request.getContextPath()+"/auth/logout");
	}

}
