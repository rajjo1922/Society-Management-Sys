<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenses Details</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="page-header">
		<h2 style="text-align: center">Expenses Details</h2>
	</div>
	<div class="container">
		<div class="jumbotron">
			<table class="table table-bordered table-striped">
				<thead style="text-align: center;">
					<tr>
						<th>Purpose</th>
						<th>Wing</th>
						<th>Flat No</th>
						<th>Done By</th>
						<th>Client Name</th>
						<th>Date</th>
						<th>Expenses Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="Total" value="${0}" />
					<c:forEach items="${expenses}" var="ex">
						<tr>
							<td><c:out value="${ex.purpose}" /></td>
							<td><c:out value="${ex.wing_name}" /></td>
							<td><c:out value="${ex.flat_no}" /></td>
							<td><c:out value="${ex.done_by}" /></td>
							<td><c:out value="${ex.client_name}" /></td>
							<td><c:out value="${ex.date}" /></td>
							<td><c:out value="${ex.expense_amount}" /></td>
							<c:set var="Total" value="${Total + ex.expense_amount}" />
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="padding-left: 78%;">
				<label>Total Expenses Amount : ${Total} </label>
			</div>
		</div>
	</div>
	<!-- end for class "container" -->
</body>
</html>