package crud.callable.statements;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SearchCallable {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");

		CallableStatement ctmt = conn.prepareCall("{CALL searchById()}");
		
		ResultSet rs=ctmt.executeQuery();
		
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getInt(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getInt(4));
			System.out.println(rs.getInt(5));
			System.out.println(rs.getInt(6));
		}

		conn.close();
		ctmt.close();

	}

}
