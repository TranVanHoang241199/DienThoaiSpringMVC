<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_admin.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông Số Kỹ Thuật</title>
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

	<c:choose>
		<c:when test="${Integer.parseInt(tsBean.getMaTS()) == 0}">
			<div style="align: center; margin: 50px 100px 0px 100px">
				<p class="lead">ĐẶT MUA ĐANG TRỐNG</p>
				<input type="button" value="Click Về Trang chủ."
					onclick="location.href='Menu'" class="btn btn-primary">
			</div>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${tbtcs!=null }">
					<script>
						alert("Cập nhật thành công.");
					</script>
				</c:when>
			</c:choose>
			<div class="container mt-3">
				<h1>Thông Số Kỹ Thuật</h1>
				<p>Bạn có thể xem và chỉnh sửa thông số kỹ thuật ở đây.</p>
				<p>
					* Vui lòng, cung cấp hoặc thây đổi đúng với thông tin cá nhân của
					mình, để có thể mua sắm một cách thuận tiện nhất.<br>Xin chân
					thành cảm ơn quý khách.
				</p>
				<hr>
				<form action="thongSoDT?msdt=${tbTS }" method="post">
					<div class="row">
						<div class="col-md-12">
							<input type="text" class="form-control" name="DT_maTS"
								id="DT_CSau" value="${tsBean.getMaTS() } --> chỉ xem"
								placeholder="${tsBean.getMaTS()} ">
						</div>

						<div class="col-md-12">
							<p class="bg-dark text-white">Mã thông số kỹ thuật</p>
							<input type="text" class="form-control" name="DT_mangHinh"
								id="DT_mangHinh" value="${tsBean.getMangHinh() }"
								placeholder="${tsBean.getMangHinh()} ">
						</div>

						<div class="col-md-12">
							<p class="bg-primary text-white">Màng hình</p>
							<input type="text" class="form-control" name="DT_CSau"
								id="DT_CSau" value="${tsBean.getCameraSau() }"
								placeholder="${tsBean.getCameraSau()} ">
						</div>

						<div class="col-md-12">
							<p class="bg-success text-white">Camera sau</p>
							<input type="text" class="form-control" name="DT_CTruoc"
								id="kh_diachi" value="${tsBean.getCameraTruoc() }"
								placeholder="${tsBean.getCameraTruoc() }">
						</div>
						<div class="col-md-12">
							<p class="bg-info text-white">Camera trước</p>
							<input type="text" class="form-control" name="DT_Cpu"
								value="${tsBean.getCpu() }" vid="kh_dc"
								placeholder="${tsBean.getCpu() }">
						</div>
						<div class="col-md-12">
							<p class="bg-warning text-white">Cpu</p>
							<input type="text" class="form-control" name="DT_HDH"
								value="${tsBean.getHeDieuHanh() }" vid="kh_dc"
								placeholder="${tsBean.getHeDieuHanh() }">
						</div>
						<div class="col-md-12">
							<p class="bg-danger text-white">Hệ điều hành</p>
							<input type="Text" class="form-control" name="DT_Ram"
								id="kh_email" value="${tsBean.getBoNhoRam() }"
								placeholder="${tsBean.getBoNhoRam() }">
						</div>
						<div class="col-md-12">
							<p class="bg-secondary text-white">Bộ Nhớ và ram</p>
							<input type="text" class="form-control" name="DT_Pin"
								id="kh_cmnd" value="${tsBean.getPin() }"
								placeholder="${tsBean.getPin() }">
						</div>

						<div class="col-md-12">
							<p class="bg-dark text-white">Pin</p>
							<input type="text" class="form-control" name="DT_KN" id="kh_ma"
								value="${tsBean.getKetNoi() }"
								placeholder="${tsBean.getKetNoi()} ">
						</div>

						<div class="col-md-12">
							<p class="bg-dark text-white">KetNoi</p>
							<input type="text" class="form-control" name="DT_maDT" id="kh_ma"
								value="${tbTS } --> chỉ xem" placeholder="${tbTS} ">
						</div>
						<div class="col-md-12">
							<p class="bg-light text-dark">Mã điện thoại</p>
						</div>
					</div>
					<br>
					<button class="btn btn-primary btn-lg btn-block" type="submit"
						name="btnDatHang">Cập Nhật</button>
				</form>
				<br>
				<p>* chú ý : Mã và mã điện thoại chỉ Được xem thông thể thây đổi
					được, có thể thây đổi tất cả các ô còn lại, cảm ơn quý khách.</p>
			</div>


		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>
</body>
</html>