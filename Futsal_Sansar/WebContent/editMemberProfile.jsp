<div class="modal fade" id="editPhoto" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-picture-o"> Change Profile Photo</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="../FutsalSansar/ChangeProfile?id=${id }" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label><span class="fa fa-picture-o"></span> Select Image</label>
						<input type="file" class="form-control" name="image" required>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Save Changes
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="editName" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-user-circle-o"> Change Name</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="../FutsalSansar/ChangeProfile?id=${id }" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label><span class="fa fa-user"></span> Full Name </label> <input
							type="text" class="form-control" placeholder="Enter Name"
							name="name" required>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Save Changes
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="editEmail" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-envelope"> Change Email</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="../FutsalSansar/ChangeProfile?id=${id }" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label><span class="fa fa-envelope"></span> New Email-ID</label> <input
							type="email" class="form-control" placeholder="Enter Email"
							name="email" required>
					</div>
					<div class="form-group">
						<label><span class="fa fa-lock"></span> Current Password</label> <input
							type="password" class="form-control" placeholder="........"
							name="password" required>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Save Changes
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="editNumber" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-phone-square"> Change Contact Number</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="../FutsalSansar/ChangeProfile?id=${id }" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label><span class="fa fa-phone-square"></span> Contact
							Number </label> <input type="number" class="form-control"
							placeholder="New Phone Number" name="phone" required>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Save Changes
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="editGender" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-venus"> Change Gender</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="../FutsalSansar/ChangeProfile?id=${id }" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="psw"><span class="fa fa-mars"></span> Gender</label> <label
							class="control-label"> <input type="radio" name="gender"
							value="Male" checked />Male
						</label>&nbsp; <label class="control-label"> <input type="radio"
							name="gender" value="Female" />Female
						</label>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Save Changes
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="editQuestion" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-question"> Change Security Question</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="../FutsalSansar/ChangeProfile?id=${id }" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label><span class="fa fa-question"></span> Security
							Question</label> <select class="form-control" id="sel1" name="question">
							<c:forEach items="${question}" var="qList">
								<option value="${qList}">${qList}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label><span class="fa fa-mail-reply"></span> Answer</label> <input
							type="text" class="form-control" placeholder="Enter answer"
							name="answer" required>
					</div>
					<div class="form-group">
						<label><span class="fa fa-lock"></span> Current Password</label> <input
							type="password" class="form-control" placeholder="........"
							name="password" required>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Save Changes
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="editPassword" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-lock"> Change Password</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="../FutsalSansar/ChangeProfile?id=${id }" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label><span class="fa fa-lock"></span> New Password</label> <input
							type="password" class="form-control" placeholder="Enter Name"
							name="newpassword" id="txtNewPassword" required>
					</div>
					<div class="form-group">
						<label><span class="fa fa-lock"></span> Confirm Password</label> <input
							type="password" class="form-control" placeholder="........"
							name="cpassword" id="txtConfirmPassword"
							onChange="checkPasswordMatch();" required><span
							id="printMessage"></span>
					</div>
					<div class="form-group">
						<label><span class="fa fa-lock"></span> Current Password</label> <input
							type="password" class="form-control" placeholder="........"
							name="password" required>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Save Changes
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="editMember" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-user"> Change Member Type</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="../FutsalSansar/ChangeProfile?id=${id}" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label><span class="fa fa-user"></span> Member Type</label> <select
							class="form-control list" id="sel1" name="memberType">
							<c:forEach items="${member}" var="mList">
								<option value="${mList}">${mList}</option>
							</c:forEach>
						</select>
					</div>
					<h4>Payment</h4>
					<hr>
					<div class="form-group">
						<label><span class="glyphicon glyphicon-user"></span>
							E-sewa ID </label> <input type="text" class="form-control"
							placeholder="Email/Mobile Number" required>
					</div>
					<div class="form-group">
						<label for="psw"><span class="glyphicon glyphicon-lock"></span>
							Password</label> <input type="password" class="form-control" id="psw"
							placeholder="Enter password" required>
					</div>
					<div class="form-group">
						<label><span class="glyphicon glyphicon-usd"></span>
							Amount</label> <input type="number" class="form-control" id="amount"
							min="800" name="pay" required>
					</div>
					<input type="hidden" value="" id="c" name="idd">
					<input type="hidden" value="" id="cc" name="iddd">
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Save Changes
					</button>
				</form>
			</div>
			<div class="modal-footer">
				<h4 class=" text-left">Note:</h4>
				<p class=" text-center">Please Visit Futsal Sansar to refund
					your excess amount as quick as possible.</p>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="newBook" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<h4>
					<span class="fa fa-book"> Book Member</span>
				</h4>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form action="MemberBook?id=${id}" method="post">
					<div class="form-group">
						<label>Member Type</label> <select class="form-control mlist"
							id="sel1" name="member">
							<c:forEach items="${member}" var="mList">
								<option value="${mList}">${mList}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label><span class="glyphicon glyphicon-calendar"></span>
							Booking Date</label> <input type="date" class="form-control"
							min="${date}" name="date" required>
					</div>
					<div class="form-group">
						<label><span class="glyphicon glyphicon-time"></span>
							Booking Time</label> <input type="time" class="form-control" name="time"
							required>
					</div>
					<div class="form-group">
						<label><span class="glyphicon glyphicon-user"></span>
							E-sewa ID </label> <input type="text" class="form-control"
							placeholder="Email/Mobile Number" required>
					</div>
					<div class="form-group">
						<label for="psw"><span class="glyphicon glyphicon-lock"></span>
							Password</label> <input type="password" class="form-control" id="psw"
							placeholder="E-sewa password" required>
					</div>
					<div class="form-group">
						<label><span class="glyphicon glyphicon-usd"></span>
							Amount</label> <input type="number" class="form-control"
							placeholder="Minimum 800(Rs)" min="" name="pay" id="amt" required>
					</div>
					<button type="submit" class="btn btn-success btn-block">
						<span class="fa fa-check-circle"></span> Book
					</button>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		var mType = "";
		$("select.mlist").change(function() {
			mType = $(".mlist option:selected").val();
			$("#amt").attr("value", "0")
			if (mType == "Weekly") {
				$("#amt").attr("min", "3500");
			} else if (mType == "Monthly") {
				$("#amt").attr("min", "15000");
			} else if (mType == "Yearly") {
				$("#amt").attr("min", "100000");
			}
		});
		mType = $(".mlist option:selected").val();
		if (mType == "Weekly") {
			$("#amt").attr("min", "3500");
		}
	});
</script>