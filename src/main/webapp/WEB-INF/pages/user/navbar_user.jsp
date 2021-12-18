<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


		<!-- <div class="container-fluid">
				<a class="navbar-brand" href="#"> <img src="logo.png"
					alt="HDD mobibe" style="width: 40px;" class="rounded-pill">
				</a>
			</div> -->

		<a class="navbar-brand" href="#">HDD mobibe</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="Menu">Trang
						Chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="GioHang"> <c:choose>
							<c:when test="${gh.tongSachHC()!=null}">
								Giỏ
						Hàng<span class="badge">${gh.tongSachHC() }</span>
							</c:when>
							<c:otherwise>Giỏ
						Hàng</c:otherwise>
						</c:choose>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="DatMua">Thanh
						Toán</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown">Hãng</a>
					<ul class="dropdown-menu">
						<c:forEach items="${dsLoai}" var="h">
							<li><a class="dropdown-item"
								href="Menu?timl=${h.getMaLoai()}">${h.getTenLoai() }</a></li>
						</c:forEach>
					</ul></li>
				<c:choose>
					<c:when test="${tbdnkh!=null}">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown">${tbdnkh}</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="ThongTinKH">Thông tin khách
										hàng</a></li>
								<li><a class="dropdown-item" href="LichSuMuaHang">Lịch
										sử mua hàng</a></li>
								<li><a class="dropdown-item" href="Menu?dx=0">Đăng Xuất</a></li>
							</ul></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown">Tài Khoản</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="DangNhapAdmin">Đăng
										nhập admin</a></li>
								<li><a class="dropdown-item" href="DangNhap">Đăng nhập
										người dùng</a></li>
								<li><a class="dropdown-item" href="DangKy">Đăng ký tài
										khoản người dùng</a></li>
							</ul></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>

		<form class="d-flex" action="Menu">
			<input class="form-control me-2" type="text" placeholder="Search"
				name="timuser">
			<button class="btn btn-primary" type="button">Search</button>
		</form>
	</nav>
</body>
</html>