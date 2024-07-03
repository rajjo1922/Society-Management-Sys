<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Past Rental Members</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>Renter Name</th>
					<th>Gender</th>
					<th>DOB</th>
					<th>Mobile No.</th>
					<th>Aadhar No.</th>
					<th>Email Id</th>
					<th>Wing</th>
					<th>Flat No.</th>
					<th>Maintenance</th>
					<th>On Rent Date</th>
					<th>Leave Date</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${usersList}" var="user">
						<tr>
							<td><c:out value="${user.renter_name}" /></td>
							<td><c:out value="${user.gender}" /></td>
							<td><c:out value="${user.dob}" /></td>
							<td><c:out value="${user.mobile_no}" /></td>
							<td><c:out value="${user.aadhar_no}" /></td>
							<td><c:out value="${user.email_id}" /></td>
							<td><c:out value="${user.wing_name}" /></td>
							<td><c:out value="${user.flat_no}" /></td>
							<td><c:out value="${user.flat_maintenance}" /></td>
							<td><c:out value="${user.on_rent_date}" /></td>
							<td><c:out value="${user.leave_date}" /></td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- end for class "container" -->
</body>
</html>
