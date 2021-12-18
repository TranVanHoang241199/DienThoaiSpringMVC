<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<a class="navbar-brand" href="#">HDD mobibe
			<h5>Edit</h5>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="MenuAdmin">Trang Chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="LoaiAdmin">hãng sản xuất</a></li>
				<li class="nav-item"><a class="nav-link" href="AddThoaiAdmin">Điện Thoại</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Khách hàng</a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="DangKy">Đăng Ký Tài Khoản Khách
								Hàng</a></li>
						<li><a class="dropdown-item" href="lichSuAdmin">kiểm tra lịch sử
								mua hàng</a></li>
						<li><a class="dropdown-item" href="TTKhachHang">Tim Kiếm khách
								hàng</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Tài Khoản</a>
					<ul class="dropdown-menu">
						
						<li><a class="dropdown-item" href="dangXuatadmin">Đăng Xuất</a></li>
					</ul></li>
			</ul>
		</div>

		<form class="d-flex" action="MenuAdmin">
			<input class="form-control me-2" type="text" placeholder="Thông Tin" name="timadmin">
			<button class="btn btn-primary" type="submit">Tìm</button>
		</form>
	</nav>
</body>
</html>