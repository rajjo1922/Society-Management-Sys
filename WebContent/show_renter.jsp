<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Renter Members</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="jumbotron">
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/RentalMemberServlet">

				<!-- <div class="col-sm-3">
					<input type="text" name="renterName" id="renterName"
						placeholder="Renter Name" style="padding-right: 15px"
						class="form-control" title="Enter Renter Name" />
				</div> -->
				<div class="col-sm-4" style="padding-right: 20px;">
					<label>Enter Renter Flat Number :</label> <input type="text"
						name="flat_no" id="flat_no" placeholder="Ex. 101"
						style="padding-right: 15px;" class="form-control"
						title="Enter Flat Number" autocomplete="off"
						onkeypress="return restrictAlphabets(event)" required>
				</div><br>
				<input type="submit" name="show" class="btn btn-primary" id="Show"
					value="Show" /> <input type="button" name="cancel"
					class="btn btn-primary" id="cancel" value="Cancel"
					onclick="location.href='admin_home.jsp';" />

				<!-- 
		<input type="text" name="r_Name"
				id="r_Name" placeholder="Renter Name" style="padding-right: 15px"
				class="form-control"> <input type="text" name="flat_no"
				id="flat_no" placeholder="Flat Number" style="margin-left: 50px"
				class="form-control">
			<button type="Submit" name="search" class="btnbtn-primary">
				<span style="float: right;" class="glyphicon glyphicon-search"></span>
			</button>
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