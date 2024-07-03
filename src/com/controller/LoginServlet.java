package com.controller;

import com.bean.LoginBean;
import com.dao.LoginDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HttpSession session;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Here username and password are the names which I have given in the input box
		// in Login.jsp page. Here I am retrieving the values entered by the user and
		// keeping in instance variables for further use.

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginBean loginBean = new LoginBean(); // creating object for LoginBean class, which is a normal java class,
												// contains just setters and getters. Bean classes are efficiently used
												// in java to access user information wherever required in the
												// application.

		loginBean.setUsername(username); // setting the username and password through the loginBean object then only you
											// can get it in future.
		loginBean.setPassword(password);

		LoginDao loginDao = new LoginDao(); // creating object for LoginDao. This class contains main logic of the
											// application.

		String userValidate = loginDao.authenticateUser(loginBean); // Calling authenticateUser function

		if (userValidate.equals("SUCCESS")) // If function returns success string then user will be rooted to Home page
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("admin_home.jsp");

//			HttpSession session = request.getSession(true); // reuse existing
//			session.setAttribute("username", username);
//			session.setMaxInactiveInterval(30); // 30 seconds
//			response.sendRedirect("admin_home.jsp");

//			session = request.getSession();
//			session.setAttribute("username", username);
//			// request.setAttribute("username", username); // with setAttribute() you can
//			// define a "key" and value pair so
//			// that you can get it in future using getAttribute("key")
//			response.sendRedirect("admin_home.jsp");
//			// request.getRequestDispatcher("/menu.jsp").forward(request,
//			// response);//RequestDispatcher is used to send the control to the invoked
//			// page.
		} else {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			out.println("<script type=\"text/javascript\">");
			out.println("alert('Either username or password is wrong.');");
			out.println("location='index.jsp';");
			out.println("</script>");
			
/*			//request.setAttribute("alertMsg", "Either username or password is wrong.");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			out.println("<font color=red><center>Either user name or password is wrong.</center></font>");
			rd.include(request, response);
*/
			
			
			// HttpSession session = request.getSession();
//	session.setAttribute("errMessage", userValidate);
			// request.setAttribute("errMessage", userValidate); // If authenticateUser()
			// function returnsother than
			// SUCCESS string it will be sent to Login page again.
			// Here the error message returned from function has
			// been stored in a errMessage key.
//	request.getRequestDispatcher("/index.jsp").forward(request, response);// forwarding the request
		}
	}
}
