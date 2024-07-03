package com.report.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.WingsFlatsBean;
import com.util.DBConnection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn = DBConnection.getConnection();

	JasperReport jasperReport = null;
	JasperDesign jasperDesign = null;

	HashMap<String, Object> hm = new HashMap<>();

	public ReportServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String req = request.getParameter("request");
		System.out.println("In Report Controller" + req);

		if (req.equals("MembersReport")) {
			try {
				String path = getServletContext().getRealPath("/WEB-INF/reports");
				jasperDesign = JRXmlLoader.load(path + "/AllSocietyMembersReport.jrxml");
				jasperReport = JasperCompileManager.compileReport(jasperDesign);
				byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, hm, conn);
				OutputStream outStream = response.getOutputStream();
				response.setHeader("Content-Disposition", "inline; filename=AllSocietyMembersReport.pdf");
				response.setContentType("application/pdf");
				response.setContentLength(byteStream.length);
				response.flushBuffer();
				outStream.write(byteStream, 0, byteStream.length);
			} catch (JRException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long flat_no = Long.parseLong(request.getParameter("flat_no"));
		System.out.println("In Report Controller");

		try {
			System.out.println(flat_no);

			hm.put("flat", flat_no);

			System.out.println(hm);

//			Map parameters = new HashMap();
//			parameters.put(flat_no, flat_no);

// Method 1			
			String path = getServletContext().getRealPath("/WEB-INF/reports");
			jasperDesign = JRXmlLoader.load(path + "/SocietyMemberReport.jrxml");
			jasperReport = JasperCompileManager.compileReport(jasperDesign);
			byte[] byteStream = JasperRunManager.runReportToPdf(jasperReport, hm, conn);
			OutputStream outStream = response.getOutputStream();
			response.setHeader("Content-Disposition", "inline; filename=SocietyMemberReport.pdf");
			response.setContentType("application/pdf");
			response.setContentLength(byteStream.length);
			response.flushBuffer();
			outStream.write(byteStream, 0, byteStream.length);

// Method 2
			// String exportPath = "/E://xz/report.pdf";
			// jasperDesign = JRXmlLoader.load(path + "/report2.jrxml");
			// jasperReport = JasperCompileManager.compileReport(jasperDesign);
			// JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
			// parameters, conn);
			// JasperExportManager.exportReportToPdfFile(jasperPrint, exportPath);

			/*
			 * Content-Type: application/pdf Content-Disposition: attachment;
			 * filename="filename.pdf"
			 */
		} catch (JRException e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
