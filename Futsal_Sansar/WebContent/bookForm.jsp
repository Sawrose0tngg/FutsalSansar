<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Futsal Sansar</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="modal fade" id="modalBook" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header text-center"
					style="padding: 35px 50px; background-color: #005139; color: #fff">
					<button type="button" class="close" data-dismiss="modal"
						style="color: #fff">&times;</button>
					<h4>
						<span class="glyphicon glyphicon-fire"></span> BOOK HERE
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" action="Payment?bid=1" method="post">
						<div class="form-group">
							<label for="usrname"><span
								class="glyphicon glyphicon-user"></span> Full Name</label> <input
								type="text" class="form-control" placeholder="Enter Name"
								name="name" required>
						</div>
						<div class="form-group">
							<label for="usrname"><span
								class="glyphicon glyphicon-envelope"></span> Email</label> <input
								type="email" class="form-control" placeholder="Enter Email"
								name="email" required>
						</div>
						<div class="form-group">
							<label for="psw"><span class="glyphicon glyphicon-phone"></span>
								Contact Number</label> <input type="number" class="form-control"
								id="phone" placeholder="Enter mobile number" name="phone"
								required>
						</div>
						<%
							Date now = new Date();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							String formattedDate = sdf.format(new Date());
						%>
						<div class="form-group">
							<label><span class="glyphicon glyphicon-calendar"></span>
								Booking Date</label> <input type="date" class="form-control"
								min="<%=formattedDate%>" name="date" required>
						</div>
						<div class="form-group">
							<label><span class="glyphicon glyphicon-time"></span>
								Booking Time</label> <input type="time" class="form-control" name="time"
								required>
						</div>
						<div class="form-group">
							<label>Book Duration:</label> <select class="form-control"
								id="sel1" name="duration">
								<option value="1">1 Hour</option>
								<option value="2">2 Hour</option>
								<option value="3">3 Hour</option>
								<option value="4">4 Hour</option>
								<option value="5">5 Hour</option>
								<option value="6">6 Hour</option>
								<option value="7">7 Hour</option>
								<option value="8">8 Hour</option>
								<option value="9">9 Hour</option>
								<option value="10">10 Hour</option>
								<option value="11">11 Hour</option>
								<option value="12">12 Hour</option>
							</select>
						</div>
						<a href="#modalPay" data-toggle="modal"
							class="btn btn-success btn-block"> <span
							class="glyphicon glyphicon-ok"></span> Payment
						</a>
						<div class="form-group text-right">
							For <a href="https://esewa.com.np/#/home">E-sewa</a> Rigister
							here!!!
						</div>
						<%@include file="esewa.jsp"%>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>