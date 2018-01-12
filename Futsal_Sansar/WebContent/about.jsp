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
<link rel="stylesheet" href="assets/css/Pretty-Header.css">
<link rel="stylesheet" href="assets/css/Pretty-Footer.css">
<link rel="stylesheet" href="assets/css/about.css">
<link rel="stylesheet" href="assets/css/common.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<%@include file="assets/css/show_more_and_less.jsp"%>
<style>
.about-left {
	padding-top: 30px;
}

#map {
	height: 300px;
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
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-2">
				<div class="about-left">
					<c:forEach items="${lc}" var="head">
						<c:if test="${head.active=='1'}">
							<h3>
								<small>${head.title }</small>
							</h3>
							<p>${head.url }</p>
							<hr>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="col-sm-7">
				<c:forEach items="${ac}" var="about">
					<c:if test="${about.active=='1'}">
						<h2>
							<small>${about.title}</small>
						</h2>
						<hr>
						<p>${about.description}</p>
						<hr>
					</c:if>
				</c:forEach>
			</div>
			<div class="col-sm-3">
				<c:forEach items="${ad}" var="ads">
					<c:if test="${ads.place=='About'}">
						<c:if test="${ads.active=='1'}">
							<div class="w3-row">
								Ads
								<div class="w3">
									<img src="Ad?id=${ads.id}&location=About"
										style="width: 100%; height: 120px;" onclick="onClick(this)"
										alt="${ads.title }">
									<div style="padding-top: 5px;" class="text-center">
										<p style="font-size: 12px;">
											<b>${ads.title }</b>
										</p>
										<span style="font-size: 12px;" class="more">${ads.description}</span>
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
							<img src="AboutRight?id=${right.id}"
								style="width: 100%; height: 200px;" onclick="onClick(this)"
								alt="${right.title }">
							<div style="padding-top: 5px;" class="text-center">
								<p style="font-size: 12px;">
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

	<div class="container-fluid text-center" id="main-body">
		<div class="row">
			<div class="col-md-8">
				<c:forEach items="${ic}" var="img">
					<c:if test="${img.active=='1'}">
						<h2>
							<small>${img.title}</small>
						</h2>
						<img src="AboutImage?id=${img.id}" class="img-responsive margin"
							style="width: 100%; height: 300px" alt="${img.title }"
							onclick="onClick(this)">
					</c:if>
				</c:forEach>
			</div>
			<div class="col-md-4">
				<h2>
					<small>Futsal Location</small>
				</h2>
				<div id="map"></div>
			</div>
		</div>
	</div>
	<br>
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
	<%@include file="assets/js/showImage.jsp"%>

	<%@include file="assets/js/map.jsp"%>
	<%@include file="assets/js/show_more_And_less.jsp"%>
</body>
</html>