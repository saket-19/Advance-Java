import java.text.SimpleDateFormat;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
		testAdd();
		
	}

	private static void testAdd() throws Exception {
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	   UserModel model=new UserModel();
	   UserBean bean=new UserBean();
	   
	   bean.setId(101);
	   bean.setName("saket");
	   bean.setLogin("saket@gmail.com");
	   bean.setPassword("saket123");
	   bean.setDob(sdf.parse("2003-06-19"));
	   
	   model.add(bean);
		
	}

	

}
