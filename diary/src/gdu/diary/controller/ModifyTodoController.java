package gdu.diary.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.diary.service.TodoService;
import gdu.diary.vo.Todo;


@WebServlet("/auth/modifyTodo")
public class ModifyTodoController extends HttpServlet {
	private TodoService todoService;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값 가져오기
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		Todo todoOne = new Todo();
		this.todoService = new TodoService();
		todoOne = this.todoService.getTodoOneByTodoNo(todoNo);
		
		//포워딩
		request.setAttribute("todoOne", todoOne);
		request.getRequestDispatcher("/WEB-INF/view/auth/modifyTodo.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값 가져오기
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String todoDate = request.getParameter("todoDate");
		String todoTitle = request.getParameter("todoTitle");
		String todoContent = request.getParameter("todoContent");
		String todoFontColor = request.getParameter("todoFontColor");

		Todo todo = new Todo();
		todo.setTodoNo(todoNo);
		todo.setTodoTitle(todoTitle);
		todo.setTodoContent(todoContent);
		todo.setTodoDate(todoDate);
		todo.setTodoFontColor(todoFontColor);
		// 디버깅
		System.out.println(todo);

		// todoService 호출
		this.todoService = new TodoService();
		this.todoService.modifyTodoOne(todo);
		response.sendRedirect(request.getContextPath()+"/auth/todoOne?todoNo=" + todoNo);
	
	}

}
