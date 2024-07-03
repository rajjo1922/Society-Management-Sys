<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Welcome Page</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<style>
.content {
	display: flex;
	justify-content: center;
	align-self: center;
	margin-top: 80px;
}

.modal-content {
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	background-color: rgba(6, 28, 150, 0.795);
	color: white;
	width: 40rem;
	border-radius: 10px;
	padding: 6em 3rem;
	box-shadow: 0px 0px 20px 0px black;
	border: 1px solid black;
}

.modal-title {
	font-size: 15px;
	margin-bottom: 2rem;
}

#username, #password {
	text-align: center;
	border: 2px solid cyan;
	margin: 1rem;
	color: white;
	background: transparent;
	padding: 1rem 2rem;
	border-radius: 3rem;
	width: 15rem;
	font-size: 1.2rem;
	outline: none;
	transition: all .2s ease-in-out;
}

#username:focus, #password:focus {
	width: 20rem;
	animation-name: colorChange;
	animation-duration: 10s;
	animation-iteration-count: infinite;
}

@
keyframes colorChange { 0% {
	border-color: green;
	color: green;
}
10%
{
border-color:yellow;
color:yellow;
}
20%
{
border-color:hotpink;
color:hotpink;
}
30%
{
border-color:red;
color:red;
}
40%
{
border-color:purple;
color:purple;
}
50%
{
border-color:yellow;
color:yellow;
}
60%
{
border-color:cyan;
color:cyan;
}
70%
{
border-color:skyblue;
color:skyblue;
}
80%
{
border-color:pink;
color:pink;
}
90%
{
border-color:red;
color:red;
}
100%
{
border-color:yellow;
color:yellow;
}
}
#reg_username, #reg_email, #reg_password {
	text-align: center;
	border: 2px solid cyan;
	margin: 1rem;
	color: white;
	background: transparent;
	padding: 1rem 2rem;
	border-radius: 3rem;
	width: 15rem;
	font-size: 1.2rem;
	outline: none;
	transition: all .2s ease-in-out;
}

#reg_username:focus, #reg_email:focus, #reg_password:focus {
	width: 20rem;
	animation-name: colorChange;
	animation-duration: 10s;
	animation-iteration-count: infinite;
}

@
keyframes colorChange { 0% {
	border-color: green;
	color: green;
}

10%
{
border-color:yellow;
color:yellow;
}
20%
{
border-color:hotpink;
color:hotpink;
}
30%
{
border-color:red;
color:red;
}
40%
{
border-color:purple;
color:purple;
}
50%
{
border-color:yellow;
color:yellow;
}
60%
{
border-color:cyan;
color:cyan;
}
70%
{
border-color:skyblue;
color:skyblue;
}80%
{
border-color:pink;
color:pink;
}90%
{
border-color: red;
color:red;
}
100%
{
border-color: yellow;
color: yellow;
}
}
.loginBtn {
	border: 2px solid green;
	padding: 1rem 3rem;
	border-radius: 6rem;
	text-decoration: underline;
	font-size: 1rem;
	color: black;
	cursor: pointer;
	transition: all .3s ease-in-out;
}

.loginBtn:hover {
	background: green;
	border: 2px solid green;
}

.img-fluid {
	margin-left: 100px;
	height: 280px;
	width: 850px;
	border-radius: 20px;
}

@media ( max-width : 650px) {
	.img-fluid {
		height: 280px;
		width: 400px;
	}
}

h2 {
	color: blue;
	font-size: 35px;
	font-weight: 800;
	text-align: center;
	margin-top: 35px;
	margin-bottom: 20px;
}

.image {
	height: 300px;
	margin-bottom: 10px;
	border-radius: 10px;
	margin-left: 30px;
}

.name {
	font-weight: 700;
	color: gold;
	text-align: center;
}

p {
	font-size: 22px;
	color: black;
	text-align: center;
}

.social-links {
	text-align: center;
	font-size: 25px;
	padding-top: 20px;
	margin-top: 50px;
	color: black:;
	font-size: 25px;
}

.pic {
	width: 950px;
	height: 400px;
	margin-left: 15%;
}

.social-links i {
	padding: 10px;
	border-radius: 5px;
	font-size: 50px;
	color: black;
	margin-left: 10px;
	margin-bottom: 10px;
	transition: 0.5s ease;
	cursor: pointer;
	color: black;
}

.social-links i:hover {
	background: #ffa500;
}

.map {
	self-align: center;
	margin-left: 30px;
}

h3 {
	font-size: 30px;
	font-weight: bold;
	color: gold;
	margin-bottom: 10px;
}

.credit {
	margin-top: 20px;
}
</style>
</head>
<body class="Login">
	<br>
	<div class="container">
		<h1 style="font-size: 3vw; color: blue; text-align: center;">
			<b>GangaKunj Society Application Management</b>
		</h1>
		<br>
		<div class="navbar navbar-dark bg-success col-md-12"
			style="margin-bottom: -50px;"></div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp"><span
						class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
				<li><a href="#about">About Us</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>

			<!--Login popup form-->

			<ul class="nav navbar-nav navbar-right">
				<li><a data-toggle="modal" data-target="#loginModal"
					style="padding-top: 16px; padding-right: 48px;"><span
						class="glyphicon glyphicon-log-in"></span> login</a></li>
				<li><a data-toggle="modal" data-target="#registerModal"
					style="padding-top: 16px;"><span
						class="glyphicon glyphicon-user"></span> Register</a></li>
			</ul>
		</div>
	</div>
	<br>
	<br>
	<br>
	<div>
		<img src="images/101.jpg" class="pic img-rounded" id="logo" alt="img">
	</div>

	<!--Modal-->
	<div class="modal fade" id="loginModal" role="dialog">
		<div class="modal-dialog z-depth-5">

			<!--Modal content-->

			<div class="modal-content">
				<div class="modal-header col-sm-6">
					<button type="button" class="close" data-dismiss="modal">x</button>
					<h4 class="modal-title">Login here</h4>
				</div>
				<div class="modal-body">

					<!--Creating login form-->
					<form class="form-horizontal" method="POST"
						onsubmit="return validate()" action="LoginServlet">
						<div class="form-group">
							<label class="control-label col-sm-3" for="username">Username:</label>
							<div class="col-sm-6">
								<input type="text" name="username"
									class="form-control transparent-input" id="username"
									placeholder="Enter your username" autocomplete="off">
							</div>
							<span class="col-sm-2 text-danger"
								style="margin-left: -17px; margin-top: -5px; font-size: 20px">*</span>
						</div>

						<div class="form-group">
							<label class="control-label col-sm-3" for="pwd">Password:</label>
							<div class="col-sm-6">
								<input type="Password" name="password"
									class="form-control transparent-input" id="password"
									placeholder="Enter your password" required>
							</div>
							<span class="col-sm-2 text-danger"
								style="margin-left: -17px; margin-top: -5px; font-size: 20px;">*</span>
							<!-- <div class="form-group">
								<input type="hidden" class="form-control" id="operation"
									name="operation" value="create" />
							</div> -->
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<button type="submit" class="loginBtn btn-primary-outline">Submit</button>
								<button type="submit" class="loginBtn btn-primary-outline"
									data-dismiss="modal">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>
	<!-- Registration Modal -->
	<div class="modal fade" id="registerModal" role="dialog">
		<div class="modal-dialog z-depth-5">
			<!-- Modal content -->
			<div class="modal-content"
				style="background-image: url(images/registerbg.jpg)">
				<div class="modal-header col-sm-6">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Register here</h4>
				</div>
				<div class="modal-body">
					<!-- Creating registration form -->
					<form class="form-horizontal" method="POST"
						onsubmit="return validateRegistration()"
						action="RegistrationServlet">
						<div class="form-group">
							<label class="control-label col-sm-4" for="username">Username:</label>
							<div class="col-sm-6">
								<input type="text" name="username"
									class="form-control transparent-input" id="reg_username"
									placeholder="Enter your username" autocomplete="off">
							</div>
							<span class="col-sm-2 text-danger"
								style="margin-left: -24px; margin-top: -5px; font-size: 20px">*</span>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="email">Email:</label>
							<div class="col-sm-6">
								<input type="email" name="email"
									class="form-control transparent-input" id="reg_email"
									placeholder="Enter your email" autocomplete="off">
							</div>
							<span class="col-sm-2 text-danger"
								style="margin-left: -24px; margin-top: -5px; font-size: 20px">*</span>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="password">Password:</label>
							<div class="col-sm-6">
								<input type="password" name="password"
									class="form-control transparent-input" id="reg_password"
									placeholder="Enter your password">
							</div>
							<span class="col-sm-2 text-danger"
								style="margin-left: -30px; margin-top: -5px; font-size: 20px">*</span>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-10">
								<button type="submit" class="loginBtn btn-primary-outline">Submit</button>
								<button type="button" class="loginBtn btn-primary-outline"
									data-dismiss="modal">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br>


	<div class="about" id="about">
		<a href="index.jsp">
			<h2>ABOUT US</h2>
		</a>
		<div class="col-md-6">
			<img src="./images/gangaPhoto1.jpg" class="image" alt="">
		</div>
		<div class="col-md-6">

			<h1 class="name">Society Application Management</h1>
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
				Repellendus placeat, vel laborum voluptates iste expedita,
				perspiciatis nemo, odio architecto aperiam quis blanditiis at ipsa
				laudantium eaque. Dolor necessitatibus quia cupiditate perferendis
				tempore sunt consequatur sint!</p>

		</div>
	</div>
	<br>
	<br>
	<br>
	<!-- Footer Start -->

	<div class="row col-md-12">
		<a href="index.jsp"><h2>Contact Us</h2></a>
		<div class="social-links col-md-5">
			<i class="bi bi-twitter"> Twitter </i> <br> <i
				class="bi bi-facebook"> Faceboot </i> <br> <i
				class="bi bi-instagram">Instagram</i> <br> <i
				class="bi bi-youtube">Youtube</i> <br> <i
				class="bi bi-pinterest">Pinterest</i>
		</div>

		<div class="map col-md-5">
			<h3 align="center">Map</h3>
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15131.362162526202!2d73.8341412!3d18.5361067!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bc2bf7ba4100001%3A0x2d93617adadd9f43!2sSymbiosis%20Center%20for%20Distance%20Learning%20(SCDL)!5e0!3m2!1sen!2sin!4v1713285703437!5m2!1sen!2sin"
				width="600" height="400" style="border: 0;" allowfullscreen=""
				loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
		</div>

		<br> <br>
		<div class="credit col-md-12">
			<p>
				Designed By <a href="#"><br>Rajeshwari, Ninad, Dipali,
					Devendra, Aniket</a>
			</p>

			<p>&copy;Copyright Rajeshwari, Ninad, Dipali, Devendra, Aniket
				All Rights Reserved</p>

		</div>
	</div>

	<!-- Footer End -->

	<%-- 
		String message = (String) request.getAttribute("alertMsg");
	%>
	<script type="text/javascript">
    var msg = "<%= message %> ";
		alert(msg);
	</script> --%>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/a.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>