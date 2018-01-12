<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Futsal Sansar</title>
<link rel="stylesheet" href="assets/css/Pretty-Header.css">

</head>
<body>
	<nav class="navbar navbar-default custom-header navbar-fixed-top"
		style="background: #4b4d4e;">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand navbar-link" href="LoginControl?link=home"><i
				class="fa fa-futbol-o"></i>Futsal<span> Sansar</span> </a>
			<button class="navbar-toggle collapsed" data-toggle="collapse"
				data-target="#navbar-collapse">
				<span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
					class="icon-bar"></span><span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav links">
				<li class="active"><a href="LoginControl?link=home"><i
						class="glyphicon glyphicon-home"></i> Home </a></li>
				<li><a href="LoginControl?link=about"><i
						class="glyphicon glyphicon-grain"></i> About Us</a></li>
				<li><a href="LoginControl?link=book"><i
						class="glyphicon glyphicon-fire"></i> Online Book</a></li>
				<li><a href="LoginControl?link=event"><i
						class="glyphicon glyphicon-calendar"></i> Events</a></li>
				<li><a href="LoginControl?link=contact"><i
						class="glyphicon glyphicon-phone"></i> Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right" style="margin-right: 0.1%;">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" aria-expanded="false" href="#"> <span
						class="caret"></span><img src="MemberImage?id=${id}"
						class="dropdown-image" /><span class="badge">${notice}</span></a>
					<ul class="dropdown-menu dropdown-menu-right" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-globe"></i>
								Notifications<sup
								style="color: #fff; background-color: #2A6A92; font-size: 12px">${notice }</sup></a></li>
						<li><a href="LoginControl?id=${id}&link=profile"><i
								class="glyphicon glyphicon-cog"></i> Change Setting</a></li>
						<li><a href="LoginControl?action=logout"><i
								class="glyphicon glyphicon-log-out"></i> Logout </a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	</nav>

</body>
</html>