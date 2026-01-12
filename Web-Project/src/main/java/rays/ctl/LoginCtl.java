package rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rays.bean.UserBean;
import rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		if (op != null) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("successMsg", "user logged out successfully");
		}
		RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		String op = request.getParameter("operation");
		if (op.equals("signUp")) {
			response.sendRedirect("UserRegistrationCtl");
		}

		bean.setLogin(login);
		bean.setPassword(password);

		HttpSession session = request.getSession();

		try {
			bean = model.authenticate(bean.getLogin(), bean.getPassword());
			if (bean != null) {
				System.out.println("User logged in successfully");
				session.setAttribute("user", bean);
				response.sendRedirect("WelcomeCtl");
			} else {
				System.out.println("invalid login or password");
			}

		} catch (Exception e) {

		}

	}

}
