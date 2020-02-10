package demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.constant.Field;
import demo.constant.View;

@WebServlet(urlPatterns = "/login")
public class Login extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2058163004957236959L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean authorized=authorized(request);
		if(authorized) {
			redirect(request,response,"/todo/home");
		}else {
			request.getRequestDispatcher(View.loginPage).forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter(Field.username);
		String password=request.getParameter(Field.password);
		if(username==null || password ==null || username.isEmpty() || password.isEmpty()) {
			request.getRequestDispatcher(View.loginPage).forward(request, response);
		}else if(username.equalsIgnoreCase("demo") && password.equalsIgnoreCase("demo")) {
			HttpSession session=request.getSession(true);
			session.setAttribute(Field.AUTHORIZE, true);
			redirect(request,response,"/todo/home");
		}else {
			request.getRequestDispatcher(View.loginPage).forward(request, response);
		}
	}

}
