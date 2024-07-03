package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.WingsFlatsBean;
import com.dao.WingsFlatsDao;
import com.google.gson.Gson;

@WebServlet("/FlatServlet")
public class FlatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	WingsFlatsDao dao = new WingsFlatsDao();

	public FlatServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int req = Integer.parseInt(request.getParameter("req"));

		int wing_id = 0;
		if (request.getParameter("wing_id") != null && request.getParameter("wing_id").trim().length() > 0) {
			wing_id = Integer.parseInt(request.getParameter("wing_id"));
		}
		int flat_id = 0;
		if (request.getParameter("flat_id") != null && request.getParameter("flat_id").trim().length() > 0) {
			flat_id = Integer.parseInt(request.getParameter("flat_id"));
		}
		WingsFlatsDao dao = new WingsFlatsDao();
		if (req == 1) {
			ArrayList<WingsFlatsBean> flatsList = dao.getFlatsByWing(wing_id);

			String json = new Gson().toJson(flatsList);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
		}
		if (req == 2) {
			ArrayList<WingsFlatsBean> flatsList = dao.getFlatsMaintenance(flat_id);

			String json = new Gson().toJson(flatsList);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			/*
			 * } else if (req == 3) { String json = new Gson().toJson(flatsList);
			 * response.setContentType("application/json");
			 * response.setCharacterEncoding("UTF-8"); response.getWriter().write(json);
			 */ }
//			System.out.println(list);
//			obj1.put("arrayName", list);
//			response.getWriter().write(obj1.toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int wing_groups = 0;
		if (request.getParameter("wing_groups") != null && request.getParameter("wing_groups").trim().length() > 0) {
			wing_groups = Integer.parseInt(request.getParameter("wing_groups"));
		}

		int flat_no = 0;
		if (request.getParameter("flat_no") != null && request.getParameter("flat_no").trim().length() > 0) {
			flat_no = Integer.parseInt(request.getParameter("flat_no"));
		}

		if (request.getParameter("insert_flat") != null) {
			Boolean b = dao.insertFlat(wing_groups, flat_no);
			// System.out.println("**" + b);
			if (b == true) {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Record Added Successfully...');");
				out.println("location='admin_home.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Flat Already Exits. Unable To Add Record...');");
				out.println("location='admin_home.jsp';");
				out.println("</script>");

			}
		}

	}

}
