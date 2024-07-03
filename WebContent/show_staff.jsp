<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Staff Members</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="jumbotron">
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/StaffMemberServlet">


				<div class="col-sm-4" style="padding-right: 20px;">
					<div class="form-group">
						<label>Enter Staff Name :</label> <input type="text"
							name="staffName" id="staffName" placeholder="Ex. ABC"
							style="padding-right: 15px" class="form-control"
							onkeypress="return restrictNumbers(event)" autocomplete="off"
							required>
					</div>
				</div>
				<br> <input type="submit" name="show" class="btn btn-primary"
					id="Show" value="Show" /> <input type="button" name="cancel"
					class="btn btn-primary" id="cancel" value="Cancel"
					onclick="location.href='admin_home.jsp';" />
				<!-- 
			   <input type="text" name="staffName"
					id="staffName" placeholder="Staff Name" size="30"
					style="padding-right: 10px">
				<button type="Submit" name="search" class="btnbtn-primary">
					<span style="float: right;" class="glyphicon glyphicon-search"></span>
				</button>
				<div class="form-group">
					<input type="hidden" class="form-control" id="operation"
						name="operation" value="show" />
				</div>
				<div class="col-sm-4" style="padding-right: 20px;">
					<button type="Submit" name="cancel" class="btn btn-primary" a
						href="admin_home.jsp">Cancel</button>
				</div>
				-->
			</form>
		</div>
	</div>
	<!-- end for class "container" -->
</body>
</html>