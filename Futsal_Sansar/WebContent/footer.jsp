<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Futsal Sansar</title>
<link rel="stylesheet" href="assets/css/Pretty-Footer.css">
</head>
<body>
	<footer>
	<div class="row" id="footer-content">
		<div class="col-md-4 col-sm-6 footer-navigation">
			<h3>
				<img src="assets/img/logo.png"><a
					href="LoginControl?link=home">Futsal<span> Sansar </span></a>
			</h3>
			<p class="links">
				<a href="LoginControl?link=home">Home</a><strong> · </strong><a
					href="LoginControl?link=about">About</a><strong> · </strong><a
					href="LoginControl?link=book">Book</a><strong> · </strong><a
					href="LoginControl?link=event">Event</a><strong> · </strong><a
					href="LoginControl?link=contact">Contact</a>
			</p>
		</div>
		<div class="col-md-4 col-sm-6 footer-contacts">
			<c:forEach items="${cc}" var="content">
				<c:if test="${content.active=='1'}">
					<p>
						<span class="${content.icon}"></span> ${content.description}
					</p>
				</c:if>
			</c:forEach>
		</div>
		<div class="col-md-4 col-sm-6 footer-about">
			<h4>About Futsal Sansar</h4>
			<p>Futsal Sansar well established online futsal booking.</p>
			<div class="social-links social-icons">
				<c:forEach items="${cw}" var="web">
					<c:if test="${web.active=='1'}">
						<a href="${web.description}"><i class="${web.icon}"></i></a>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	<p class="company-name">&copy; Futsal Sansar-2017</p>
	</footer>

</body>
</html>