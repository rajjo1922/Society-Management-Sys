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
			<br>
			<div class="jumbotron"
				style="margin-right: 70px; margin-left: 70px; background-color: gray;">
				<form class="form-horizontal" method="POST"
					onsubmit="return validate()" name="form"
					action="${pageContext.request.contextPath}/WingServlet">

					<div style="padding-bottom: 23px;">
						<div class="col-sm-4" style="padding-right: 30px;">
							<div class="form-group">
								<input type="text" name="wing_name" class="form-control"
									id="wing_name" placeholder="Enter Wing Name  Ex. A"
									onkeypress="return restrictNumbers(event)" autocomplete="off"
									onkeyup="this.value = this.value.toUpperCase();" required>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<input type="submit" name="insert_wing" class=" btn btn-primary"
									id="insert_wing" value="Add Wing" />
							</div>
						</div>
					</div>
				</form>
			</div>

			<%-- <div class="jumbotron" style="margin: 70px; background-color: gray;">
				<table class="table table-bordered table-striped table-hover">
					<thead style="background-color: white;">
						<tr>
							<th>Wing Id</th>
							<th>Wing Name</th>
						</tr>
					</thead>
					<tbody style="background-color: white;">
						<c:forEach items="${wingsList}" var="wing">
							<tr>
								<td><c:out value="${wing.wing_id}" /></td>
								<td><c:out value="${wing.wing_name}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div> --%>
		</div>
		<!-- end for class "row" -->
	</div>
	<!-- end for class "container" -->
</body>

</html>