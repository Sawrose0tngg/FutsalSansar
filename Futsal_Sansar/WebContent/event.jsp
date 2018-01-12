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
<link rel="stylesheet" href="assets/css/Pretty-Header.css">
<link rel="stylesheet" href="assets/css/event.css">
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
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<%
				int i = 0;
			%>
			<c:forEach items="${ic}" var="slide">
				<c:if test="${slide.active=='1'}">
					<li data-target="#myCarousel" data-slide-to="${slide.id}"></li>
				</c:if>
			</c:forEach>
		</ol>
		<c:set var="count" value="1" />
		<div class="carousel-inner" role="listbox">
			<c:forEach items="${ic}" var="slide">
				<c:if test="${slide.active=='1'}">
					<div class="item <c:if test="${count==1}">active</c:if>">
						<img src="ImageSlide?id=${slide.id}" alt="${slide.title}"
							width="1200" height="700">
						<div class="carousel-caption">
							<h3>${slide.title}</h3>
							<p>${slide.description}</p>
						</div>
					</div>
					<c:set var="count" value="0" />
				</c:if>
			</c:forEach>
		</div>

		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<br>

	<div class="container-fluid">
		<div class="row content" id="memberInfo">
			<div class="col-sm-2 sidenav">
				<h4>
					<small>EVENTS</small>
				</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="" id="li1"><a id="showdiv1">Today</a></li>
					<li class="" id="li2"><a id="showdiv2">Tomorrow</a></li>
					<li class="" id="li3"><a id="showdiv3">Yesterday</a></li>
				</ul>
				<br>
			</div>

			<div class="col-sm-10" id="div1">
				<h4>
					<small>TODAY'S EVENTS</small>
				</h4>
				<hr>
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>Full Name</th>
							<th>Time</th>
							<th>Contact</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${today}" var="t">
							<tr>
								<td>${t.name}</td>
								<td>${t.time}</td>
								<td>${t.phone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-10" id="div2">
				<h4>
					<small>TOMORROW EVENTS</small>
				</h4>
				<hr>
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>Full Name</th>
							<th>Time</th>
							<th>Contact</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${tommorrow}" var="to">
							<tr>
								<td>${to.name}</td>
								<td>${to.time}</td>
								<td>${to.phone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-sm-10" id="div3">
				<h4>
					<small>YESTERDAY EVENTS</small>
				</h4>
				<hr>
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>Full Name</th>
							<th>Time</th>
							<th>Contact</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${yesterday}" var="y">
							<tr>
								<td>${y.name}</td>
								<td>${y.time}</td>
								<td>${y.phone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<hr>
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
	<div class="container-fluid text-center" id="memberInfo">
		<div class="row">
			<div class="col-sm-2">
				<h4>
					<small>TOURNAMENTS</small>
				</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="" id="event1"><a id="upevent">Upcoming</a></li>
					<li class="" id="event2"><a id="comevent">Completed</a></li>
				</ul>
			</div>
			<div class="col-sm-8" id="section1">
				<div class="row">
					<c:set var="flag" value="1" />
					<div class="col-sm-12">
						<c:forEach items="${ec}" var="event">
							<c:choose>
								<c:when test="${flag == 1}">
									<div class="w3-row-padding w3-padding-32 w3-container">
										<div class="w3-content">
											<div class="w3-quarter">
												<img src="EventImage?id=${event.id}" width="100%"
													height="300" onclick="onClick(this)" alt="${event.title }">
											</div>
											<div class="w3-twothird">
												<h1>
													<small>${event.title }</small>
												</h1>
												<span class="w3-text moreshow">${event.description}</span><br>
												<p>Date: ${event.startDate}-${event.endDate}</p>
												<p>Time: ${event.startTime}-${event.endTime}</p>
											</div>
										</div>
									</div>
									<c:set var="flag" value="0" />
								</c:when>
								<c:when test="${flag == 0 }">
									<div class="w3-row-padding w3-padding-32 w3-container">
										<div class="w3-content">
											<div class="w3-twothird">
												<h1>
													<small>${event.title }</small>
												</h1>
												<span class="w3-text moreshow">${event.description}</span><br>
												<p>Date: ${event.startDate}-${event.endDate}</p>
												<p>Time: ${event.startTime}-${event.endTime}</p>
											</div>
											<div class="w3-quarter">
												<img src="EventImage?id=${event.id}" width="100%"
													height="300" onclick="onClick(this)" alt="${event.title}">
											</div>
										</div>
									</div>
									<c:set var="flag" value="1" />
								</c:when>
							</c:choose>
						</c:forEach>
					</div>
				</div>
				<ul class="pagination">
					<c:forEach begin="1" end="${noOfPages}" var="i">
						<li class="" id="page${i}"><a href="LoginControl?id=${i}&link=event">${i}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-sm-8" id="section2">
				<div class="row">
					<c:set var="flag" value="1" />
					<div class="col-sm-12">
						<c:forEach items="${ce}" var="complete">
							<c:choose>
								<c:when test="${flag == 1}">
									<div class="w3-row-padding w3-padding-32 w3-container">
										<div class="w3-content">
											<div class="w3-quarter">
												<img src="EventImage?id=${complete.id}" width="100%"
													height="300" onclick="onClick(this)"
													alt="${complete.title }">
											</div>
											<div class="w3-twothird">
												<h1>
													<small>${complete.title }</small>
												</h1>
												<span class="w3-text moreshow">${complete.description}</span><br>
												<p>Date: ${complete.startDate}-${complete.endDate}</p>
												<p>Time: ${complete.startTime}-${complete.endTime}</p>
											</div>
										</div>
									</div>
									<c:set var="flag" value="0" />
								</c:when>
								<c:when test="${flag == 0 }">
									<div class="w3-row-padding w3-padding-32 w3-container">
										<div class="w3-content">
											<div class="w3-twothird">
												<h1>
													<small>${complete.title }</small>
												</h1>
												<span class="w3-text moreshow">${complete.description}</span><br>
												<p>Date: ${complete.startDate}-${complete.endDate}</p>
												<p>Time: ${complete.startTime}-${complete.endTime}</p>
											</div>
											<div class="w3-quarter">
												<img src="EventImage?id=${complete.id}" width="100%"
													height="300" onclick="onClick(this)"
													alt="${complete.title }">
											</div>
										</div>
									</div>
									<c:set var="flag" value="1" />
								</c:when>
							</c:choose>
						</c:forEach>
					</div>
				</div>
				<ul class="pagination">
					<c:forEach begin="1" end="${noOfCPages}" var="i">
						<li class="showAc" onclick="showActive()"><a
							href="LoginControl?idd=${i}&link=event">${i}</a></li>
					</c:forEach>
				</ul>
			</div>

			<div class="col-sm-2">
				<c:forEach items="${ad}" var="ad">
					<c:if test="${ad.place=='Event'}">
						<c:if test="${ad.active=='1'}">
							<div class="w3-row">
								Ads
								<div class="w3">
									<img src="Ad?id=${ad.id}&location=Event" style="width: 100%"
										onclick="onClick(this)" alt="${ad.title }">
									<div class="w3 w3-white" style="padding-top: 5px;">
										<p style="font-size: 12px;">
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
							<img src="EventRight?id=${right.id}" style="width: 100%"
								onclick="onClick(this)" alt="${right.title }">
							<div class="text-center" style="padding-top: 5px;">
								<p style="font-size: 12px; text-align: center;">
									<b>${right.title }</b>
								</p>
								<span style="font-size: 12px;" class="more">${right.url }</span>
							</div>
						</div>
						<br>
					</c:if>
				</c:forEach>
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
	<%@include file="assets/js/showImage.jsp"%>
	<%@include file="assets/js/show_More_Or_Less.jsp"%>
	<%@include file="assets/js/eventJS.jsp"%>
	<%@include file="assets/js/show_more_And_less.jsp"%>

</body>
</html>