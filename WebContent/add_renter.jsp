<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Rental Members</title>

<script src="js/jquery-3.4.1.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#wing_id").change(function(){
			var wing_id = $("#wing_id").val();
			$.get('FlatServlet?req=1',{
				wing_id : wing_id
				}).done(function(data){
					var flat_no = "#flat_groups";
					$("#flat_groups").html("<option>---Select Flat Number--</option>");
					for ( var i in data){
						$(flat_no).append($("<option></option>").val(data[i]['flat_id']).html(data[i]['flat_no']));
						}
					});
			});
		});
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>

	<div class="container">
		<div class="row">
			<h3 style="color: Red;">Renter Registration Form</h3>
			<br>
			<marquee style="color: yellow;">Please fill the
				Registration Form carefully and re-check before final submission....</marquee>
			<br> <br>

			<form class="form-horizontal" method="POST" name="form"
				onsubmit="return validate()"
				action="${pageContext.request.contextPath}/RentalMemberServlet">

				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="fullname">Renter Name</label> <input type="text"
							name="renterName" class="form-control name" id="renterName"
							placeholder="Enter Renter Full Name"
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
							maxlength="10" minLength="10" required> <span
							style="color: red;" id="contact"></span>
					</div>
				</div>

				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label> Gender</label><br> <input type="radio" name="gender"
							value="Male" id="gender" required />Male<br> <input
							type="radio" name="gender" value="Female" id="gender" required />Female
					</div>
				</div>
				<br>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="dob">DOB</label> <input class="form-control" id="date"
							name="date" placeholder="YYYY-MM-DD" type="text"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							required />
					</div>
				</div>

				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="Aadhar number">Aadhar Number</label> <input
							type="text" name="aadhar" class="form-control" id="aadhar"
							placeholder="Enter Aadhar Number"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							maxlength="12" minlength="12" required> <span
							style="color: red;" id="aadhar"></span>
					</div>
				</div>

				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="email">Email ID</label> <input type="email"
							name="email" class="form-control" id="email"
							placeholder="Enter Valid Email Id" autocomplete="off" required>
					</div>
				</div>
				<br>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label for="on_rent_date">On Rent Date</label> <input
							class="form-control" id="date1" name="date1"
							placeholder="YYYY-MM-DD" type="text"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							required />
					</div>
				</div>

				<div class="col-sm-2" style="padding-right: 20px;">
					<div class="form-group">
						<label>Wings</label><br> <select name="wing_id" id="wing_id"
							required>
							<option>--Select Wing--</option>
							<c:forEach items="${wingsList}" var="wing">
								<option value="${wing.wing_id}">${wing.wing_name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br>
				<div class="col-sm-2" style="padding-right: 20px;">
					<div class="form-group">
						<label for="Flat number">Flat Number</label> <select
							name="flat_groups" id="flat_groups" required>
							<option>---Select Flat Number--</option>
						</select>
					</div>
				</div>

				<div class="col-sm-4" style="padding-right: 20px;">
					<div class="form-group">
						<label for="Maintenance Amount">Maintenance Amount</label> <input
							type="text" name="flat_maintenance" class="form-control"
							id="flat_maintenance" placeholder="Enter Maintenance Amount"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							required><span style="color: red;" id="flat_maintenance"></span>
					</div>
				</div>
				<br>
				<!-- 
				<div class="form-group">
					<input type="hidden" class="form-control" id="operation"
						name="operation" value="insert" />
				</div>
				-->
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
		var flat_no = document.form.flat_no.value;
		var flat_maintenance = document.form.flat_maintenance.value;
		var email = document.form.email.value;
		var filter = /^w+([.-]?w+)*@w+([.-]?w+)*(.w{2,3})+$/;
		var contact = document.form.contact.value;
		var aadhar = document.form.aadhar.value;

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
		if (flat_no == "" || isNaN(flat_no)) {
			alert("Enter Numeric Flat Number value...");
			flat_no.focus;
			return false;
		}
		if (flat_maintenance == "" || isNaN(flat_maintenance)) {
			alert("Enter Numeric Flat Maintenance value...");
			flat_maintenance.focus;
			return false;
		}
	}
</script>
</html>