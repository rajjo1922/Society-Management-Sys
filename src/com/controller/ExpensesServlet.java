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
import com.bean.ExpensesBean;
import com.dao.ExpensesDao;

@WebServlet("/ExpensesServlet")
public class ExpensesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ExpensesDao dao = new ExpensesDao();

	public ExpensesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArrayList<ExpensesBean> list = dao.viewall();
			RequestDispatcher rd = request.getRequestDispatcher("/expenses_details.jsp");
			request.setAttribute("expenses", list);
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("submit") != null) {
			PrintWriter out = response.getWriter();

			String purpose = request.getParameter("purpose");
			int wing_id = Integer.parseInt(request.getParameter("wing_id"));
			int flat_id = Integer.parseInt(request.getParameter("flat_groups"));
			String done_by = request.getParameter("done_by");
			String client_name = request.getParameter("client_name");
			String date = request.getParameter("date");
			int expense_amount = Integer.parseInt(request.getParameter("expense_amount"));

			try {
				ExpensesBean a = new ExpensesBean(purpose, wing_id, flat_id, done_by, client_name, date, expense_amount);
				int k = 0;
				k = dao.insertExpense(a);
				if (k > 0) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Added Successfully...');");
					out.println("</script>");

					ArrayList<ExpensesBean> list = dao.viewall();
					RequestDispatcher rd = request.getRequestDispatcher("/expenses.jsp");
					request.setAttribute("expenses", list);
					rd.include(request, response);

				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Add Record');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			System.out.println("Not getting any button input...");
	}

}
