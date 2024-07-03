<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark Staff Attendance</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<form class="form-horizontal" method="POST"
			onsubmit="return validate()"
			action="${pageContext.request.contextPath}/StaffAttendanceServlet">

			<div class="col-sm-4" style="padding-right: 25px;">
				<div class="form-group">
					<label>Mark Date</label> <input class="form-control" id="date"
						name="date" placeholder="YYYY-MM-DD" type="text"
						onkeypress="return restrictAlphabets(event)" autocomplete="off"
						required />
				</div>
			</div>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Staff Id</th>
						<th>Staff Name</th>
						<th>Work</th>
						<th>Attendance Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${attendance}" var="attend">
						<tr>
							<td><c:out value="${attend.staff_id}" /></td>
							<td><c:out value="${attend.staff_name}" /></td>
							<td><c:out value="${attend.work}" /></td>
							<td><input type="checkbox" id="attendance" name="attendance"
								value="${attend.staff_id}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="submit" name="save" value="Save" class="btn btn-primary" />
		</form>

	</div>
	<!-- end for class "container" -->
</body>
</html>