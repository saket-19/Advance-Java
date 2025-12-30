import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","root");
		Statement stmt=conn.createStatement();
		int rows=stmt.executeUpdate("update marksheet set name='raghu' where id=16");
		System.out.println(rows +" rows affected");
	}

}
