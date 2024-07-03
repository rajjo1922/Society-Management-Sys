package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StaffMemberBean;
import com.dao.StaffMemberDao;

@WebServlet("/StaffMemberServlet")
public class StaffMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StaffMemberServlet staffMemberServlet;

	StaffMemberDao dao = new StaffMemberDao();

	public StaffMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StaffMemberDao dao = new StaffMemberDao();
		ArrayList<StaffMemberBean> list = dao.getAllStaff();
		RequestDispatcher rd = request.getRequestDispatcher("/view_all_staff.jsp");
		request.setAttribute("usersList", list);
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "/admin_home.jsp";
		String page1 = "/update_staff.jsp";
		PrintWriter out = response.getWriter();

		try {
			int staff_id = 0;
			if (request.getParameter("staff_id") != null && request.getParameter("staff_id").trim().length() > 0) {
				staff_id = Integer.parseInt(request.getParameter("staff_id"));
			}

			String staffName = new String();
			if (request.getParameter("staffName") != null && request.getParameter("staffName").trim().length() > 0) {
				staffName = request.getParameter("staffName");
			}

			String gender = new String();
			if (request.getParameter("gender") != null && request.getParameter("gender").trim().length() > 0) {
				gender = request.getParameter("gender");
			}

			String DOB = new String();
			if (request.getParameter("date") != null && request.getParameter("date").trim().length() > 0) {
				DOB = request.getParameter("date");
			}

			String mobile_no = new String();
			if (request.getParameter("contact") != null && request.getParameter("contact").trim().length() > 0) {
				mobile_no = request.getParameter("contact");
			}

			String aadhar = new String();
			if (request.getParameter("aadhar") != null && request.getParameter("aadhar").trim().length() > 0) {
				aadhar = request.getParameter("aadhar");
			}

			String work_groups = new String();
			if (request.getParameter("work_groups") != null
					&& request.getParameter("work_groups").trim().length() > 0) {
				work_groups = request.getParameter("work_groups");
			}

			String join_date = new String();
			if (request.getParameter("date1") != null && request.getParameter("date1").trim().length() > 0) {
				join_date = request.getParameter("date1");
			}

			int payment_amount = 0;
			if (request.getParameter("payment_amount") != null
					&& request.getParameter("payment_amount").trim().length() > 0) {
				payment_amount = Integer.parseInt(request.getParameter("payment_amount"));
			}

			String leave_date = new String();
			if (request.getParameter("date2") != null && request.getParameter("date2").trim().length() > 0) {
				leave_date = request.getParameter("date2");
			}

			if (request.getParameter("insert") != null) {
				StaffMemberBean a = new StaffMemberBean(staffName, gender, DOB, mobile_no, aadhar, work_groups,
						payment_amount, join_date);
				int k = 0;
				k = dao.insertStaff(a);
				if (k > 0) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Added Successfully...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Add Record');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				}

			} else if (request.getParameter("show") != null) {
				StaffMemberBean a = new StaffMemberBean();
				a = dao.findStaff(staffName);
				if (a.getDob()!= null) {
					request.setAttribute("staffMemberBean", a);
					RequestDispatcher rd = request.getRequestDispatcher(page1);
					rd.forward(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Not Found');");
					out.println("location='show_staff.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("update") != null) {
				StaffMemberBean a = new StaffMemberBean(staff_id, staffName, gender, DOB, mobile_no, aadhar,
						work_groups, payment_amount, join_date);
				Boolean b = dao.updateStaff(a);
				if (b == true) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Updated Successfully...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Update Record...');");
					out.println("location='show_staff.jsp';");
					out.println("</script>");
				}

			} else if (request.getParameter("delete") != null) {
				Boolean b = dao.deleteStaff(staffName);
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

			} else if (request.getParameter("leave") != null) {
				Boolean b = dao.pastStaffMember(staffName, leave_date);
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
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
}
