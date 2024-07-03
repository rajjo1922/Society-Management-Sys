<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Maintenance Details</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="jumbotron" style="padding-bottom: 5%;">
			<table class="table table-bordered table-striped table-hover ">
				<thead>
					<tr>
						<th>Wing</th>
						<th>Flat No</th>
						<th>Paid Date</th>
						<th>Paid Maintenance</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="Total" value="${0}" />
					<c:forEach items="${maintenanceList}" var="m">
						<tr>
							<td><c:out value="${m.wing_name}" /></td>
							<td><c:out value="${m.flat_no}" /></td>
							<td><c:out value="${m.paid_date}" /></td>
							<td><c:out value="${m.paid_amount}" /></td>
							<c:set var="Total" value="${Total + m.paid_amount}" />
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="padding-left: 65%;">
				<label>Total Paid Maintenance Amount : ${Total} </label>
			</div>
		</div>
	</div>
	<!-- end for class "container" -->
</body>
</html>