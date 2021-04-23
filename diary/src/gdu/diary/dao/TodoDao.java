package gdu.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gdu.diary.util.DBUtil;

public class TodoDao {
	private DBUtil dbUtil;
	public int deleteTodoByMember(Connection conn, int memberNo) throws SQLException{
		this.dbUtil = new DBUtil();
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
			this.dbUtil.close(null, stmt, null);
		}
		
		return rowCnt;
	}
}
