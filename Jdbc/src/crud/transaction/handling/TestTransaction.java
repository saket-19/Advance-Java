package crud.transaction.handling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_marksheet values(6, 106, 'jay', 23,34,67)");

			i = stmt.executeUpdate(
					"insert into st_marksheet values(7, 107, 'jay', 23,34,67)");

			i = stmt.executeUpdate(
					"insert into st_marksheet values(8, 108, 'jay', 23,34,67)");
			
			conn.commit();
			System.out.println("record inserted");

			conn.close();
			stmt.close();

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}

}
