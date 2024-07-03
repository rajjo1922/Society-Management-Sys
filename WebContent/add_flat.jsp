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
					action="${pageContext.request.contextPath}/FlatServlet">


					<div class="col-sm-2" style="padding-right: 50px;">
						<div class="form-group">
							<select name="wing_groups" id="wing_groups" onkeypress="return restrictNumbers(event)" required>
								<option>--Select Wing--</option>
								<c:forEach items="${wingsList}" var="wing">
									<option value="${wing.wing_id}">${wing.wing_name}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div style="padding-bottom: 23px;">
						<div class="col-sm-4" style="padding-right: 30px;">
							<div class="form-group">
								<input type="text" name="flat_no" class="form-control"
									id="flat_no" placeholder="Enter Flat Number Ex.101" onkeypress="return restrictAlphabets(event)" autocomplete="off" minLength="3" maxLength="3" required>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<input type="submit" name="insert_flat" class=" btn btn-primary"
									id="insert_flat" value="Add Flat" />
							</div>
						</div>	
					</div>
				</form>
			</div>
<%-- 
				<div class="jumbotron" style="margin: 70px; background-color: gray;">
					<table class="table table-bordered table-striped table-hover">
						<thead style="background-color: white;">
							<tr>
								<th>Flat Id</th>
								<th>Wing Name</th>
								<th>Flat No</th>
							</tr>
						</thead>
						<tbody style="background-color: white;">
							<c:forEach items="${flatsList}" var="flat">
								<tr>
									<td><c:out value="${flat.flat_id}" /></td>
									<td><c:out value="${flat.wing_name}" /></td>
									<td><c:out value="${flat.flat_no}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>  --%>
		</div>
		<!-- end for class "row" -->
	</div>
	<!-- end for class "container" -->
</body>
</html>
