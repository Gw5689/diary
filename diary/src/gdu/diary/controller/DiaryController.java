package gdu.diary.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gdu.diary.service.DiaryService;
import gdu.diary.vo.Member;

@WebServlet("/auth/diary")
public class DiaryController extends HttpServlet {
	private DiaryService diaryService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.diaryService = new DiaryService();
		HttpSession session = request.getSession(); // 세션 코드 추가
		int memberNo = ((Member)session.getAttribute("sessionMember")).getMemberNo();
		// 전처리 생략 / 년,월이 넘어와도 문자열로 넘어감 / 값이 넘어오지 않으면 null이 넘어감
		String targetYear = request.getParameter("targetYear");
		String targetMonth = request.getParameter("targetMonth");
		
		Map<String, Object> diaryMap = this.diaryService.getDiary(memberNo, targetYear, targetMonth);
		System.out.println("TodoList: "+diaryMap.get("todoList"));
		
		request.setAttribute("diaryMap", diaryMap); // request에 map 넣기
		request.getRequestDispatcher("/WEB-INF/view/auth/diary.jsp").forward(request, response);
		// view diary.jsp
	}

}
