<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Past Society Members</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Owner Name</th>
					<th>Gender</th>
					<th>DOB</th>
					<th>Mobile No.</th>
					<th>Aadhar No.</th>
					<th>Email Id</th>
					<th>Wing</th>
					<th>Flat No.</th>
					<th>Rental Status</th>
					<th>Maintenance</th>
					<th>Buy Date</th>
					<th>Sold Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usersList}" var="user">
					<tr>
						<td><c:out value="${user.owner_name}" /></td>
						<td><c:out value="${user.gender}" /></td>
						<td><c:out value="${user.dob}" /></td>
						<td><c:out value="${user.mobile_no}" /></td>
						<td><c:out value="${user.aadhar_no}" /></td>
						<td><c:out value="${user.email_id}" /></td>
						<td><c:out value="${user.wing_name}" /></td>
						<td><c:out value="${user.flat_no}" /></td>
						<td><c:out value="${user.rental_status}" /></td>
						<td><c:out value="${user.flat_maintenance}" /></td>
						<td><c:out value="${user.buy_date}" /></td>
						<td><c:out value="${user.sold_date}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- end for class "container" -->
</body>
</html>
