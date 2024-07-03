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
		<div class="jumbotron">
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/StaffAttendanceServlet">
				<!-- 
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Staff Name</label> <input type="text" name="staffName"
							class="form-control" id="staffName" title="Enter Staff Name"
							required>
					</div>
				</div>
-->
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Staff Id</label> <input type="text" name="staff_id"
							class="form-control" id="staff_id" title="Enter Staff Id"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							required>
					</div>
				</div>

				<div class="col-sm-3" style="padding-right: 25px;">
					<div class="form-group">
						<label>Date</label> <input class="form-control" id="date"
							name="date" placeholder="YYYY-MM-DD" type="text"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							required />
					</div>
				</div>

				<div class="col-sm-3" style="padding-right: 25px;">
					<div class="form-group">
						<br> <input type="checkbox" id="attendance" name="attendance"
							value="Present"> <label>Present</label><br> <input
							type="checkbox" id="attendance" name="attendance" value="Absent">
						<label>Absent</label>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-8">
						<input type="submit" name="update" value="Update"
							class="btn btn-primary" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- end for class "container" -->
</body>
</html>