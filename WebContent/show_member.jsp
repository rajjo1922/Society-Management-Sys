<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Society Members</title>
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
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/SocietyMemberServlet">

				<!-- 		<div class="col-sm-3">
					<input type="text" name="ownerName" id="ownerName"
						placeholder="Owner Name" style="padding-right: 15px"
						class="form-control" title="Enter Owner Name" />
				</div> -->
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

				<!-- 
				<div class="col-sm-3">
					<input class="form-control" type="text" name="o_Name" id="o_Name"
						placeholder="Owner Name" title="Enter Owner Name">
				</div>
				<div class="col-sm-3">
					<input class="form-control" type="text" name="flat_no" id="flat_no"
						placeholder="Flat Number" style="margin-left: 5px"
						title="Enter Flat Number">
				</div>
				<div class="col-sm-2" style="padding-right: 10px;">
					<button type="Submit" name="search" class="btn btn-primary">
						<span style="float: right;" class="glyphicon glyphicon-search"></span>
					</button>
				</div>

				<div class="form-group">
					<input type="hidden" class="form-control" id="operation"
						name="operation" value="show" />
				</div>
				<div class="col-sm-4" style="padding-right: 20px;">
					<button type="Submit" name="cancel" class="btn btn-primary" a
						href="admin_home.jsp">Cancel</button>
				</div>
				-->
			</form>
		</div>
	</div>
	<!-- end for class "container" -->
</body>
</html>