package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.WingsFlatsBean;
import com.dao.WingsFlatsDao;

@WebServlet("/WingServlet")
public class WingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	WingsFlatsDao dao = new WingsFlatsDao();

	public WingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * HashMap<String, String> list; list = dao.getWings();
		 * request.setAttribute("wingsList", list); System.out.println(list);
		 */

		int req = Integer.parseInt(request.getParameter("request"));

		ArrayList<WingsFlatsBean> list = dao.getWing();
		RequestDispatcher rd = null;
		if (req == 1) {
			rd = request.getRequestDispatcher("/add_flat.jsp");
			request.setAttribute("wingsList", list);
			rd.include(request, response);
		} else if (req == 2) {
			rd = request.getRequestDispatcher("/add_member.jsp");
			request.setAttribute("wingsList", list);
			rd.include(request, response);
		} else if (req == 3) {
			rd = request.getRequestDispatcher("/add_renter.jsp");
			request.setAttribute("wingsList", list);
			rd.include(request, response);
		} else if (req == 4) {
			rd = request.getRequestDispatcher("/view_flats.jsp");
			ArrayList<WingsFlatsBean> list1 = dao.getFlatDetails();
			request.setAttribute("flatsList", list1);
			rd.include(request, response);
		} else if (req == 5) {
			rd = request.getRequestDispatcher("/expenses.jsp");
			request.setAttribute("wingsList", list);
			rd.include(request, response);
		} else if (req == 6) {
			rd = request.getRequestDispatcher("/pay_maintenance.jsp");
			request.setAttribute("wingsList", list);
			rd.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String wing_name = new String();
		if (request.getParameter("wing_name") != null && request.getParameter("wing_name").trim().length() > 0) {
			wing_name = request.getParameter("wing_name");
		}
		if (request.getParameter("insert_wing") != null) {
			Boolean b = dao.insertWing(wing_name);
			if (b == true) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Record Added Successfully...');");
				out.println("location='add_wing.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Wing Already Exits. Unable To Add Record...');");
				out.println("location='add_wing.jsp';");
				out.println("</script>");
			}
		}

	}
}
