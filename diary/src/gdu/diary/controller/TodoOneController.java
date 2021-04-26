package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Todo;


@WebServlet("/auth/todoOne")
public class TodoOneController extends HttpServlet {
	private TodoService todoService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));

		//service 호출
		this.todoService = new TodoService();
		Todo todoOne = new Todo();
		todoOne = this.todoService.getTodoOneByTodoNo(todoNo);
		// 디버깅
		System.out.println(todoOne.toString());
		
		//포워딩
		request.setAttribute("todoOne", todoOne);
		request.getRequestDispatcher("/WEB-INF/view/auth/todoOne.jsp").forward(request, response);
	}

}