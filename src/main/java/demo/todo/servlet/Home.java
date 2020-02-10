package demo.todo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.constant.View;
import demo.servlet.BaseServlet;
@WebServlet(urlPatterns="/todo/home")
public class Home extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7755711320707730899L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(View.homePage).forward(request, response);
	}

}
