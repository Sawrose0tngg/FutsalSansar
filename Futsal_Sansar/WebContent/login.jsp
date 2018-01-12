<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Futsal Sansar</title>
<style>
.socialLink {
	margin-left: -330px;
}

#loginContent {
	margin-top: -49px;
}
</style>
</head>
<body>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="padding: 35px 50px;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4>
						<span class="glyphicon glyphicon-flash"></span> Login
					</h4>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form role="form" action="LoginControl" method="post">
						<div class="form-group">
							<label><span class="glyphicon glyphicon-user"></span>
								User Name</label> <input type="email" class="form-control" name="email"
								placeholder="Enter email">
						</div>
						<div class="form-group">
							<label><span class="glyphicon glyphicon-eye-open"></span>
								Password</label> <input type="password" class="form-control"
								name="password" placeholder="Enter password">
						</div>
						<button type="submit" class="btn btn-success btn-block">
							<span class="glyphicon glyphicon-send"></span> Login
						</button>
					</form>
				</div>
				<div class="modal-footer">
					<div class="socialLink">
						<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
							class="fa fa-facebook"></i> Sign up using Facebook</a> <a href="#"
							class="btn btn-block btn-social btn-google btn-flat"><i
							class="fa fa-google-plus"></i> Sign up using Google+</a>
					</div>
					<div id="loginContent">
						Not a member? <a href="../FutsalSansar/Signup">Sign Up</a><br>
						Forgot <a href="forget.jsp">Password?</a>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>