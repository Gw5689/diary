package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gdu.diary.vo.Todo;

public class TodoDao {
	
	// 일정 수정
	public int updateTodo(Connection conn, Todo todo) throws SQLException {
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try { // WHERE절에 todoNo을 넘겨서 업데이트 할 목록들을 받기
			stmt = conn.prepareStatement(TodoQuery.UPDATE_TODO);
			stmt.setString(1, todo.getTodoDate());
			stmt.setString(2, todo.getTodoTitle());
			stmt.setString(3, todo.getTodoContent());
			stmt.setString(4, todo.getTodoFontColor());
			stmt.setInt(5, todo.getTodoNo());
			// 디버깅
			System.out.println(stmt+"TodoDao updateTodo stmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		return rowCnt;
	}
	
	// todo 삭제 메소드
	public int deleteTodo(Connection conn, int todoNo) throws SQLException{
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try { //  WHERE절에 todoNo를 이용하여 삭제
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO);
			stmt.setInt(1, todoNo);
			// 디버깅
			System.out.println(stmt+"<-- TodoDao deleteTodo stmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		
		return rowCnt;
	}
	
	// 상세 일정
	public Todo selectTodoOneByTodoNo(Connection conn, int todoNo) throws SQLException {
		Todo todo = new Todo();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try { 
			stmt = conn.prepareStatement(TodoQuery.SELECT_TODO_ONE_BY_TODO_NO);
			stmt.setInt(1, todoNo);
			//디버깅
			System.out.println(stmt+"<-- TodoDao selectTodoOneByTodoNo stmt");
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				todo.setTodoNo(rs.getInt("todoNo"));
				todo.setTodoContent(rs.getString("todoContent"));
				todo.setTodoDate(rs.getString("todoDate"));
				todo.setTodoFontColor(rs.getString("todoFontColor"));
				todo.setTodoTitle(rs.getString("todoTitle"));
			}
		}finally {
			rs.close();
			stmt.close();
		}

		return todo;
	}
	
	
	//  일정 목록
	public List<Todo> selectTodoListByDate(Connection conn, int memberNo, int targetYear, int targetMonth) throws SQLException {
		List<Todo> list = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(TodoQuery.SELECT_TODO_LIST_BY_DATE);
			stmt.setInt(1, memberNo);
			stmt.setInt(2, targetYear);
			stmt.setInt(3, targetMonth);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				Todo todo = new Todo();
				todo.setTodoNo(rs.getInt("todoNo"));
				todo.setTodoDate(rs.getString("todoDate"));
				todo.setTodoTitle(rs.getString("todoTitle"));
				todo.setTodoFontColor(rs.getString("todoFontColor"));
				list.add(todo);
			}
		} finally {
			rs.close();
			stmt.close();
		}
		
		return list;
	}
	
	
	// 일정 입력
	public int insertTodo(Connection conn, Todo todo) throws SQLException {

		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.INSERT_TODO);
			stmt.setInt(1, todo.getMemberNo());
			stmt.setString(2, todo.getTodoDate());
			stmt.setString(3, todo.getTodoTitle());
			stmt.setString(4, todo.getTodoContent());
			stmt.setString(5, todo.getTodoFontColor());
			rowCnt= stmt.executeUpdate();
			
		} finally {
			stmt.close();
		}
		
		return rowCnt;
	}
	
	
	
	public int deleteTodoByMember(Connection conn, int memberNo) throws SQLException{
		
		// 초기화
		int rowCnt = 0;
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(TodoQuery.DELETE_TODO_BY_MEMBER);
			stmt.setInt(1, memberNo);
			// 디버깅
			System.out.println(stmt+"<-- TodoDao deleteTodoByMember stmt");
			rowCnt = stmt.executeUpdate();
		} finally {
			stmt.close();
		}
		
		return rowCnt;
	}
}
