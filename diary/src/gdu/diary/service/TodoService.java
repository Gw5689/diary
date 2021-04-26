package gdu.diary.service;

import java.sql.Connection;
import java.sql.SQLException;

import gdu.diary.dao.TodoDao;
import gdu.diary.util.DBUtil;
import gdu.diary.vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	private DBUtil dbUtil;
	
	// 일정 수정
	public int modifyTodoOne(Todo todo) {
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		// 초기화
		int rowCnt = 0;
		Connection conn = null;
	
	
		try {
			conn = this.dbUtil.getConnection();
			rowCnt = this.todoDao.updateTodo(conn, todo);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCnt;
	}
	
	// 일정 삭제
	public int removeTodo(int todoNo) {
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		// 초기화
		Connection conn = null;
		int rowCnt = 0;
		
		try {
			conn = this.dbUtil.getConnection();
			rowCnt = this.todoDao.deleteTodo(conn, todoNo);
			conn.commit();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCnt;
	}
	
	// 상세일정 보기
	public Todo getTodoOneByTodoNo(int todoNo) {
		Todo todo = new Todo();
		this.dbUtil = new DBUtil();
		this.todoDao = new TodoDao();
		Connection conn = null;


		try {
			conn = this.dbUtil.getConnection();
			todo = this.todoDao.selectTodoOneByTodoNo(conn, todoNo);
			System.out.println(todo);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return todo;
	}
	
	// 일정 입력
	public int addTodo(Todo todo) {
		this.todoDao = new TodoDao();
		this.dbUtil = new DBUtil();
		//초기화
		Connection conn = null;
		int rowCnt = 0;
		
		try {
			conn = dbUtil.getConnection();
			rowCnt = this.todoDao.insertTodo(conn, todo);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// 리턴
		return rowCnt; 
	}
}
