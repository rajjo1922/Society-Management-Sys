<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complaint Page</title>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="page-header">
		<h3 style="color: violet">Details of Complaint</h3>
	</div>
	<div class="container">
		<form class="form-horizontal" method="POST"
			onsubmit="return validate()" action="ComplaintServlet">

			<div class="col-sm-4" style="padding-right: 30px;">
				<div class="form-group">
					<label>Complaint Raised Name :</label> <input type="text"
						name="name" class="form-control" id="name" placeholder=""
						onkeypress="return restrictNumbers(event)" autocomplete="off"
						required>
				</div>
			</div>
			<div class="col-sm-4" style="padding-right: 25px;">
				<div class="form-group">
					<label>Wing :</label> <input type="text" name="wing"
						class="form-control" id="wing" placeholder=""
						onkeypress="return restrictNumbers(event)" autocomplete="off"
						required>

					<!-- 		<label>Wing:</label><br> <select name="wing" id="wing">
						<option value="">--Select--</option>
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
					</select> -->
				</div>
			</div>
			<div class="col-sm-4" style="padding-right: 25px;">
				<div class="form-group">
					<label for="Flat number">Flat Number :</label> <input type="text"
						name="flat_no" class="form-control" id="flat_no" placeholder=""
						onkeypress="return restrictAlphabets(event)" autocomplete="off"
						maxlength="3" minLength="3" required>
				</div>
			</div>
			<div class="col-sm-4" style="padding-right: 30px;">
				<div class="form-group">
					<label>Complaint Description :</label>
					<textarea class="form-control" id="c_desc" rows="4"
						name="description" id="description" autocomplete="off" required></textarea>
				</div>
			</div>
			<div class="col-sm-4" style="padding-right: 30px;">
				<div class="form-group">
					<label>Raised Date :</label><input class="form-control" id="date"
						name="date" placeholder="YYYY-MM-DD" type="text" 
						onkeypress="return restrictAlphabets(event)" autocomplete="off" required />
				</div>
			</div>
			<div class="col-md-4" style="padding-right: 25px;">
				<div class="form-group">
					<label for="status"> Status :</label> <br> <input type="radio"
						name="status" value="Unsolved" id="status" required />Unsolved<br>
					<input type="radio" name="status" value="Solved" id="status"
						required />Solved
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-8">
					<input type="submit" name="submit" class=" btn btn-primary"
						id="submit" value="Register Complaint" />
				</div>
			</div>
		</form>
		<div class="jumbotron">
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()" action="ComplaintServlet">

				<h3>All Complaints Details</h3>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Complaint raised name</th>
							<th>Wing</th>
							<th>Flat No</th>
							<th>Description</th>
							<th>Raised Date</th>
							<th>Status</th>
							<th>Change Status</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${complaints}" var="complaint">
							<tr>
								<td><c:out value="${complaint.person_name}" /></td>
								<td><c:out value="${complaint.wing}" /></td>
								<td><c:out value="${complaint.flat_no}" /></td>
								<td><c:out value="${complaint.description}" /></td>
								<td><c:out value="${complaint.raised_date}" /></td>
								<td><c:out value="${complaint.status}" /></td>
								<td><input type="checkbox" id="update_status_id"
									name="update_status_id" value="${complaint.complaint_id}"></td>
								<td><input type="checkbox" id="delete_id" name="delete_id"
									value="${complaint.complaint_id}"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input type="submit" name="update_status" class=" btn btn-primary"
					id="update_status" value="Update Status" /> <input type="submit"
					name="delete" class=" btn btn-primary" id="delete" value="Delete" />
			</form>
		</div>
	</div>
	<!-- end for class "container" -->
</body>
</html>