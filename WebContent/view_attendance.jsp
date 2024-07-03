<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Staff Members Attendance</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<form class="form-horizontal" method="POST"
			onsubmit="return validate()"
			action="${pageContext.request.contextPath}/StaffAttendanceServlet">

			<div class="col-sm-3" style="padding-right: 25px;">
				<div class="form-group">
					<label>From Date</label> <input class="form-control" id="date"
						name="date" placeholder="YYYY-MM-DD" type="text"
						onkeypress="return restrictAlphabets(event)" autocomplete="off"
						required />
				</div>
			</div>
			<div class="col-sm-3" style="padding-right: 25px;">
				<div class="form-group">
					<label>To Date</label> <input class="form-control" id="date1"
						name="date1" placeholder="YYYY-MM-DD" type="text"
						onkeypress="return restrictAlphabets(event)" autocomplete="off"
						required />
				</div>
			</div>
			<div class="col-sm-1"
				style="padding-right: 35px; margin-right: 10px;">
				<div class="form-group">
					<label>Work Type:</label><br> <select name="work_groups"
						id="work_groups" onkeypress="return restrictNumbers(event)"
						autocomplete="off" required>
						<option value="">-- Select --</option>
						<option value="Cleaner">Cleaner</option>
						<option value="Security">Security</option>
						<option value="Plumber">Plumber</option>
					</select>
				</div>
			</div>
			<br>
			<div class="col-sm-3" style="padding-right: 25px;">
				<div class="form-group">
					<input type="submit" name="view" value="View Attendance"
						class="btn btn-primary" />
				</div>
			</div>
		</form>
		<br>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr>
					<th>Staff Id</th>
					<th>Work</th>
					<th>Date</th>
					<th>Attendance</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usersList}" var="user">
					<tr>
						<td><c:out value="${user.staff_id}" /></td>
						<td><c:out value="${user.work}" /></td>
						<td><c:out value="${user.date}" /></td>
						<td><c:out value="${user.attendance}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- end for class "container" -->
</body>
</html>
