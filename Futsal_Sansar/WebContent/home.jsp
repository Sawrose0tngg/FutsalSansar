<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Futsal Sansar</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Cookie">
<link rel="stylesheet" href="assets/css/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/Pretty-Header.css">
<link rel="stylesheet" href="assets/css/Pretty-Footer.css">
<link rel="stylesheet" href="assets/css/Hero-Technology.css">
<link rel="stylesheet" href="assets/css/home.css">
<link rel="stylesheet" href="assets/css/common.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<%@include file="assets/css/show_more_and_less.jsp"%>

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

	<div class="jumbotron hero" style="background: url('HomeBackground')">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-push-7 phone-preview">
					<div class="iphone-mockup">
						<img src="HomeFront" class="device" />
					</div>
				</div>
				<div class="col-md-6 col-md-pull-3 get-it">
					<c:forEach items="${hc}" var="head">
						<c:if test="${head.active=='1'}">
							<h1>${head.headName }</h1>
							<p>${head.headDes }</p>
						</c:if>
					</c:forEach>
					<p>
						<button type="button" class="btn btn-primary btn-lg" id="btnBook">
							<i class="fa fa-play"></i> BOOK NOW
						</button>
						<%
							if (request.getParameter("loc") == null) {
						%>
						<button type="button" class="btn btn-success btn-lg" id="btnJoin">
							<i class="fa fa-rocket"></i> JOIN TODAY
						</button>
						<%
							}
						%>

					</p>
				</div>
				<%@ include file="bookForm.jsp"%>
				<%@ include file="login.jsp"%>
			</div>
		</div>
		<div class="col-sm-2 social-icons">
			<c:forEach items="${cw}" var="web">
				<c:if test="${web.active=='1'}">
					<a href="${web.description}"><i class="${web.icon}"></i></a>
				</c:if>
			</c:forEach>
		</div>
	</div>

	<section class="testimonials"> <c:if
		test="${wc.get(0).active=='1'}">
		<h2 class="text-center">${wc.get(0).title}</h2>
		<blockquote>
			<p>${wc.get(0).description}</p>
			<footer>${wc.get(0).conclusion}</footer>
		</blockquote>
	</c:if> </section>
	<div id="tour" class="bg-1">
		<div class="container">
			<h3 class="text-center">BOARD MEMBER</h3>
			<div class="row text-center">
				<c:forEach items="${ac}" var="admin">
					<c:if test="${admin.active=='1'}">
						<div class="col-sm-4">
							<div class="thumbnail">
								<img src="ShowAdmin?id=${admin.id}" alt="${admin.title}"
									width="80%" style="height: 200px;">
								<p>
									<strong>${admin.title}</strong>
								</p>
								<span class="more">${admin.url}</span>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	<section class="features">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="row icon-features">
					<c:forEach items="${mc}" var="more">
						<c:if test="${more.active=='1'}">
							<div class="col-xs-4 icon-feature">
								<i class="${more.title}"></i>
								<p>${more.description}</p>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	</section>
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

	<script>
		$(document).ready(function() {
			$("#btnBook").click(function() {
				$("#modalBook").modal();
			});
			$("#btnJoin").click(function() {
				$("#myModal").modal();
			});
		});
	</script>
	<%@include file="assets/js/show_more_And_less.jsp"%>

</body>
</html>