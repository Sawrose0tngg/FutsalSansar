<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Futsal Sansar</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Cookie">
<link rel="stylesheet" href="assets/css/forget.css">
<link rel="stylesheet" href="assets/css/Bootstrap-Payment-Form.css">
<link rel="stylesheet" href="assets/css/Hero-Technology.css">

</head>
<body onload="showDialog()">
	<%@ include file="header1.jsp"%>

	<%@ include file="footer1.jsp"%>

	<div class="modal fade" id="forgetModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header"
					style="padding: 35px 50px; background-color: #73AD21;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="text-center">
						<span class="glyphicon glyphicon-lock"></span> Change Password
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form action="../../FutsalSansar/ChangeMemberPassword"
						method="post">
						<div class="form-group">
							<label for="psw"><span
								class="glyphicon glyphicon-eye-open"></span> New Password</label> <input
								type="password" class="form-control" name="password"
								placeholder="Enter new password" required>
						</div>
						<div class="form-group">
							<label for="psw"><span
								class="glyphicon glyphicon-eye-open"></span> Confirm Password</label> <input
								type="password" class="form-control" name="cpassword"
								placeholder="Confirm password" required>
						</div>
						<input type="hidden" value="${email}" name="email">
						<button type="submit" class="btn btn-success btn-block">
							<span class="glyphicon glyphicon-off"></span> Save Password
						</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger btn-default pull-left"
						data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
				</div>
			</div>
		</div>
	</div>


	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script>
		function showDialog() {
			$("#forgetModal").modal();
		}
	</script>
</body>
</html>