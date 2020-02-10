package demo.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.constant.Field;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5700174334541256817L;

	protected boolean authorized(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Boolean authorized=(Boolean) session.getAttribute(Field.AUTHORIZE);
		if(authorized==null || authorized.equals(Boolean.FALSE)) {
			return false;
		}else {
			return true;
		}
	}
	
	protected void clearSession(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
	}
	

	protected void redirect(HttpServletRequest request,HttpServletResponse response,String url) throws IOException {
		response.sendRedirect(request.getServletContext().getContextPath()+url);
	}
}
