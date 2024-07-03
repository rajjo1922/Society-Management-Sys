<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Staff Information</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="row" id="teachfont">
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/StaffMemberServlet">

				<h3 style="color: Red;">Update Form of Staff Information</h3>
				<br>
				<div class="jumbotron" style="padding-bottom: 10%;">
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="fullname">Staff Name</label> <input type="text"
								name="staffName" class="form-control" id="staffName"
								placeholder="Enter Staff Full Name"
								value="${requestScope.staffMemberBean.staff_name}"
								onkeypress="return restrictNumbers(event)" autocomplete="off"
								required>
						</div>
					</div>

					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="contact number">Contact Number</label> <input
								type="tel" name="contact" class="form-control" id="contact"
								placeholder="Enter Contact Number"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								maxlength="10" minLength="10"
								value="${requestScope.staffMemberBean.mobile_no}" required>
						</div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label> Gender</label><br> <input type="radio" name="gender"
								value="Male"
								${requestScope.staffMemberBean.gender eq 'Male' ? 'checked="checked"' : ''}
								id="gender" required />Male<br> <input type="radio"
								name="gender" value="Female"
								${requestScope.staffMemberBean.gender eq 'Female' ? 'checked="checked"' : ''}
								id="gender" required />Female
						</div>
					</div>
					<br>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="dob">DOB</label><br> <input class="form-control"
								id="date" name="date" placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								required value="${requestScope.staffMemberBean.dob}" />
						</div>
					</div>

					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="Aadhar number">Aadhar Number</label> <input
								type="text" name="aadhar" class="form-control" id="aadhar"
								placeholder="Enter Aadhar Number"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								maxlength="12" minLength="12"
								value="${requestScope.staffMemberBean.aadhar_no}" required>
						</div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group"></div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label>Work Type:</label> <br> <select name="work_groups"
								id="wrok_groups" required>
								<option value="">--Select--</option>
								<option value="Cleaner"
									${requestScope.staffMemberBean.work eq 'Cleaner' ? 'selected' : ''}>Cleaner</option>
								<option value="Security"
									${requestScope.staffMemberBean.work eq 'Security' ? 'selected' : ''}>Security</option>
								<option value="Plumber"
									${requestScope.staffMemberBean.work eq 'Plumber' ? 'selected' : ''}>Plumber</option>
							</select>
						</div>
					</div>
					<br>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="join_date">Joined Date</label> <input
								class="form-control" id="date1" name="date1"
								placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								value="${requestScope.staffMemberBean.join_date}" required />
							<!-- 
						<label for="join_date">Joined Date</label> <input
							class="form-control" id="join_date" Name="join_date"
							placeholder="Date" type="date"
							value="${requestScope.staffMemberBean.join_date}" required>
					-->
						</div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="Payment Amount">Payment Amount</label> <input
								type="text" name="payment_amount" class="form-control"
								id="payment_mount" placeholder="Enter Payment Amount"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								value="${requestScope.staffMemberBean.payment_amount}" required>
						</div>
					</div>
					<div class="form-group">
						<input type="hidden" name="staff_id" class="form-control"
							id="staff_id" value="${requestScope.staffMemberBean.staff_id}"
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
							<label>Leave Job on</label> <input class="form-control"
								id="date2" Name="date2" placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off">
						</div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<br> <input type="submit" name="leave"
								class="btn btn-primary" id="leave" value="Leave Job" />

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