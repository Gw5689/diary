package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;

//일정 삭제
@WebServlet("/auth/removeTodo")
public class RemoveTodoController extends HttpServlet {
	private TodoService todoService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값 가져오기
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String todoDate = request.getParameter("todoDate");
		
		// todoService 호츌
		this.todoService = new TodoService();
		this.todoService.removeTodo(todoNo);

		// 달력으로 돌아가기
		String[] arr = todoDate.split("-");
		response.sendRedirect(request.getContextPath() + "/auth/diary?targetYear="+arr[0]+"&targetMonth="+(Integer.parseInt(arr[1])-1));
	}
}