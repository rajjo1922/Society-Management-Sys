<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Society Member Report</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="jumbotron">
			<%-- <form class="form-horizontal" method="POST"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/ReportServlet">
				<a href="ReportServlet" target="blank_"> Genrate Report</a>
		</form> --%>
			<form class="form-horizontal" method="POST"
				action="${pageContext.request.contextPath}/ReportServlet" target="blank_">
				<div class="col-sm-4" style="padding-right: 20px;">
					<label>Enter Owner Flat Number :</label> <input type="text"
						name="flat_no" id="flat_no" placeholder="Ex.101"
						style="padding-right: 15px" class="form-control"
						title="Enter Flat Number" autocomplete="off"
						onkeypress="return restrictAlphabets(event)" required>
				</div> <br>
				<input type="submit" name="show" class="btn btn-primary" id="Show"
					value="Show" /> <input type="button" name="cancel"
					class="btn btn-primary" id="cancel" value="Cancel"
					onclick="location.href='admin_home.jsp';" />
			</form>
		</div>
	</div>
	<!-- end for class "container" -->
</body>
</html>