package gdu.diary.dao;

import java.sql.*;

import gdu.diary.util.DBUtil;

public class BDao {
	public void insert(Connection conn) throws SQLException {
		PreparedStatement stmt = null;
		try {
		stmt = conn.prepareStatement("B INSERT 쿼리");
		stmt.execute();
		} finally {
			stmt.close();
		}
	}
}
