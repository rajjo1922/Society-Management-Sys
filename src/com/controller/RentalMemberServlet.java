package com.controller;

import java.io.IOException;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RentalMemberBean;
import com.dao.RentalMemberDao;

@WebServlet("/RentalMemberServlet")
public class RentalMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RentalMemberServlet rentalMemberServlet;

	RentalMemberDao dao = new RentalMemberDao();

	public RentalMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RentalMemberDao dao = new RentalMemberDao();
		ArrayList<RentalMemberBean> list = dao.findAll();
		RequestDispatcher rd = request.getRequestDispatcher("/view_all_renter.jsp");
		request.setAttribute("usersList", list);
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "/admin_home.jsp";
		String page1 = "/update_renter.jsp";
		PrintWriter out = response.getWriter();

		try {
			int renter_id = 0;
			if (request.getParameter("renter_id") != null && request.getParameter("renter_id").trim().length() > 0) {
				renter_id = Integer.parseInt(request.getParameter("renter_id"));
			}

			String renterName = new String();
			if (request.getParameter("renterName") != null && request.getParameter("renterName").trim().length() > 0) {
				renterName = request.getParameter("renterName");
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

			String email = new String();
			if (request.getParameter("email") != null && request.getParameter("email").trim().length() > 0) {
				email = request.getParameter("email");
			}

			int wing_id = 0;
			if (request.getParameter("wing_id") != null && request.getParameter("wing_id").trim().length() > 0) {
				wing_id = Integer.parseInt(request.getParameter("wing_id"));
			}

			int flat_id = 0;
			if (request.getParameter("flat_groups") != null
					&& request.getParameter("flat_groups").trim().length() > 0) {
				flat_id = Integer.parseInt(request.getParameter("flat_groups"));
			}

			int flat_no = 0;
			if (request.getParameter("flat_no") != null && request.getParameter("flat_no").trim().length() > 0) {
				flat_no = Integer.parseInt(request.getParameter("flat_no"));
			}

			String on_rent_date = new String();
			if (request.getParameter("date1") != null && request.getParameter("date1").trim().length() > 0) {
				on_rent_date = request.getParameter("date1");
			}

			int flat_maintenance = 0;
			if (request.getParameter("flat_maintenance") != null
					&& request.getParameter("flat_maintenance").trim().length() > 0) {
				flat_maintenance = Integer.parseInt(request.getParameter("flat_maintenance"));
			}

			String leave_date = new String();
			if (request.getParameter("date2") != null && request.getParameter("date2").trim().length() > 0) {
				leave_date = request.getParameter("date2");
			}

			if (request.getParameter("insert") != null) {
				RentalMemberBean a = new RentalMemberBean(renterName, gender, DOB, mobile_no, aadhar, email, wing_id,
						flat_id, on_rent_date, flat_maintenance);
				System.out.println(a);
				int k = 0;
				k = dao.insertRenter(a);
				if (k > 0) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Added Successfully...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else if (k == 000) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Renter Of This Flat Is Already Added.');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Add Record');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("show") != null) {
				RentalMemberBean a = new RentalMemberBean();
				a = dao.findRenter(flat_no);				
				if (a.getRenter_name() != null) {
					request.setAttribute("rentalMemberBean", a);
					RequestDispatcher rd = request.getRequestDispatcher(page1);
					rd.forward(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Not Found...');");
					out.println("location='show_renter.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("update") != null) {
				RentalMemberBean a = new RentalMemberBean(renter_id, renterName, gender, DOB, mobile_no, aadhar, email,
						on_rent_date, flat_maintenance);
				Boolean b = dao.update(a);
				if (b == true) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Updated Successfully...');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Update Record...');");
					out.println("location='show_renter.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("delete") != null) {
				Boolean b = dao.remove(renterName);
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
				Boolean b = dao.pastMember(renterName, leave_date);
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
