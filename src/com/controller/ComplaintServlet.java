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
import com.bean.ComplaintBean;
import com.dao.ComplaintDao;

@WebServlet("/ComplaintServlet")
public class ComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ComplaintServlet complaintServlet;

	ComplaintDao dao = new ComplaintDao();

	public ComplaintServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//			request.setAttribute("complaints", dao.viewall());
//			RequestDispatcher rd = request.getRequestDispatcher("/complaint_box.jsp");
//			rd.forward(request, response);

			ArrayList<ComplaintBean> list = dao.viewall();
			RequestDispatcher rd = request.getRequestDispatcher("/complaint_box.jsp");
			request.setAttribute("complaints", list);
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "/admin_home.jsp";
		PrintWriter out = response.getWriter();

//		int complaint_id = 0;
//		if (request.getParameter("complaint_id") != null && request.getParameter("complaint_id").trim().length() > 0) {
//			complaint_id = Integer.parseInt(request.getParameter("complaint_id"));
//		}
		
		String person_name = new String();
		if (request.getParameter("name") != null && request.getParameter("name").trim().length() > 0) {
			person_name = request.getParameter("name");
		}

		String wing = new String();
		if (request.getParameter("wing") != null && request.getParameter("wing").trim().length() > 0) {
			wing = request.getParameter("wing");
		}

		int flat_no = 0;
		if (request.getParameter("flat_no") != null && request.getParameter("flat_no").trim().length() > 0) {
			flat_no = Integer.parseInt(request.getParameter("flat_no"));
		}

		String raised_date = new String();
		if (request.getParameter("date") != null && request.getParameter("date").trim().length() > 0) {
			raised_date = request.getParameter("date");
		}

		String description = new String();
		if (request.getParameter("description") != null && request.getParameter("description").trim().length() > 0) {
			description = request.getParameter("description");
		}

		String status = new String();
		if (request.getParameter("status") != null && request.getParameter("status").trim().length() > 0) {
			status = request.getParameter("status");
		}
		try {
			if (request.getParameter("submit") != null) {
				ComplaintBean a = new ComplaintBean(person_name, wing, flat_no, raised_date, description, status);
				int k = 0;
				k = dao.insertComplaint(a);
				if (k > 0) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Added Successfully...');");
//				    out.println("location='complaint_box.jsp';");
					out.println("</script>");

					ArrayList<ComplaintBean> list = dao.viewall();
					RequestDispatcher rd = request.getRequestDispatcher("/complaint_box.jsp");
					request.setAttribute("complaints", list);
					rd.include(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Add Record');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("update_status") != null) {
				String[] ids = request.getParameterValues("update_status_id");
				ComplaintBean a = new ComplaintBean(ids);				
				Boolean b = dao.update_status(a);
				if (b == true) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Updated Successfully...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Update Record...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("delete") != null) {
				String[] ids = request.getParameterValues("delete_id");
				ComplaintBean a = new ComplaintBean(ids);				
				Boolean b = dao.delete(a);
				if (b == true) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Deleted Successfully...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Delete Record...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}