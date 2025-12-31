package crud.prepared.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class UserModel {
	public void update(UserBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");
		PreparedStatement pstmt = conn
				.prepareStatement("update st_user set name=?,login=?,password=?,Dob=? where id=? ");

		pstmt.setString(1, bean.getName());
		pstmt.setString(2, bean.getLogin());
		pstmt.setString(3, bean.getPassword());
		pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(5, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println(i + " rows affected");

		conn.close();
		pstmt.close();

	}

	public void delete(UserBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id=? ");

		pstmt.setInt(1, 101);
		int i = pstmt.executeUpdate();
		System.out.println(i + " rows affected");

		conn.close();
		pstmt.close();
	}

	public UserBean findByLogin(String login) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where login = ?");

		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLogin(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setDob(rs.getDate(5));

		}

		return bean;

	}

	public List search() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user");
		ResultSet rs = pstmt.executeQuery();
		UserBean bean = null;
		List<UserBean> list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLogin(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setDob(rs.getDate(5));
			list.add(bean);

		}
		return list;

	}

	public List searchByFilter(UserBean bean) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/people", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and Name like '" + bean.getName() + "%'");

			}
		}
		System.out.println("sql ===> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setLogin(rs.getString(3));
			bean.setPassword(rs.getString(4));
			bean.setDob(rs.getDate(5));

			list.add(bean);
		}

		return list;

	}

}
