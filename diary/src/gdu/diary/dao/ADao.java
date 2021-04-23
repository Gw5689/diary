package gdu.diary.dao;

import java.sql.*;

import gdu.diary.util.DBUtil;

// 트랜잭션
public class ADao {
	public void insert(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		try {
		stmt = conn.prepareStatement("A INSERT 쿼리");
		stmt.execute();
		} finally {
			stmt.close();
		}
	}
}
