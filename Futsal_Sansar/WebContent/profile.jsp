<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Futsal Sanar | Profile</title>
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
<style>
@media ( max-width :992px) {
	.row {
		margin-top: 11%;
	}
}

.tools i:link {
	color: red;
	cursor: pointer;
}

.tools i:visited {
	color: green;
	cursor: pointer;
}

.tools i:hover {
	color: hotpink;
	cursor: pointer;
}

.tools i:active {
	color: blue;
	cursor: pointer;
}
</style>
<script>
	$(document).ready(function() {
		$("#btnBook").click(function() {
			$("#modalBook").modal();
		});
	});
</script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<%@ include file="header.jsp"%>
	<div class="wrapper">
		<div class="content-wrapper">
			<section class="content">
			<div class="row"
				style="margin-top: 8%; margin-left: 1%; margin-right: 1%;">
				<div class="col-sm-3">
					<div class="box box-primary">
						<div class="box-body box-profile">
							<img class="profile-user-img img-responsive img-circle"
								src="MemberImage?id=${pc.get(0).id}"
								style="max-width: 80%; margin-left: 11%"
								alt="User profile picture">
							<h3 class="profile-username text-center">${pc.get(0).name}</h3>
							<p class="text-muted text-center">Futsal Member</p>
							<a href="#editPhoto" data-toggle="modal" class="btn btn-default"
								style="float: right;"><b><i class="fa fa-edit"> </i>
									Change Photo</b></a><br> <br> <a href="#newBook"
								data-toggle="modal"
								class="btn btn-primary pull-right btn-block btn-sm"> <span
								class="fa fa-pencil-square-o"></span> Book Now
							</a>
						</div>
					</div>
					<hr>
					<div class="box box-primary">
						<div class="box-body">
							<strong><i class="fa fa-book margin-r-5"></i> Member
								Type</strong>
							<c:forEach items="${memT}" var="mt">
								<p class="text-muted">${mt.memberType}<span class="tools"><a
										href="#editMember" data-toggle="modal">
											<button onclick="testing1();">
												<i class="fa fa-edit" style="float: right;"></i>
											</button>
									</a></span>
								</p>
								<input type="hidden" name="n1" value="${mt.id}" id="i1">
							</c:forEach>
							<%
								int count = 1;
							%>
							<c:forEach items="${mList}" var="memType">
								<%
									count++;
								%>
								<p class="text-muted">${memType.memberType}<span
										class="tools"><a href="#editMember" data-toggle="modal">
											<button onclick="testing<%=count%>();">
												<i class="fa fa-edit" style="float: right;"></i>
											</button>
									</a></span>
								</p>
								<input type="hidden" name="n<%=count%>" value="${memType.id}"
									id="i<%=count%>">
							</c:forEach>
							<hr>
							<strong><i class="fa fa-file-text-o margin-r-5"></i>
								Notice</strong>
							<p>${noticeText}</p>
						</div>
					</div>
				</div>
				<div class="col-md-9">
					<div class="nav-tabs-custom">
						<div class="tab-content">
							<div class="active tab-pane" id="activity">
								<div class="post">
									<div class="user-block">
										<span class="username"> <a>General Settings</a></span>
									</div>
									<form class="form-horizontal">
										<div class="form-group margin-bottom-none">
											<div class="col-sm-9">
												<label><span class="fa fa-user"></span> Full Name</label> <input
													type="text" class="form-control" value="${pc.get(0).name}"
													disabled>
											</div>
											<div class="col-sm-3">
												<label>&nbsp; </label> <a href="#editName"
													data-toggle="modal"
													class="btn btn-info pull-right btn-block btn-sm"> <span
													class="fa fa-pencil-square-o"></span> Edit
												</a>
											</div>
										</div>
										<div class="form-group margin-bottom-none">
											<div class="col-sm-9">
												<label><span class="fa fa-envelope"></span> Email</label> <input
													type="email" class="form-control"
													value="${pc.get(0).email}" disabled>
											</div>
											<div class="col-sm-3">
												<label>&nbsp; </label> <a href="#editEmail"
													data-toggle="modal"
													class="btn btn-info pull-right btn-block btn-sm"> <span
													class="fa fa-pencil-square-o"></span> Edit
												</a>
											</div>
										</div>
										<div class="form-group margin-bottom-none">
											<div class="col-sm-9">
												<label><span class="fa fa-phone-square"></span>
													Contact Number</label> <input type="number" class="form-control"
													value="${pc.get(0).phone}" disabled>
											</div>
											<div class="col-sm-3">
												<label>&nbsp; </label> <a href="#editNumber"
													data-toggle="modal"
													class="btn btn-info pull-right btn-block btn-sm"> <span
													class="fa fa-pencil-square-o"></span> Edit
												</a>
											</div>
										</div>
										<div class="form-group margin-bottom-none">
											<div class="col-sm-9">
												<label><span class="fa fa-mars"></span> Gender</label> <input
													type="text" class="form-control"
													value="${pc.get(0).gender}" disabled>
											</div>
											<div class="col-sm-3">
												<label>&nbsp; </label> <a href="#editGender"
													data-toggle="modal"
													class="btn btn-info pull-right btn-block btn-sm"> <span
													class="fa fa-pencil-square-o"></span> Edit
												</a>
											</div>
										</div>
									</form>
								</div>
								<div class="post clearfix">
									<div class="user-block">
										<span class="username"> <a href="#">Security
												Settings</a>
										</span>
									</div>
									<div class="form-group margin-bottom-none">
										<div class="col-sm-9">
											<label><span class="fa fa-question"></span> Security
												Question</label> <input type="text" class="form-control"
												value="${pc.get(0).question}" disabled>
										</div>
										<div class="col-sm-3">
											<label>&nbsp; </label> <a href="#editQuestion"
												data-toggle="modal"
												class="btn btn-info pull-right btn-block btn-sm"> <span
												class="fa fa-pencil-square-o"></span> Edit
											</a>
										</div>
									</div>
									<br> <br>
									<div class="form-group margin-bottom-none">
										<div class="col-sm-9">
											<label><span class="fa fa-lock"></span> Password</label> <input
												type="password" class="form-control" value="........."
												disabled>
										</div>
										<div class="col-sm-3">
											<label>&nbsp; </label> <a href="#editPassword"
												data-toggle="modal"
												class="btn btn-info pull-right btn-block btn-sm"> <span
												class="fa fa-pencil-square-o"></span> Edit
											</a>
										</div>
									</div>
								</div>
								<hr>
								<div class="col-md-6">
									<div class="box box-info">
										<div class="box-header with-border">
											<h3 class="box-title text-center">Member Book Status</h3>
										</div>
										<div class="box-body">
											<div class="table-responsive">
												<table class="table no-margin">
													<thead>
														<tr>
															<th>Join Date</th>
															<th>Time</th>
															<th>Paid</th>
															<th>Due</th>
															<th></th>
														</tr>
													</thead>
													<tbody>
														<%
															int cou = 0;
														%>
														<c:forEach items="${pc}" var="md">
															<tr>
																<%
																	cou++;
																%>
																<td>${md.date }</td>
																<td>${md.time }</td>
																<td>${md.pay }</td>
																<td>${md.totalcost }</td>
																<td><div class="tools">
																		<a href="#editTime" data-toggle="modal"><button
																				onclick="editMemberTime<%=cou%>();">
																				<i class="fa fa-edit"></i>
																			</button></a>&nbsp;&nbsp;&nbsp;&nbsp; <a
																			href="DeleteMember?id=${md.id}&action=Delete"
																			class="btn btn-danger"><i class="fa fa-trash-o"></i></a>
																	</div></td>
															</tr>
															<input type="hidden" value="${md.id}" id="mid<%=cou%>">
															<input type="hidden" value="${md.date}"
																id="mdate<%=cou%>">
															<input type="hidden" value="${md.memberType}"
																id="mtype<%=cou%>">
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="box box-info">
										<div class="box-header with-border">
											<h3 class="box-title text-center">General Book Status</h3>
										</div>
										<div class="box-body">
											<div class="table-responsive">
												<table class="table no-margin">
													<thead>
														<tr>
															<th>Date</th>
															<th>Time</th>
															<th>Paid</th>
															<th>Due</th>
															<th>Duration</th>
															<th></th>
														</tr>
													</thead>
													<tbody>
														<%
															int i = 0;
														%>
														<c:forEach items="${bc}" var="bd">
															<%
																i++;
															%>
															<tr>
																<td>${bd.date }</td>
																<td>${bd.time }</td>
																<td>${bd.pay }</td>
																<td>${bd.total }</td>
																<td>${bd.duration }Hrs</td>
																<td><div class="tools">
																		<a href="#editBTime" data-toggle="modal"><button
																				onclick="editBookTime<%=i%>();">
																				<i class="fa fa-edit"></i>
																			</button></a>&nbsp;&nbsp;&nbsp;&nbsp; <a
																			href="ChangeBook?id=${bd.id}&idd=${pc.get(0).id}&action=Delete"
																			class="btn btn-danger"><i class="fa fa-trash-o"></i></a>
																	</div></td>
															</tr>
															<input type="hidden" value="${bd.id}" id="bid<%=i%>">
															<input type="hidden" value="${bd.date}" id="bdate<%=i%>">
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
		</div>
		<br>
		<%@include file="footer.jsp"%>
		<%@include file="editMemberProfile.jsp"%>
		<div class="control-sidebar-bg"></div>
	</div>
	<div class="modal fade" id="editTime" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header text-center"
					style="padding: 35px 50px; background-color: #005139; color: #fff">
					<button type="button" class="close" data-dismiss="modal"
						style="color: #fff">&times;</button>
					<span class="fa fa-clock-o"></span>
					<h3>Change Time</h3>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form action="ChangeProfile?id=${pc.get(0).id}" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label><span class="fa fa-clock-o"></span> Time </label> <input
								type="time" class="form-control" name="time" required>
						</div>
						<input type="hidden" value="" name="date" id="date"> <input
							type="hidden" value="" id="temp" name="mid"> <input
							type="hidden" value="" id="dur" name="member">
						<button type="submit" class="btn btn-success btn-block">
							<span class="fa fa-check-circle"></span> Save Changes
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="editBTime" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header text-center"
					style="padding: 35px 50px; background-color: #005139; color: #fff">
					<button type="button" class="close" data-dismiss="modal"
						style="color: #fff">&times;</button>
					<span class="fa fa-clock-o"></span>
					<h3>Change Settings</h3>
				</div>
				<div class="modal-body" style="padding: 40px 50px;">
					<form action="ChangeBook" method="post">
						<div class="form-group">
							<label><span class="fa fa-clock-o"></span> Time </label> <input
								type="time" class="form-control" name="time" required>
						</div>
						<div class="form-group">
							<label><span class="fa fa-clock-o"></span> Duration </label> <input
								type="number" class="form-control" name="duration" required>
						</div>
						<input type="hidden" value="${pc.get(0).id}" name="memId">
						<input type="hidden" value="" name="bookId" id="bid"> <input
							type="hidden" value="" id="bdate" name="date">
						<button type="submit" class="btn btn-success btn-block">
							<span class="fa fa-check-circle"></span> Save Changes
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function checkPasswordMatch() {
			var password = $("#txtNewPassword").val();
			var confirmPassword = $("#txtConfirmPassword").val();

			if (password != confirmPassword)
				$("#printMessage").html("Passwords do not match!").css("color",
						"red").fadeIn(100);
			else
				$("#printMessage").html("Passwords match.").css("color",
						"green").delay(5000).fadeOut(800);
		}

		$(document).ready(function() {
			$("#txtConfirmPassword").keyup(checkPasswordMatch);
			var memberType = "";
			$("select.list").change(function() {
				memberType = $(".list option:selected").val();
				$("#amount").attr("value", "0")
				if (memberType == "Weekly") {
					$("#amount").attr("min", "3500");
				} else if (memberType == "Monthly") {
					$("#amount").attr("min", "15000");
				} else if (memberType == "Yearly") {
					$("#amount").attr("min", "100000");
				}
			});
			memberType = $(".list option:selected").val();
			if (memberType == "Weekly") {
				$("#amount").attr("min", "3500");
			}
		});
		function testing1(){
			$("#cc").attr("value",$("#i1").val());
		}
		function testing2(){
			$("#c").attr("value",$("#i2").val());
		}
		function testing3(){
			$("#c").attr("value",$("#i3").val());
		}
		function testing4(){
			$("#c").attr("value",$("#i4").val());
		}
		function testing5(){
			$("#c").attr("value",$("#i5").val());
		}
		function editMemberTime1(){
			$("#temp").attr("value",$("#mid1").val());
			$("#date").attr("value",$("#mdate1").val())
			$("#dur").attr("value",$("#mtype1").val())
		}
		function editMemberTime2(){
			$("#temp").attr("value",$("#mid2").val());
			$("#date").attr("value",$("#mdate2").val())
			$("#dur").attr("value",$("#mtype2").val())
		}
		function editBookTime1(){
			$("#bid").attr("value",$("#bid1").val());
			$("#bdate").attr("value",$("#bdate1").val());
		}
		function editBookTime2(){
			$("#bid").attr("value",$("#bid2").val());
			$("#bdate").attr("value",$("#bdate2").val());
			
		}
	</script>
</body>
</html>
