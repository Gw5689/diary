package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.MemberService;
import gdu.diary.vo.Member;


@WebServlet("/auth/removeMember") // /auth/ 로그인 한 사람만 회원탈퇴 가능 (필터)
public class RemoveMemberController extends HttpServlet {
	private MemberService memberService;
	// 비밀번호 입력 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberService = new MemberService();
		request.getRequestDispatcher("/WEB-INF/view/auth/removeMember.jsp").forward(request, response);
		
	}
	
	// 삭제 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberPw =  request.getParameter("memberPw");
		Member member = (Member)request.getSession().getAttribute("sessionMember"); // 세션안에 pw 정보는 넣지 않음
		member.setMemberPw(memberPw); // 세션에 pw 추가
		
		this.memberService = new MemberService();
		boolean result = this.memberService.removeMemberByKey(member);
		if(result == false) {
			System.out.println("회원탈퇴 실패!");
			response.sendRedirect(request.getContextPath()+"/auth/removeMember");
			return;
		}
		System.out.println("회원탈퇴 성공!");
		response.sendRedirect(request.getContextPath()+"/auth/logout");
		
	}
}
