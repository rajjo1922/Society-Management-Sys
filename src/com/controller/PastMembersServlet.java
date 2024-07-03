package com.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.RentalMemberBean;
import com.bean.SocietyMemberBean;
import com.bean.StaffMemberBean;
import com.dao.RentalMemberDao;
import com.dao.SocietyMemberDao;
import com.dao.StaffMemberDao;

@WebServlet("/PastMembersServlet")
public class PastMembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PastMembersServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SocietyMemberDao daoSociety = new SocietyMemberDao();
		RentalMemberDao daoRenter = new RentalMemberDao();
		StaffMemberDao daoStaff = new StaffMemberDao();

		int req = Integer.parseInt(request.getParameter("req"));

		RequestDispatcher rd = null;
		if (req == 1) {
			ArrayList<SocietyMemberBean> list = daoSociety.findAllPastMember();
			rd = request.getRequestDispatcher("/past_member.jsp");
			request.setAttribute("usersList", list);
			rd.include(request, response);

		} else if (req == 2) {
			ArrayList<RentalMemberBean> list = daoRenter.findAllPastMember();
			rd = request.getRequestDispatcher("/past_renter.jsp");
			request.setAttribute("usersList", list);
			rd.include(request, response);

		} else if (req == 3) {
			ArrayList<StaffMemberBean> list = daoStaff.findAllPastMember();
			rd = request.getRequestDispatcher("/past_staff.jsp");
			request.setAttribute("usersList", list);
			rd.include(request, response);
		}

	}
}
