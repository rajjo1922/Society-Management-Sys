<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenses Details</title>

<script src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#wing_id").change(function() {
			var wing_id = $("#wing_id").val();
			$.get('FlatServlet?req=1', {
				wing_id : wing_id
				}).done(function(data) {
					var flat_no = "#flat_groups";
					$("#flat_groups").html("<option>---Select Flat Number--</option>");
					for ( var i in data) {
						$(flat_no).append($("<option></option>").val(data[i]['flat_id']).html(data[i]['flat_no']));
						}
					});
			});
		});
</script>
</head>
<body>
	<%@ include file="menu.jsp"%>
	<div class="page-header">
		<h3 style="color: violet">Details of Expenses</h3>
	</div>
	<div class="container">
		<div class="jumbotron">
			<form class="form-horizontal" method="POST"
				onsubmit="return validate()" action="ExpensesServlet">
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Purpose Of Expenses</label> <input type="text"
							name="purpose" class="form-control" id="purpose" placeholder=""
							onkeypress="return restrictNumbers(event)" autocomplete="off"
							required>
					</div>
				</div>
				<div class="col-sm-2" style="padding-right: 25px;">
					<div class="form-group">
						<label>Wings</label><br> <select name="wing_id" id="wing_id">
							<option>--Select Wing--</option>
							<c:forEach items="${wingsList}" var="wing">
								<option value="${wing.wing_id}">${wing.wing_name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-sm-2" style="padding-right: 25px;">
					<div class="form-group">
						<label>Flat Number</label><br> <select name="flat_groups"
							id="flat_groups">
							<option>---Select Flat Number--</option>
						</select>
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Done By </label> <input type="text" name="done_by"
							class="form-control" id="done_by" placeholder=""
							onkeypress="return restrictNumbers(event)" autocomplete="off"
							required>
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Client Name </label> <input type="text" name="client_name"
							class="form-control" id="client_name" placeholder=""
							onkeypress="return restrictNumbers(event)" autocomplete="off"
							required>
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Date</label> <input class="form-control" id="date"
							name="date" placeholder="YYYY-MM-DD" type="text"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							required />
					</div>
				</div>
				<div class="col-sm-4" style="padding-right: 25px;">
					<div class="form-group">
						<label>Expenses Amount</label> <input type="text"
							name="expense_amount" class="form-control" id="expense_amount"
							onkeypress="return restrictAlphabets(event)" autocomplete="off"
							placeholder="" required><span style="color: red;"
							id="numloc1"></span>
					</div>
				</div>
				<div class="form-group"></div>
				<br>
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-8">
						<input type="submit" name="submit" class="btn btn-primary"
							id="add_expenses" value="Add Expenses" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- end for class "container" -->
</body>
</html>