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
		<form class="form-horizontal" method="POST"
			action="FlatMaintenanceServlet">
			<div class="jumbotron" style="padding-bottom: 5%;">
				<div class="col-sm-offset-5 col-sm-8">
					<div class="form-group">
						<input type="submit" name="add_monthly_maintenance"
							class="btn btn-primary" id="add_monthly_maintenance"
							value="Add Monthly Maintenance" />
					</div>
				</div>
			</div>
			<div class="jumbotron" style="padding-bottom: 5%;">
				<table class="table table-bordered table-striped table-hover ">
					<thead>
						<tr>
							<th>Wing</th>
							<th>Flat No</th>
							<th>Actual Maintenance</th>
							<th>Balance Maintenance</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${maintenanceList}" var="m">
							<tr>
								<td><c:out value="${m.wing_name}" /></td>
								<td><c:out value="${m.flat_no}" /></td>
								<td><c:out value="${m.maintenance}" /></td>
								<td><font color="blue"><b><c:out
												value="${m.balance_maintenance}" /></b></font></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</form>
	</div>
	<!-- end for class "container" -->
</body>
</html>