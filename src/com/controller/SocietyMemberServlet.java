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
import javax.servlet.http.HttpSession;

import com.bean.SocietyMemberBean;
import com.dao.SocietyMemberDao;

@WebServlet("/SocietyMemberServlet")
public class SocietyMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;
	SocietyMemberServlet societyMemberServlet;

	SocietyMemberDao dao = new SocietyMemberDao();

	public SocietyMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SocietyMemberDao dao = new SocietyMemberDao();
		ArrayList<SocietyMemberBean> list = dao.findAll();
		RequestDispatcher rd = request.getRequestDispatcher("/view_all_member.jsp");
		request.setAttribute("usersList", list);
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = "/admin_home.jsp";
		String page1 = "/update_member.jsp";
		PrintWriter out = response.getWriter();
		try {
			int member_id = 0;
			if (request.getParameter("member_id") != null && request.getParameter("member_id").trim().length() > 0) {
				member_id = Integer.parseInt(request.getParameter("member_id"));
			}

			String ownerName = new String();
			if (request.getParameter("ownerName") != null && request.getParameter("ownerName").trim().length() > 0) {
				ownerName = request.getParameter("ownerName");
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

			String rented = new String();
			if (request.getParameter("rented") != null && request.getParameter("rented").trim().length() > 0) {
				rented = request.getParameter("rented");
			}

			int maintenance_amt = 0;
			if (request.getParameter("maintenance_amt") != null
					&& request.getParameter("maintenance_amt").trim().length() > 0) {
				maintenance_amt = Integer.parseInt(request.getParameter("maintenance_amt"));
			}

			String buy_date = new String();
			if (request.getParameter("date1") != null && request.getParameter("date1").trim().length() > 0) {
				buy_date = request.getParameter("date1");
			}

			String sold_date = new String();
			if (request.getParameter("date2") != null && request.getParameter("date2").trim().length() > 0) {
				sold_date = request.getParameter("date2");
			}

			if (request.getParameter("insert") != null) {
				SocietyMemberBean a = new SocietyMemberBean(ownerName, gender, DOB, mobile_no, aadhar, email, wing_id,
						flat_id, rented, maintenance_amt, buy_date);
				int k = 0;
				k = dao.insertMember(a);
				if (k > 0) {
					out.println("<script type=\"text/javascript\">");
					if (rented.equals("Yes")) {
						out.println("alert('Record Added Successfully...Now Insert Renter Information...');");
						out.println("location='admin_home.jsp';");

//						WingServlet w = new WingServlet();
//						request.setAttribute("req1", 3);
//						w.doGet(request, response);

//						RequestDispatcher rd = request.getRequestDispatcher("/add_renter.jsp");
//						rd.forward(request, response);
					} else {
						out.println("alert('Record Added Successfully...');");
						out.println("location='admin_home.jsp';");
					}
					out.println("</script>");
				} else if (k == 000) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Owner Of This Flat Is Already Added.');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Add Record');");
					out.println("location='admin_home.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("show") != null) {
				SocietyMemberBean a = new SocietyMemberBean();
				a = dao.findMember(flat_no);
				request.setAttribute("societyMemberBean", a);
				if (a.getOwner_name() != null) {
					RequestDispatcher rd = request.getRequestDispatcher(page1);
					rd.forward(request, response);
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Not Found');");
					out.println("location='show_member.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("update") != null) {
				SocietyMemberBean a = new SocietyMemberBean(member_id, ownerName, gender, DOB, mobile_no, aadhar, email,
						rented, maintenance_amt, buy_date);
				Boolean b = dao.update(a);
				if (b == true) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Record Updated Successfully...');");
					out.println("location='admin_home.jsp';");
					/*
					 * if (rented.equals("Yes")) { // RequestDispatcher rd =
					 * request.getRequestDispatcher("/add_renter.jsp"); // rd.forward(request,
					 * response); out.
					 * println("alert('Record Added Successfully...Now Insert Renter Information...');"
					 * ); out.println("location='admin_home.jsp';"); } else {
					 * out.println("alert('Record Updated Successfully...');");
					 * out.println("location='admin_home.jsp';"); }
					 */
					out.println("</script>");
				} else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable To Update Record...');");
					out.println("location='show_member.jsp';");
					out.println("</script>");
				}
			} else if (request.getParameter("delete") != null) {
				Boolean b = dao.remove(ownerName);
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
			} else if (request.getParameter("sold") != null) {
				Boolean b = dao.pastMember(ownerName, sold_date);
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
