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

import com.bean.StaffAttendanceBean;
import com.dao.StaffAttendanceDao;
import com.bean.StaffMemberBean;
import com.dao.StaffMemberDao;

@WebServlet("/StaffAttendanceServlet")
public class StaffAttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StaffAttendanceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StaffMemberDao dao = new StaffMemberDao();
		ArrayList<StaffMemberBean> list = dao.getAllStaff();
		RequestDispatcher rd = request.getRequestDispatcher("/mark_attendance.jsp");
		request.setAttribute("attendance", list);
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StaffAttendanceDao dao = new StaffAttendanceDao();
		String page = "/admin_home.jsp";
		PrintWriter out = response.getWriter();

		try {
			int staff_id = 0;
			if (request.getParameter("staff_id") != null && request.getParameter("staff_id").trim().length() > 0) {
				staff_id = Integer.parseInt(request.getParameter("staff_id"));
			}

			String date = new String();
			if (request.getParameter("date") != null && request.getParameter("date").trim().length() > 0) {
				date = request.getParameter("date");
			}

			String attendance = new String();
			if (request.getParameter("attendance") != null && request.getParameter("attendance").trim().length() > 0) {
				attendance = request.getParameter("attendance");
			}
			String from_date = new String();
			if (request.getParameter("date") != null && request.getParameter("date").trim().length() > 0) {
				from_date = request.getParameter("date");
			}

			String to_date = new String();
			if (request.getParameter("date1") != null && request.getParameter("date1").trim().length() > 0) {
				to_date = request.getParameter("date1");
			}
			
			String work_groups = new String();
			if (request.getParameter("work_groups") != null
					&& request.getParameter("work_groups").trim().length() > 0) {
				work_groups = request.getParameter("work_groups");
			}

			
			if (request.getParameter("save") != null) {
				String[] idsToMark = request.getParameterValues("attendance");
				for (int i = 0; i < idsToMark.length; i++) {
					System.out.println(idsToMark[i]);
				}
				StaffAttendanceBean a = new StaffAttendanceBean(idsToMark, date);
				int k = 0;
				k = dao.insertAttendance(a);
				if (k > 0) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Added Successfully...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Add Record');");
					out.println("location='mark_attendance.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("update") != null) {
				StaffAttendanceBean a = new StaffAttendanceBean(staff_id, date, attendance);
				Boolean b = dao.updateAttendnace(a);
				if (b == true) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Updated Successfully...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">s");
					out.println("alert('Unable To Update Record...');");
					out.println("location='mark_attendance.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("view") != null) {
				StaffAttendanceBean a = new StaffAttendanceBean(from_date, to_date,work_groups);
				ArrayList<StaffAttendanceBean> list = dao.findAttendanceByDate(a);
				RequestDispatcher rd = request.getRequestDispatcher("/view_attendance.jsp");
				request.setAttribute("usersList", list);
				rd.include(request, response);
			} else if (request.getParameter("delete") != null) {
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}
}
