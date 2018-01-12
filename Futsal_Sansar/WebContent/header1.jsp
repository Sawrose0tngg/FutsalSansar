<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Futsal Sansar</title>
<link rel="icon" type="image/x-icon" href="/assets/img/title_logo.ico">
<link rel="stylesheet" href="assets/css/header.css">

</head>
<body>
	<%
		String activeHome = "", activeAbout = "", activeBook = "", activeEvent = "", activeContact = "",
				activeLogin = "";
		String getURL = request.getRequestURL().toString();
		if (getURL.contains("home")) {
			activeHome = "active";
		} else if (getURL.contains("about")) {
			activeAbout = "active";
		} else if (getURL.contains("book")) {
			activeBook = "active";
		} else if (getURL.contains("event")) {
			activeEvent = "active";
		} else if (getURL.contains("contact")) {
			activeContact = "active";
		}
	%>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="HomeSansar" class="navbar-brand navbar-link"><i
				class="fa fa-futbol-o"></i>Futsal Sansar</a>
			<button class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#navcol-1">
				<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
					class="icon-bar"></span><span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="<%=activeHome%>"><a href="HomeSansar"><i
						class="glyphicon glyphicon-home"></i> Home</a></li>
				<li class="<%=activeAbout%>"><a href="AboutSansar"><i
						class="glyphicon glyphicon-grain"></i> About Us</a></li>
				<li class="<%=activeBook%>"><a href="BookSansar"><i
						class="glyphicon glyphicon-fire"></i> Online Book</a></li>
				<li class="<%=activeEvent%>"><a href="EventSansar"><i
						class="glyphicon glyphicon-calendar"></i> Events</a></li>
				<li class="<%=activeContact%>"><a href="ContactSansar"><i
						class="glyphicon glyphicon-phone"></i> Contact</a></li>
				<li class="<%=activeLogin%>"><a href="#myModal"
					data-toggle="modal"><i class="glyphicon glyphicon-log-in"></i>Login
				</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<%@ include file="login.jsp"%>

</body>
</html>