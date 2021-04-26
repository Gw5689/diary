package gdu.diary.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/diary","root","java1004");
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		// finally를 넣지 않는 이유는 리턴을 해줘야 하는데 close를 하면 사용할 수 없다. close는 호출한 곳에서 close를 해야한다.
		return conn;
	}
}
