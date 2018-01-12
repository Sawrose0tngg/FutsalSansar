<div class="modal fade" id="modalPay" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="padding: 35px 50px; background-color: #005139; color: #fff">
				<button type="button" class="close" data-dismiss="modal"
					style="color: #fff">&times;</button>
				<img alt="E-sewa" src="assets/img/esewa.png" width="100%"
					height="100px" />
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
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
					<label><span class="glyphicon glyphicon-usd"></span> Amount</label>
					<input type="number" class="form-control"
						placeholder="Minimum 800(Rs)" min="800" name="pay" required>
				</div>
				<button type="submit" class="btn btn-success btn-block">
					<span class="glyphicon glyphicon-book"></span> Book
				</button>
			</div>
		</div>
	</div>
</div>