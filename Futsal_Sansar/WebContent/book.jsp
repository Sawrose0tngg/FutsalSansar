<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Futsal Sansar</title>
<link rel="stylesheet" href="assets/css/w3.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Cookie">
<link rel="stylesheet" href="assets/css/fonts/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/Pretty-Footer.css">
<!-- <link rel="stylesheet" href="assets/css/Pretty-Header.css"> -->
<link rel="stylesheet" href="assets/css/book.css">
<link rel="stylesheet" href="assets/css/common.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<%@include file="assets/css/show_more_and_less.jsp"%>
<style>
img {
	margin-bottom: -6px;
	cursor: pointer
}

img:hover {
	opacity: 0.6;
	transition: 0.3s
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
	<div class="notice">
		<c:forEach items="${nc}" var="notice">
			<c:if test="${notice.active=='1'}">
				<h5>${notice.title }</h5>
			</c:if>
		</c:forEach>
	</div>
	<div class="container-fluid text-center">
		<div class="row content" id="memberInfo">

			<div class="col-sm-5 text-left sidenav">
				<c:forEach items="${bc}" var="content">
					<c:if test="${content.active=='1'}">
						<h2>
							<small>${content.title }</small>
						</h2>
						${content.titleDes }
						${content.bulletDes }
						-${content.conclueDes }
					</c:if>
					<hr>
				</c:forEach>
			</div>
			<div class="col-sm-5 text-left">
				<h2>
					<small>Member Booking</small>
				</h2>
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>Member Name</th>
							<th>Time</th>
							<th>Contact</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${mb}" var="mbook">
							<tr>
								<td>${mbook.name}</td>
								<td>${mbook.time}</td>
								<td>${mbook.phone }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<hr>
			</div>
			<div class="col-sm-2">
				<button type="button" class="btn btn-primary" id="btnBook">Book
					Now</button>
			</div>
			<%@include file="bookForm.jsp"%>
		</div>
	</div>
	<br>
	<div class="container-fluid">
		<div class="row content" id="bookInfo">
			<div class="col-sm-9">
				<h2>
					<small>Booking List</small>
				</h2>
				<hr>
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>Full Name</th>
							<th>Date</th>
							<th>Time</th>
							<th>Contact</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${book}" var="bok">
							<tr>
								<td>${bok.name}</td>
								<td>${bok.date}</td>
								<td>${bok.time}</td>
								<td>${bok.phone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br> <br>
			</div>
			<div class="col-sm-3">
				<c:forEach items="${ad}" var="ad">
					<c:if test="${ad.place=='Book'}">
						<c:if test="${ad.active=='1'}">
							<div class="w3-row">
								Ads
								<div class="w3">
									<img src="Ad?id=${ad.id}&location=Book" style="width: 100%"
										onclick="onClick(this)" alt="${ad.title }">
									<div class="text-center" style="padding-top: 5px;">
										<p style="font-size: 12px; text-align: center;">
											<b>${ad.title }</b>
										</p>
										<span style="font-size: 12px;" class="more">${ad.description}</span>
									</div>
								</div>
							</div>
						</c:if>
					</c:if>
				</c:forEach>
				<br>
				<c:forEach items="${rc}" var="right">
					<c:if test="${right.active=='1'}">
						<div class="w3">
							<img src="BookRight?id=${right.id }" style="width: 100%"
								onclick="onClick(this)" alt="${right.title }">
							<div class="text-center" style="padding-top: 5px;">
								<p style="font-size: 12px; text-align: center;">
									<b>${right.title }</b>
								</p>
								<span style="font-size: 12px;" class="more">${right.url }</span>
							</div>
						</div>
					</c:if>
				</c:forEach>
				<div id="modal01" class="w3-modal w3-black w3-padding-0"
					onclick="this.style.display='none'">
					<span
						class="w3-closebtn w3-text-white w3-opacity w3-hover-opacity-off w3-xxlarge w3-container w3-display-topright">×</span>
					<div
						class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
						<img id="img01" class="w3-image">
						<p id="caption"></p>
					</div>
				</div>
			</div>
		</div>
	</div>
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
		});
	</script>
	<%@include file="assets/js/showImage.jsp"%>
	<%@include file="assets/js/show_more_And_less.jsp"%>
</body>
</html>