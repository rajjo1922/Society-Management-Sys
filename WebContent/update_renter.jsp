<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Renter Information</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="row" id="teachfont">
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/RentalMemberServlet">
				<h3 style="color: Red;">Update Form of Renter Information</h3>
				<br>
				<div class="jumbotron" style="padding-bottom: 10%;">
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="fullname">Renter Name</label> <input type="text"
								name="renterName" class="form-control" id="renterName"
								placeholder="Enter Renter Full Name"
								onkeypress="return restrictNumbers(event)" autocomplete="off"
								value="${requestScope.rentalMemberBean.renter_name}" required>
						</div>
					</div>

					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="contact number">Contact Number</label> <input
								type="tel" name="contact" class="form-control" id="contact"
								placeholder="Enter Contact Number"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								maxlength="10" minLength="10"
								value="${requestScope.rentalMemberBean.mobile_no}" required>
						</div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label> Gender</label><br> <input type="radio" name="gender"
								value="Male"
								${requestScope.rentalMemberBean.gender eq 'Male' ? 'checked="checked"' : ''}
								id="gender" required />Male<br> <input type="radio"
								name="gender" value="Female"
								${requestScope.rentalMemberBean.gender eq 'Female' ? 'checked="checked"' : ''}
								id="gender" required />Female
						</div>
					</div>
					<br>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="dob">DOB</label> <input class="form-control"
								id="date" Name="date" placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								value="${requestScope.rentalMemberBean.dob}" required>
						</div>
					</div>

					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="Aadhar number">Aadhar Number</label> <input
								type="text" name="aadhar" class="form-control" id="aadhar"
								placeholder="Enter Aadhar Number"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								maxlength="12" minLength="12"
								value="${requestScope.rentalMemberBean.aadhar_no}" required>
						</div>
					</div>

					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="email">Email ID</label> <input type="email"
								name="email" class="form-control" id="email"
								placeholder="Enter Email Id"
								value="${requestScope.rentalMemberBean.email_id}" required>
						</div>
					</div>
					<br>

					<div class="col-sm-2" style="padding-right: 20px;">
						<div class="form-group">
							<label>Wing:</label> <input class="form-control" readonly
								value="${requestScope.rentalMemberBean.wing_name}" required>
						</div>
					</div>

					<div class="col-sm-2" style="padding-right: 20px;">
						<div class="form-group">
							<label for="Flat number">Flat Number</label> <input type="text"
								name="flat_no" class="form-control" id="flat_no"
								placeholder="Enter Flat Number" readonly
								value="${requestScope.rentalMemberBean.flat_no}" required>
						</div>
					</div>

					<div class="col-sm-2" style="padding-right: 20px;">
						<div class="form-group">
							<label for="on_rent_date">On Rent Date</label> <input
								class="form-control" id="date1" Name="date1"
								placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								value="${requestScope.rentalMemberBean.on_rent_date}" required>
						</div>
					</div>

					<div class="col-sm-2" style="padding-right: 20px;">
						<div class="form-group">
							<label for="Maintenance Amount">Maintenance Amount</label> <input
								type="text" name="flat_maintenance" class="form-control"
								id="flat_maintenance" placeholder="Enter Maintenance Amount"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								value="${requestScope.rentalMemberBean.flat_maintenance}"
								required>
						</div>
					</div>
					<br>
					<div class="form-group">
						<input type="hidden" name="renter_id" class="form-control"
							id="renter_id" value="${requestScope.rentalMemberBean.renter_id}"
							required>
					</div>
					<div style="padding-left: 410px;">
						<input type="submit" name="update" class="btn btn-primary"
							id="update" value="Update" /> <input type="submit" name="delete"
							class="btn btn-primary" id="delete" value="Delete" /> <input
							type="button" name="cancel" class="btn btn-primary" id="cancel"
							value="Cancel" onclick="location.href='admin_home.jsp';" />

					</div>
					<br>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label>Leave on</label> <input class="form-control" id="date2"
								Name="date2" placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off">
						</div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<br> <input type="submit" name="leave"
								class="btn btn-primary" id="leave" value="Leave Flat" />
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- end for class "row" -->
	</div>
	<!-- end for class "container" -->

	<script>
		$(document).ready(
				function() {
					var date_input1 = $('input[name="date2"]'); //our date input has the name "date"
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					var options = {
						format : 'yyyy-mm-dd',
						container : container,
						todayHighlight : true,
						autoclose : true,
					};
					date_input1.datepicker(options);
				})
	</script>
</body>
</html>