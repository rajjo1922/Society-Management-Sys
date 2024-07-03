<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Society Wings</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="row" id="teachfont">
			<h2><center>All Flat Details</center></h2>
			<div class="jumbotron" style="margin: 50px; background-color: gray;">
				<table class="table table-bordered table-striped table-hover">
					<thead style="background-color: white;">
						<tr>
							<th>Id</th>
							<th>Wing Name</th>
							<th>Flat No</th>
							<th>Owner Name</th>
							<th>Renter Name</th>
						</tr>
					</thead>
					<tbody style="background-color: white;">
						<c:forEach items="${flatsList}" var="flat">
							<tr>
								<td><c:out value="${flat.flat_id}" /></td>
								<td><c:out value="${flat.wing_name}" /></td>
								<td><c:out value="${flat.flat_no}" /></td>
								<c:choose>
									<c:when test="${flat.owner_name=='Available'}">
										<td><font color="Green"><b><c:out
														value="${flat.owner_name}" /></b></font></td>
									</c:when>
									<c:otherwise>
										<td><c:out value="${flat.owner_name}" /></td>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${flat.renter_name=='Available'}">
										<td><font color="Green"><b><c:out
														value="${flat.renter_name}" /></b></font></td>
									</c:when>
									<c:otherwise>
										<td><c:out value="${flat.renter_name}" /></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- end for class "row" -->
	</div>
	<!-- end for class "container" -->
</body>
</html>
