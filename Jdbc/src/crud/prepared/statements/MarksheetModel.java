package crud.prepared.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	public void add(MarksheetBean bean) throws ClassNotFoundException, SQLException {	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","root");
		PreparedStatement pstmt=conn.prepareStatement("insert into st_Marksheet values (?,?,?,?,?,?)");
		
		pstmt.setInt(1,bean.getId());
		pstmt.setInt(2, bean.getRollno());
		pstmt.setString(3, bean.getName());
		pstmt.setInt(4, bean.getPhy());
		pstmt.setInt(5, bean.getChem());
		pstmt.setInt(6, bean.getMaths());
		
		int i=pstmt.executeUpdate();
		System.out.println(i+" rows affected");
		conn.close();
		pstmt.close();	
	}
	public void update(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","root");
		PreparedStatement pstmt=conn.prepareStatement("update st_Marksheet set rollno=?,name=?,phy=?,chem=?,maths=? where id=?");
		
		
		pstmt.setInt(1, bean.getRollno());
		pstmt.setString(2, bean.getName());
		pstmt.setInt(3, bean.getPhy());
		pstmt.setInt(4, bean.getChem());
		pstmt.setInt(5, bean.getMaths());
		pstmt.setInt(6, bean.getId());
		
		int i=pstmt.executeUpdate();
		System.out.println(i+" rows affected");
		conn.close();
		pstmt.close();
		
	}
	public void delete(MarksheetBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","root");
		PreparedStatement pstmt=conn.prepareStatement("delete from st_Marksheet where id =?");
		
		pstmt.setInt(1,bean.getId());
		int i=pstmt.executeUpdate();
		System.out.println(i+" rows affected");
		conn.close();
		pstmt.close();
		
	}
	public MarksheetBean findByRollNo(int rollNo) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_Marksheet where rollno= ?");

		pstmt.setInt(1, rollNo);

		ResultSet rs = pstmt.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
			
		}
		
		return bean;
		
	}
	public List search() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","root");
		PreparedStatement pstmt=conn.prepareStatement("select * from st_Marksheet");
		ResultSet rs=pstmt.executeQuery();
		MarksheetBean bean=null;
		List<MarksheetBean> list=new ArrayList();
		
		while(rs.next()) {
			bean=new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChem(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
			list.add(bean);
			
		}
		return list;
		
		
		
		
		
		
	}
	

}
