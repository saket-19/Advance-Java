import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserModel {
	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","root");
		PreparedStatement pstmt=conn.prepareStatement("insert into st_user values(?,?,?,?,?)");
		
		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5,new java.sql.Date(bean.getDob().getTime()));
		
		int i=pstmt.executeUpdate();
		System.out.println(i +" rows affected");
		conn.close();
		pstmt.close();
		
		
		
	}

}
