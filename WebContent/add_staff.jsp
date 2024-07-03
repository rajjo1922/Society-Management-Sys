<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Staff Members</title>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="row" id="teachfont">
			<h3 style="color: Blue;">Staff Registration Form</h3>
			<br>
			<marquee style="color: yellow;">Please fill the
				Registration Form carefully and re-check before final submission....</marquee>
			<br> <br>
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()" name="form"
				action="${pageContext.request.contextPath}/StaffMemberServlet">

				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="fullname">Staff Name</label> <input type="text"
							name="staffName" class="form-control name" id="staffName"
							onkeypress="return restrictNumbers(event)" autocomplete="off"
							placeholder="Enter Staff Full Name" required>
					</div>
				</div>

				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="contact number">Contact Number</label> <input
							type="tel" name="contact" class="form-control" id="contact"
							placeholder="Enter Contact Number"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							maxlength="10" minLength="10" required>
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label> Gender</label><br> <input type="radio" name="gender"
							value="Male" id="gender" required />Male<br> <input
							type="radio" name="gender" value="Female" id="gender" required />Female
					</div>
				</div>
				<br> <br>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="dob">DOB</label><br> <input class="form-control"
							id="date" name="date" placeholder="YYYY-MM-DD" type="text"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							required />
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="Aadhar number">Aadhar Number</label> <input
							type="text" name="aadhar" class="form-control" id="aadhar"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							maxlength="12" minLength="12" placeholder="Enter Aadhar Number">
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group"></div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Work Type:</label><br> <select name="work_groups"
							id="work_groups" onkeypress="return restrictNumbers(event)"
							autocomplete="off" required>
							<option value="">--Select--</option>
							<option value="Cleaner">Cleaner</option>
							<option value="Security">Security</option>
							<option value="Plumber">Plumber</option>
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
							required />
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="Payment Amount">Payment Amount</label> <input
							type="text" name="payment_amount" class="form-control"
							id="payment_amount" placeholder="Enter Payment Amount"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							required> <span style="color: red;" id="payment_amount"></span>
					</div>
				</div>
				<br>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-8">
						<input type="submit" name="insert" class=" btn btn-primary"
							id="insert" value="Register" />
					</div>
				</div>
			</form>
		</div>
		<!-- end for class "row" -->
	</div>
	<!-- end for class "container" -->
</body>
<script>
	function validate() {
		var staffName = document.form.staffName.value;
		var contact = document.form.contact.value;
		var aadhar = document.form.aadhar.value;
		var payment_amount = document.form.payment_amount.value;

		if (staffName == "") {
			document.getElementById("staffName").innerHTML = "Enter Staff Name...";
			return false;
		}
		if (contact == "" || isNaN(contact) || contact.length != 10) {
			alert("Please provide a 10 Digit Contact Number.");
			contact.focus;
			return false;
		}
		if (aadhar == "" || isNaN(aadhar) || aadhar.length != 12) {
			alert("Please provide a 12 Digit Aadhar Number.");
			aadhar.focus;
			return false;
		}
		if (payment_amount == "" || isNaN(payment_amount)) {
			document.getElementById("payment_amount").innerHTML = "Enter Numeric Payment Amount value...";
			return false;
		}
	}
</script>
</html>