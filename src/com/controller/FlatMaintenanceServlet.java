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
import com.dao.FlatMaintenanceDao;

@WebServlet("/FlatMaintenanceServlet")
public class FlatMaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FlatMaintenanceDao dao = new FlatMaintenanceDao();

	public FlatMaintenanceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FlatMaintenanceDao dao = new FlatMaintenanceDao();
		ArrayList<WingsFlatsBean> list = dao.viewPaidMaintenance();
		RequestDispatcher rd = request.getRequestDispatcher("/view_maintenance.jsp");
		request.setAttribute("maintenanceList", list);
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String page = "/admin_home.jsp";
		int wing_id = 0;
		if (request.getParameter("wing_id") != null && request.getParameter("wing_id").trim().length() > 0) {
			wing_id = Integer.parseInt(request.getParameter("wing_id"));
		}
		
		int flat_id = 0;
		if (request.getParameter("flat_groups") != null && request.getParameter("flat_groups").trim().length() > 0) {
			flat_id = Integer.parseInt(request.getParameter("flat_groups"));
		}
		
		/*int monthly_maintenance = 0;
		if (request.getParameter("monthly_maintenance") != null
				&& request.getParameter("monthly_maintenance").trim().length() > 0) {
			monthly_maintenance = Integer.parseInt(request.getParameter("monthly_maintenance"));
		}*/
		
		int paid_amount = 0;
		if (request.getParameter("paid_amount") != null && request.getParameter("paid_amount").trim().length() > 0) {
			paid_amount = Integer.parseInt(request.getParameter("paid_amount"));
		}
		
		int bal_maintenance = 0;
		if (request.getParameter("bal_maintenance") != null
				&& request.getParameter("bal_maintenance").trim().length() > 0) {
			bal_maintenance = Integer.parseInt(request.getParameter("bal_maintenance"));
		}
		
		String date = new String();
		if (request.getParameter("date") != null && request.getParameter("date").trim().length() > 0) {
			date = request.getParameter("date");
		}
		
		if (request.getParameter("pay_maintenance") != null) {
			Boolean b = dao.payMaintenance(wing_id, flat_id, paid_amount, bal_maintenance, date);
			if (b == true) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Record Added Successfully...');");
				out.println("location='admin_home.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Unable To Add Record...');");
				out.println("location='admin_home.jsp';");
				out.println("</script>");

			}
		}else if (request.getParameter("add_monthly_maintenance") != null) {
			Boolean b = dao.addMonthlyMaintenance();
			if (b == true) {
				ArrayList<WingsFlatsBean> list = dao.viewMaintenance();
				RequestDispatcher  rd = request.getRequestDispatcher("/update_maintenance.jsp");
				request.setAttribute("maintenanceList", list);
				rd.include(request, response);
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Unable To Add Record...');");
				out.println("location='update_maintenance.jsp';");
				out.println("</script>");
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
		}
	}
}
