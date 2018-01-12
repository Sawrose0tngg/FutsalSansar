<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Futsal Sansar</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Cookie">
<link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/signup.css">
<link rel="stylesheet" href="assets/css/Bootstrap-Payment-Form.css">
<link rel="stylesheet" href="assets/css/Hero-Technology.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="header1.jsp"%>

	<div class="modal-content">
		<div class="modal-header" style="padding: 35px 50px;">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-open"></span> Sign Up
			</h4>
		</div>
		<div class="modal-body" style="padding: 40px 50px;">
			<form role="form" action="Signup" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label><span class="glyphicon glyphicon-user"></span> Full
						Name</label> <input type="text" class="form-control" id="usrname"
						placeholder="Enter full name" name="name" required>
				</div>
				<div class="form-group">
					<label><span class="glyphicon glyphicon-envelope"></span>
						Email</label> <input type="text" class="form-control"
						placeholder="Enter email address" name="email" required>
				</div>
				<div class="form-group">
					<label><span class="glyphicon glyphicon-eye-open"></span>
						Password</label> <input type="password" class="form-control"
						placeholder="Enter password" name="password" id="txtNewPassword"
						required>
				</div>
				<div class="form-group">
					<label><span class="glyphicon glyphicon-eye-open"></span>
						Confirm Password</label> <input type="password" class="form-control"
						placeholder="Confirm password" name="cpassword"
						id="txtConfirmPassword" onChange="checkPasswordMatch();" required><span
						id="printMessage"></span>
				</div>
				<div class="form-group">
					<label><span class="glyphicon glyphicon-phone"></span>
						Contact Number</label> <input type="text" class="form-control"
						placeholder="Enter mobile number" name="contact" required>
				</div>
				<div class="form-group">
					<label>Security Question</label> <select class="form-control"
						id="sel1" name="question">
						<c:forEach items="${ql}" var="qList">
							<option value="${qList}">${qList}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label><span class="glyphicon glyphicon-hand-right"></span>
						Answer</label> <input type="text" class="form-control"
						placeholder="Enter answer" name="answer" required>
				</div>
				<div class="form-group">
					<label for="psw"><span class="glyphicon glyphicon-eye-open"></span>
						Gender</label> <label class="control-label"> <input type="radio"
						name="gender" value="Male" checked />Male
					</label>&nbsp; <label class="control-label"> <input type="radio"
						name="gender" value="Female" />Female
					</label>
				</div>
				<div class="form-group">
					<label>Member Type</label> <select class="form-control list"
						id="sel1" name="member">
						<c:forEach items="${ml}" var="mList">
							<option value="${mList}">${mList}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label><span class="glyphicon glyphicon-calendar"></span>
						Booking Date</label> <input type="date" class="form-control" min="${date}"
						name="date" required>
				</div>
				<div class="form-group">
					<label><span class="glyphicon glyphicon-time"></span>
						Booking Time</label> <input type="time" class="form-control" name="time"
						required>
				</div>
				<div class="form-group">
					<label>Upload Photo</label> <input type="file" name="image"
						required>
				</div>
				<br> <br> <a href="#modalPay" data-toggle="modal"
					class="btn btn-success btn-block"> <span
					class="glyphicon glyphicon-floppy-saved"></span> Sign up
				</a>
				<%@include file="esewamember.jsp"%>
			</form>
			<div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
					class="fa fa-facebook"></i> Sign in using Facebook</a> <a href="#"
					class="btn btn-block btn-social btn-google btn-flat"><i
					class="fa fa-google-plus"></i> Sign in using Google+</a>
			</div>
			<a href="#myModal" data-toggle="modal" class="text-center">I
				already have a membership</a>
		</div>
	</div>
	<%@include file="footer1.jsp"%>
	<script type="text/javascript">
		function checkPasswordMatch() {
			var password = $("#txtNewPassword").val();
			var confirmPassword = $("#txtConfirmPassword").val();

			if (password != confirmPassword)
				$("#printMessage").html("Passwords do not match!").css("color",
						"red").fadeIn(100);
			else
				$("#printMessage").html("Passwords match.").css("color",
						"green").delay(5000).fadeOut(800);
		}

		$(document).ready(function() {
			$("#txtConfirmPassword").keyup(checkPasswordMatch);
			var memberType = "";
			$("select.list").change(function() {
				memberType = $(".list option:selected").val();
				if (memberType == "Weekly") {
					$("#amount").attr("min", "3500");
				} else if (memberType == "Monthly") {
					$("#amount").attr("min", "15000");
				} else if (memberType == "Yearly") {
					$("#amount").attr("min", "100000");
				}
			});
			memberType = $(".list option:selected").val();
			if (memberType == "Weekly") {
				$("#amount").attr("min", "3500");
			}
		});
	</script>
</body>
</html>