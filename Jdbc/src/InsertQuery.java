import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");
		
		Statement stmt = conn.createStatement();
		
		int rows=stmt.executeUpdate("insert into marksheet values(18,117,'ram',55,87,49)");
		
		System.out.println(rows+" rows affected");
		
		
		
		
   }

}
