<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Maintenance Details</title>

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

<script type="text/javascript">
/*
function get_maintenance() {
var flat_id = parseInt(document.getElementsByName("flat_groups")[0].value, 10) || 0;
$.get('FlatServlet?req=2',{
	flat_id : flat_id
	}).done(function(data){
		$("#monthly_maintenance").val(data[0].maintenance);
		$("#bal_maintenance").val(data[0].balance_maintenance);
		});
}
*/
	$(document).ready(function(){
		$("#flat_groups").change(function(){
			var flat_id = $("#flat_groups").val();
			$.get('FlatServlet?req=2',{
				flat_id : flat_id
				}).done(function(data){
					$("#monthly_maintenance").val(data[0].maintenance);
					$("#b_maintenance").val(data[0].balance_maintenance);
					$("#bal_maintenance").val(data[0].balance_maintenance);
					});
			});
		});
	

	function calculateBalance() {
		//var bal_maintenance = parseInt(document.getElementsByName("bal_maintenance")[0].value, 10) || 0;
		var b_maintenance = parseInt(document
				.getElementsByName("b_maintenance")[0].value, 10) || 0;
		var paid_amount = parseInt(
				document.getElementsByName("paid_amount")[0].value, 10) || 0;
		if (b_maintenance == 0)
			bal_maintenance.value = b_maintenance;
		else
			bal_maintenance.value = b_maintenance - paid_amount;
	}
</script>

</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="page-header">
		<h3 style="color: violet">Details of Maintenance</h3>
	</div>
	<div class="container">
		<form class="form-horizontal" method="POST"
			onsubmit="return validate()" action="FlatMaintenanceServlet">
			<div class="jumbotron" style="padding-bottom: 5%;">
				<div class="col-sm-4" style="padding-right: 20px;">
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
				<div class="col-sm-4" style="padding-right: 20px;">
					<div class="form-group">
						<label for="Flat number">Flat Number</label><br> <select
							name="flat_groups" id="flat_groups"
							onkeypress="return restrictAlphabets(event)"
							onchange="get_maintenance()" required>
							<option>---Select Flat Number--</option>
						</select>
					</div>
				</div>

				<div class="col-sm-4" style="padding-right: 20px;">
					<div class="form-group">
						<label>Monthly Maintenance Amount</label> <input type="text"
							name="monthly_maintenance" class="form-control"
							id="monthly_maintenance" required>
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 20px;">
					<div class="form-group">
						<label>Paid Amount</label> <input type="text" name="paid_amount"
							class="form-control" id="paid_amount"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							onchange="calculateBalance()" required>
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 20px;">
					<div class="form-group">
						<label>Balance Maintenance Amount</label> <input type="text"
							name="bal_maintenance" class="form-control" id="bal_maintenance"
							placeholder="" required> <input type="hidden"
							id="b_maintenance" name="b_maintenance">
					</div>
				</div>

				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Date</label> <input class="form-control" id="date"
							name="date" placeholder="YYYY-MM-DD" type="text" required />
					</div>
				</div>
				<div class="form-group"></div>
				<br>
				<div class="col-sm-offset-5 col-sm-8">
					<div class="form-group">
						<input type="submit" name="pay_maintenance"
							class="btn btn-primary" id="pay_maintenance"
							value="Pay Maintenance"
							onkeypress="return restrictNumbers(event)" autocomplete="off" />
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- end for class "container" -->
</body>
</html>