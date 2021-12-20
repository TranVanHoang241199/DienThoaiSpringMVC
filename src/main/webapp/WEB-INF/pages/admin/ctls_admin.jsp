<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_admin.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chi tiết lịch sử</title>
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
	<br>
	<br>
	<div class="container mt-3">
		<h1>${ctLSs.getTenKH()}--${ctLSs.getNgayMua() }</h1>
		<br> <br> <br>
		<h4>Thông tin của đơn hàng :</h4>

		<table class="table table-borderless">
			<thead>
				<tr>
					<th>Mã Đơn hàng</th>
					<th>Tên khách hàng</th>
					<th>Giá</th>
					<th>Ngày Mua</th>
					<th>Số Lượng</th>
					<th>Trạng Thái</th>
				</tr>
			</thead>
			<hr>
			<tbody>
				<tr>
					<td>${ctLSs.getMaLSMH()}</td>
					<td>${ctLSs.getTenKH()}</td>
					<td>$ ${ctLSs.getGia() }</td>
					<td>${ctLSs.getNgayMua() }</td>
					<td>${ctLSs.getSoLuong() }</td>
					<td><form class="d-flex" method="post"
							action="<c:url value="/ChiTietLichSuMuaHangAdmin?ctls=${ctLSs.getMaLSMH() }" />">
							
							 <select class="form-control me-2" name="status" id="name">
								<c:choose>
									<c:when test="${ctLSs.getTrangThai() == \"Đã thanh toán\" }">
										<option value="Đã thanh toán" selected="selected">Đã thanh toán</option>
										<option value="Chưa thanh toán">Chưa thanh toán</option>
									</c:when>
									<c:otherwise>
										<option value="Đã thanh toán" >Đã thanh toán</option>
										<option value="Chưa thanh toán" selected="selected">Chưa thanh toán</option>
									</c:otherwise>
								</c:choose>
							</select>
							<button class="btn btn-primary" type="submit">Cập Nhật</button>
						</form>
					</td>
				</tr>

			</tbody>
		</table>
		<br>
		<p class="lead">------------o0o------------</p>
		<!-- <input type="button" value="Về Trang lịch sử mua hàng."
			onclick="location.href='LichSuMuaHang'" class="btn btn-primary"> -->
	</div>
	</div>

</body>
</html>