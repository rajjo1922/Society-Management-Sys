<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Member Information</title>
</head>
<script type="text/javascript">
	function EnableDisable() {
		var yes = document.getElementById("yes");
		var no = document.getElementById("no");
		var maintenance_amt = document.getElementById("maintenance_amt");
		var maintenance = parseInt($('#maintenance').val());

		maintenance_amt.disabled = no.checked ? false : true;

		if (!maintenance_amt.disabled) {
			maintenance_amt.value = maintenance;
			maintenance_amt.focus();
		} else {
			maintenance_amt.value = 0;
			document.getElementById('no').checked = false;
		}
	}
</script>
<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="row" id="teachfont">
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/SocietyMemberServlet">
				<h3 style="color: Blue;">Update Form of Owner Information</h3>
				<div class="jumbotron" style="padding-bottom: 10%;">
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="fullname">Owner Name</label> <input type="text"
								name="ownerName" class="form-control name" id="ownerName"
								placeholder="Enter Owner Full Name"
								onkeypress="return restrictNumbers(event)" autocomplete="off"
								value="${requestScope.societyMemberBean.owner_name}" required>
						</div>
					</div>

					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="contact number">Contact Number</label> <input
								type="tel" name="contact" class="form-control" id="contact"
								placeholder="Enter Contact Number"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								maxlength="10" minLength="10"
								value="${requestScope.societyMemberBean.mobile_no}" required>
						</div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label> Gender</label><br> <input type="radio" name="gender"
								value="Male"
								${requestScope.societyMemberBean.gender eq 'Male' ? 'checked="checked"' : ''}
								id="gender" required />Male<br> <input type="radio"
								name="gender" value="Female"
								${requestScope.societyMemberBean.gender eq 'Female' ? 'checked="checked"' : ''}
								id="gender" required />Female
						</div>
					</div>
					<br>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="dob">DOB</label> <input class="form-control"
								id="date" Name="date" placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								value="${requestScope.societyMemberBean.dob}" required>
						</div>
					</div>

					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="Aadhar number">Aadhar Number</label> <input
								type="text" name="aadhar" class="form-control" id="aadhar"
								placeholder="Enter Aadhar Number"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								maxlength="12" minLength="12"
								value="${requestScope.societyMemberBean.aadhar_no}" required>
						</div>
					</div>

					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<label for="email">Email ID</label> <input type="email"
								name="email" class="form-control" id="email"
								placeholder="Enter Email Id"
								value="${requestScope.societyMemberBean.email_id}" required>
						</div>
					</div>
					<br>
					<div class="col-md-2" style="padding-right: 20px;">
						<div class="form-group">
							<label for="rented"> Rented</label><br> <input type="radio"
								name="rented" value="Yes" onclick="EnableDisable()"
								${requestScope.societyMemberBean.rental_status eq 'Yes' ? 'checked="checked"' : ''}
								id="yes" required />Yes<br> <input type="radio"
								name="rented" value="No" onclick="EnableDisable()"
								${requestScope.societyMemberBean.rental_status eq 'No' ? 'checked="checked"' : ''}
								id="no" required />No<br>
						</div>
					</div>

					<div class="col-sm-2" style="padding-right: 20px;">
						<div class="form-group">
							<label>Wing</label> <input class="form-control" readonly
								value="${requestScope.societyMemberBean.wing_name}" required>
						</div>
					</div>

					<%-- <div class="col-sm-2" style="padding-right: 20px;">
					<div class="form-group">
						<label>Wing:</label> <select name="wing_groups" id="wing_groups"
							style="width: 100%;" required>
							<option value="${requestScope.societyMemberBean.wing_name}">${requestScope.societyMemberBean.wing_name}</option>
						</select>
					</div>
				</div> --%>

					<div class="col-sm-2" style="padding-right: 20px;">
						<div class="form-group">
							<label for="Flat number">Flat Number</label> <input type="text"
								name="flat_no" class="form-control" id="flat_no"
								placeholder="Enter Flat Number" readonly
								value="${requestScope.societyMemberBean.flat_no}" required>
						</div>
					</div>

					<div class="col-sm-2" style="padding-right: 20px;">
						<div class="form-group">
							<label for="Maintenance Amount">Maintenance Amount</label> <input
								type="text" name="maintenance_amt" class="form-control"
								id="maintenance_amt" placeholder="Enter Maintenance Amount"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								value="${requestScope.societyMemberBean.flat_maintenance}"
								onclick="EnableDisable()" required> <input type="hidden"
								value="${requestScope.societyMemberBean.flat_maintenance}"
								id="maintenance">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="form-group">
							<label>Flat Buy Date</label> <input class="form-control"
								id="date1" name="date1" placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off"
								value="${requestScope.societyMemberBean.buy_date}" required />
						</div>
					</div>
					<br>
					<div class="form-group">
						<input type="hidden" name="member_id" class="form-control"
							id="member_id"
							value="${requestScope.societyMemberBean.member_id}" required>
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
							<label>Sold Date</label> <input class="form-control" id="date2"
								Name="date2" placeholder="YYYY-MM-DD" type="text"
								onkeypress="return restrictAlphabets(event)" autocomplete="off">
						</div>
					</div>
					<div class="col-sm-4" style="padding-right: 25px;">
						<div class="form-group">
							<br> <input type="submit" name="sold"
								class="btn btn-primary" id="sold" value="Sold Flat" />
						</div>
					</div>
				</div>
			</form>
		</div>
		<!-- end for class "row" -->
	</div>
	<!-- end for class "container" -->
</body>
</html>