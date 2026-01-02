package rays.resource.bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TestResourceBundle {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ResourceBundle rb=ResourceBundle.getBundle("rays.resource.bundle.app");
		String url=rb.getString("url");
		String driver=rb.getString("driver");
		String user=rb.getString("username");
		String password=rb.getString("password");
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,user,password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from st_marksheet");
		
		while(rs.next()) {
			System.out.println("\t"+rs.getInt(1));
			System.out.println("\t"+rs.getInt(2));
			System.out.println("\t"+rs.getString(3));
			System.out.println("\t"+rs.getInt(4));
			System.out.println("\t"+rs.getInt(5));
			System.out.println("\t"+rs.getInt(6));
		}
		
		
		
		
	}

}
