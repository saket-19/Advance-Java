package crud.prepared.statements;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		// testUpdate();
		// testDelete();
		// testfindByLogin();
		// testSearch();
		testSearchByFilter();
	}

	public static void testUpdate() throws ClassNotFoundException, SQLException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(101);
		bean.setName("shyam");
		bean.setLogin("shyam@gmail.com");
		bean.setPassword("1234");
		bean.setDob(sdf.parse("2000-09-11"));

		model.update(bean);
	}

	public static void testDelete() throws ClassNotFoundException, SQLException {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(101);
		model.delete(bean);

	}

	public static void testfindByLogin() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLogin("ram@gmail.com");

		if (bean == null) {
			System.out.println("user not found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	public static void testSearch() throws ClassNotFoundException, SQLException {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		List list = model.search();

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());

			System.out.println("--------------");
		}

	}

	public static void testSearchByFilter() throws ClassNotFoundException, SQLException {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setName("s");
		List list = model.searchByFilter(bean);

		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());

			System.out.println("--------------");
		}

	}

}
