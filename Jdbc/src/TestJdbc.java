import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestJdbc {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Make connection to the Database9
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");
		
		// Create Statement
		Statement stmt = conn.createStatement();
		
		// Execute query and get ResultSet
		ResultSet rs=stmt.executeQuery("select * from marksheet;");
		
		System.out.println("connection succesfull");
		
		while(rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getInt(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.println("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}

	}

}
