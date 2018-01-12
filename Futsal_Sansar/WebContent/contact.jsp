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
<link rel="stylesheet" href="assets/css/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/Pretty-Footer.css">
<link rel="stylesheet" href="assets/css/Pretty-Header.css">
<link rel="stylesheet" href="assets/css/contact.css">
<link rel="stylesheet" href="assets/css/common.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<style>
#map {
	height: 500px;
	width: 100%;
}
</style>
</head>
<body>

	<%
		if (request.getParameter("loc") != null) {
	%>
	<%@include file="header.jsp"%>
	<%
		} else {
	%>
	<%@ include file="header1.jsp"%>
	<%
		}
	%>
	<div id="contact" class="container-fluid bg-grey">
		<h2 class="text-center">
			<small>CONTACT US</small>
		</h2>
		<div class="row">
			<div class="col-sm-5">
				<h5>
					<b>Contact us and we'll get back to you within 24 hours.</b>
				</h5>
				<c:forEach items="${cc}" var="content">
					<c:if test="${content.active=='1'}">
						<p>
							<span class="${content.icon}"></span> ${content.description}
						</p>
					</c:if>
				</c:forEach>
				<c:forEach items="${cw}" var="web">
					<c:if test="${web.active=='1'}">
						<p>
							<span class="${web.icon}"></span> <a href="${web.description}">${web.description}</a>
						</p>
					</c:if>
				</c:forEach>
			</div>
			<div class="col-sm-7 slideanim">
				<div class="row">
					<div class="col-sm-6 form-group">
						<input class="form-control" id="name" name="name"
							placeholder="Full Name" type="text" required>
					</div>
					<div class="col-sm-6 form-group">
						<input class="form-control" id="email" name="email"
							placeholder="Email" type="email" required>
					</div>
				</div>
				<textarea class="form-control" id="comments" name="comments"
					placeholder="Message" rows="5"></textarea>
				<br>
				<div class="row">
					<div class="col-sm-12 form-group">
						<button class="btn btn-default pull-right" type="submit">Send</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid bg-grey">
		<div class="row">
			<h2 class="text-center">
				<small style="color: #000">Find Us Now</small>
			</h2>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div id="map"></div>
			</div>
			<div class="col-md-1"></div>

		</div>
	</div>
	<%@include file="assets/js/map.jsp"%>

	<%
		if (request.getParameter("loc") != null) {
	%>
	<%@include file="footer.jsp"%>
	<%
		} else {
	%>
	<%@ include file="footer1.jsp"%>
	<%
		}
	%>


</body>
</html>