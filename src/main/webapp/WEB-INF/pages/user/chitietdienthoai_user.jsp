<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_user.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-fluid p-5 bg-primary text-white text-center">
		<h1>${dtBean.getTenDT() }</h1>
		<p>sản phẩm hướng đến tương lai!</p>
	</div>

	<div class="container mt-5">
		<div class="row">

			<div class="col-sm-3">
				<h3>Sản phẩm</h3>
				<div class="row">
					<div class="card">
						<img class="card-img-top"
							src="<c:url value='/img/${dtBean.getAnh()}'/>" alt="Card image">
						<div class="card-body">
							<h4 class="card-title">${dtBean.getTenDT() }</h4>
							<p class="card-text">$ ${dtBean.getGia() }</p>
							<form method="post"
								action="ChiTietDT?ms=${dtBean.getMaDT()}&&ts=${dtBean.getTenDT()}&&ml=${dtBean.getMaLoai()}&&ah=${dtBean.getAnh()}&&gia=${dtBean.getGia()}">
								<button type="submit" class="btn btn-warning">Mua</button>
							</form>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-6">

				<div class="row">
					<h3>Thông Số kỹ thuật</h3>
					<p class="bg-dark text-white">Mã thông số kỹ thuật</p>
					<p>${tsBean.getMaTS() }</p>
					<p class="bg-primary text-white">Màng hình</p>
					<p>${tsBean.getMangHinh() }</p>
					<p class="bg-success text-white">Camera sau</p>
					<p>${tsBean.getCameraSau() }</p>
					<p class="bg-info text-white">Camera trước</p>
					<p>${tsBean.getCameraTruoc() }</p>
					<p class="bg-warning text-white">Cpu</p>
					<p>${tsBean.getCpu() }</p>
					<p class="bg-danger text-white">Hệ điều hành</p>
					<p>${tsBean.getHeDieuHanh() }</p>
					<p class="bg-secondary text-white">Bộ Nhớ và ram</p>
					<p>${tsBean.getBoNhoRam() }</p>
					<p class="bg-dark text-white">Pin</p>
					<p>${tsBean.getPin() }</p>
					<p class="bg-dark text-white">KetNoi</p>
					<p>${tsBean.getKetNoi() }</p>
					<p class="bg-light text-dark">Mã điện thoại</p>
					<p>${tsBean.getMaDT() }</p>
					<br>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
					<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
						laboris...</p>
				</div>

			</div>

			<div class="col-sm-3">
				<div class="row">
					<h3>Quà tặng khi mua</h3>
					<hr>
					<hr>
					<p>* Giảm giá 1,000,000đ (Không áp dụng kèm Thu cũ đổi mới và
						giảm giá qua quà tặng Galaxy)</p>
					<p>* Tặng gói bảo hành mở rộng Samsung Care+ trị giá 5,699,000đ
						Xem chi tiết</p>
					<p>* Giảm giá 7,000,000đ cho khách hàng đang sở hữu Z Fold,
						Fold2 5G chính hãng (Không áp dụng kèm Thu cũ Đổi mới và các
						khuyến mãi Giảm giá khác) Xem chi tiết</p>
					<p>* Giảm giá 4,000,000đ cho khách hàng đang sở hữu S10, S20,
						S21, Note10, Note20 series chính hãng (Không áp dụng kèm Thu cũ
						Đổi mới và các khuyến mãi Giảm giá khác) Xem chi tiết</p>
					<p></p>
					<p></p>
					<p></p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
					<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
						laboris...</p>
				</div>

			</div>
		</div>
</body>
</html>