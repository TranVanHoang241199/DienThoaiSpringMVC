<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_user.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông Tin Khách Hàng</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>

	<div class="container mt-3">
		<h1>Thông tin Khách Hàng</h1>
		<p>Khách hàng có thể xem và chỉnh sửa thông tin khách hàng ở đây.</p>
		<p>
			* Vui lòng, cung cấp hoặc thây đổi đúng với thông tin cá nhân của mình,
			để có thể mua sắm một cách thuận tiện nhất.<br>Xin chân thành
			cảm ơn quý khách.
		</p>
		<hr>
		<form action="" method="post">
			<div class="row">
				<div class="col-md-12">
					<input type="text" class="form-control" name="kh_ten" id="kh_ten"
						value="${khBean.getMaKH() }" placeholder="${khBean.getMaKH()} ">
				</div>
				
				<div class="col-md-12">
					<p class="bg-success text-white">Mã Khách Hàng</p>
					<input type="text" class="form-control" name="kh_diachi"
						id="kh_diachi" value="${khBean.getTenKH() }"
						placeholder="${khBean.getTenKH() }">
				</div>
				<div class="col-md-12">
					<p class="bg-info text-white">Tên khách Hàng</p>
					<input type="text" class="form-control" name="kh_dienthoai"
						value="${khBean.getSdt() }" vid="kh_dc"
						placeholder="${khBean.getSdt() }">
				</div>
				<div class="col-md-12">
					<p class="bg-warning text-white">Số Điện Thoại</p>
					<input type="text" class="form-control" name="kh_dienthoai"
						value="${khBean.getSdt() }" vid="kh_dc"
						placeholder="${khBean.getSdt() }">
				</div>
				<div class="col-md-12">
					<p class="bg-danger text-white">Địa Chỉ</p>
					<input type="email" class="form-control" name="kh_email"
						id="kh_email" value="${khBean.getDiaChi() }"
						placeholder="${khBean.getDiaChi() }">
				</div>
				<div class="col-md-12">
					<p class="bg-secondary text-white">Email</p>
					<input type="text" class="form-control" name="kh_cmnd" id="kh_cmnd"
						value="${khBean.getTenDN() }" placeholder="${khBean.getTenDN() }">
				</div>
				<div class="col-md-12">
					<p class="bg-dark text-white">Tên Đăng Nhập</p>
				</div>

			</div>
			<br>
			<button class="btn btn-primary btn-lg btn-block" type="submit"
				name="btnDatHang">Cập Nhật</button>
		</form>
		<br>
		<p>
			* chú ý : Mã Được xem thông thể thây đổi được, có thể thây đổi tất cả các ô còn lại, cảm ơn quý khách.
		</p>
	</div>
	
	<br>
	<br>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>
</body>
</html>