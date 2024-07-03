<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Menu Page</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/bootstrap-iso.css" rel="stylesheet">
<link rel="stylesheet" href="css/styles.css">

<script src="js/jquery-3.4.1.min.js"></script>

<!--  jQuery 
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- 
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
-->

<script>
	$(document).ready(
			function() {
				var date_input = $('input[name="date"]'); //our date input has the name "date"
				var container = $('.bootstrap-iso form').length > 0 ? $(
						'.bootstrap-iso form').parent() : "body";
				var options = {
					format : 'yyyy-mm-dd',
					container : container,
					todayHighlight : true,
					autoclose : true,
				};
				date_input.datepicker(options);
			})

	$(document).ready(
			function() {
				var date_input1 = $('input[name="date1"]'); //our date input has the name "date"
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
<style type="text/css">
table, td, tr {
	text-align: center;
}

table th {
	text-align: center
}

.name {
	text-transform: capitalize;
}
</style>
</head>
<body class="Login" background="images\bg.jpg">

	<%
		session = request.getSession(false);
		if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
			out.println("Please login first");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
			//request.getRequestDispatcher("index.jsp").include(request, response);

			//	You are not logged in
			//	<br />
			//	<a href="index.jsp">Please Login</a>	
		}
	%>

	<br>
	<!-- Navigation bar -->
	<div class="navbar">
		<!-- Sub nav 1 -->
		<a href="admin_home.jsp">Home</a>

		<!-- Sub nav 2 -->
		<div class="dropdown">
			<button class="dropbtn" class="btn btn-primary" type="button"
				data-toggle="dropdown">
				Manage Flats Details <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="add_wing.jsp">Add Wings</a></li>
				<li><a
					href="<%=request.getContextPath()%>/WingServlet?request=1">Add
						Flats</a></li>
				<li><a
					href="<%=request.getContextPath()%>/WingServlet?request=4">View
						Flats</a></li>
			</ul>
		</div>

		<!-- Sub nav 3 -->
		<div class="dropdown">
			<button class="dropbtn" class="btn btn-primary" type="button"
				data-toggle="dropdown">
				Manage Society Members <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a
					href="<%=request.getContextPath()%>/WingServlet?request=2">Add
						Member</a></li>
				<li><a
					href="<%=request.getContextPath()%>/SocietyMemberServlet">View
						All Members</a></li>
				<li><a href="show_member.jsp">Update Member</a></li>
				<li><a
					href="<%=request.getContextPath()%>/PastMembersServlet?req=1">Past
						Members</a></li>
			</ul>
		</div>

		<!-- Sub nav 4 -->
		<div class="dropdown">
			<button class="dropbtn" class="btn btn-primary" type="button"
				data-toggle="dropdown">
				Manage Rental Members <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a
					href="<%=request.getContextPath()%>/WingServlet?request=3">Add
						Renter</a></li>
				<li><a href="<%=request.getContextPath()%>/RentalMemberServlet">View
						all Renter</a></li>
				<li><a href="show_renter.jsp">Update Renter</a></li>
				<li><a
					href="<%=request.getContextPath()%>/PastMembersServlet?req=2">Past
						Rental Members</a></li>
			</ul>
		</div>

		<!-- Sub nav 5 -->
		<div class="dropdown">
			<button class="dropbtn" class="btn btn-primary" type="button"
				data-toggle="dropdown">
				Manage Staff Members <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li class="dropdown-header" class="divider"><b>Staff
						Details</b><i class="glyphicon icon-right"></i></li>
				<li><a href="add_staff.jsp">Add staff</a></li>
				<li><a href="<%=request.getContextPath()%>/StaffMemberServlet">View
						All Staff</a></li>
				<li><a href="show_staff.jsp">Update staff</a></li>
				<li><a
					href="<%=request.getContextPath()%>/PastMembersServlet?req=3">Past
						Staff Members</a></li>
				<li class="dropdown-header" class="divider"><b>Staff
						Attendance</b><i class="glyphicon icon-right"></i></li>
				<li><a
					href="<%=request.getContextPath()%>/StaffAttendanceServlet">Mark
						Attendance</a></li>
				<li><a href="update_attendance.jsp">Update Attendance</a></li>
				<li><a href="view_attendance.jsp">View Attendance</a></li>
			</ul>
		</div>

		<!-- Sub nav 6 -->
		<div class="dropdown">
			<button class="dropbtn" class="btn btn-primary dropdown-toggle"
				type="button" data-toggle="dropdown" style="padding-right: 100px;">
				Manage Maintenance <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a
					href="<%=request.getContextPath()%>/WingServlet?request=6">Pay</a></li>
				<li><a
					href="<%=request.getContextPath()%>/FlatMaintenanceServlet">View</a></li>
				<li><a href="update_maintenance.jsp">Update</a></li>
			</ul>
		</div>

		<!-- Sub nav 7 -->
		<div class="dropdown">
			<button class="dropbtn" class="btn btn-primary dropdown-toggle"
				type="button" data-toggle="dropdown">
				Manage Expenses <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a
					href="<%=request.getContextPath()%>/WingServlet?request=5">Expenses</a></li>
				<li><a href="<%=request.getContextPath()%>/ExpensesServlet">Expenses
						Details</a></li>
			</ul>
		</div>

		<!-- Sub nav 8 -->
		<a href="<%=request.getContextPath()%>/ComplaintServlet">Manage Complaints</a>
		<!-- <a href="complaint_box.jsp">Complaints</a> -->

		<!-- Sub nav 9 -->
		<div class="dropdown">
			<button class="dropbtn" class="btn btn-primary" type="button"
				data-toggle="dropdown">
				Manage Reports <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a href="FlatWiseMemberReport.jsp">FlatWise Member
						Report</a></li>
				<li><a
					href="<%=request.getContextPath()%>/ReportServlet?request=MembersReport"
					target="blank_">Society Members Report </a></li>
			</ul>
		</div>


		<!-- Logout Button -->
		<a href="logout.jsp" class="btn btn-primary" role="button"
			style="float: right; margin-right: 25px;margin-top: -20px">Logout</a>
	</div>

	<!-- Include all compiled plugins (below), or include individual files as needed -->

	<!-- 	<script src="js/a.js"></script> -->
	<script src="js/bootstrap.min.js"></script>

	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/bootstrap-datepicker.min.js"></script>

</body>

<script>
	/*code: 48-57 Numbers
	  8  - Backspace,
	  35 - home key, 36 - End key
	  37-40: Arrow keys, 46 - Delete key*/

	function restrictAlphabets(e) {
		var x = e.which || e.keycode;
		if ((x >= 48 && x <= 57) || x == 8 || (x >= 35 && x <= 40) || x == 46)
			return true;
		else
			return false;
	}

	function restrictNumbers(e) {
		var x = e.which || e.keycode;
		if ((x >= 65 && x <= 122) || x == 32)
			return true;
		else
			return false;
	}
</script>

</html>