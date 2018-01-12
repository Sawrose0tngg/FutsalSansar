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
<body>
	<%@ include file="header1.jsp"%>
	<%
		ArrayList<String> questionList = new ArrayList<>();
		questionList.add("What is the first name of the person you first kissed?");
		questionList.add("What is the last name of the teacher who gave you your first failing grade?");
		questionList.add("What was your first job?");
		questionList.add("What is your dream?");
		questionList.add("In what city or town does your nearest sibling live?");
		questionList.add("What is your pet name?");
	%>

	<div class="modal-content">
		<div class="modal-header" style="padding: 35px 50px;">
			<h4 class="text-center">
				<span class="glyphicon glyphicon-lock"></span> Forget Password?
			</h4>
		</div>
		<div class="modal-body" style="padding: 40px 50px;">
			<form action="MemberPassword" method="post">
				<div class="form-group">
					<label for="usrname"><span
						class="glyphicon glyphicon-envelope"></span> Email</label> <input
						type="email" class="form-control"
						placeholder="Enter email address" name="email" required>
				</div>
				<div class="form-group">
					<label><span class="glyphicon glyphicon-question"></span>
						Question</label> <select class="form-control" id="sel1" name="question">
						<%
							for (int i = 0; i < questionList.size(); i++) {
						%><option value="<%=questionList.get(i)%>"><%=questionList.get(i)%></option>
						<%
							}
						%>
					</select> <label><span class="glyphicon glyphicon-hand-right"></span>
						Answer</label> <input type="text" class="form-control"
						placeholder="Enter answer" name="answer" required>
				</div>
				<br>
				<button type="submit" class="btn btn-success btn-block">
					<span class="glyphicon glyphicon-off"></span> Submit
				</button>
			</form>
		</div>
	</div>

	<%@ include file="footer1.jsp"%>

</body>
</html>