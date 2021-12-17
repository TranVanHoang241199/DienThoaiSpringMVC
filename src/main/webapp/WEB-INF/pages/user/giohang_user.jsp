<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_user.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏi hàng</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
		<c:when test="${gh == null || dsGH.size()==0}">
			<div style="align: center; margin: 50px 100px 0px 100px">
				<p class="lead">GIỎ HÀNG ĐANG TRỐNG</p>
				<input type="button" value="Click Về Trang chủ."
					onclick="location.href='Menu'" class="btn btn-primary">
			</div>
		</c:when>
		<c:otherwise>

			<div class="container mt-4">
				<div id="thongbao" class="alert alert-danger d-none face"
					role="alert">
					Hiện tại bạn đã đang có ... sản phẩm trong giỏ hàng, với số tiền
					bạn phải cần có là .... để sở hữu chúng!
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>

				<h1 class="text-center">Giỏ hàng</h1>
				<br>
				<div class="row">
					<div class="col col-md-12">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>STT</th>
									<th>Ảnh đại diện</th>
									<th>Tên sản phẩm</th>
									<th>Số lượng</th>
									<th>Đơn giá</th>
									<th>Thành tiền</th>
									<th>Hành động</th>
								</tr>
							</thead>
							<tbody id="datarow">
								<c:forEach items="${dsGH }" var="i">
									<tr>
										<td>sl</td>
										<td class="text-center">
											<%-- <img
											src="<c:url value='/img/a1.jpg'/>"
											class="rounded mx-auto d-block" alt="..."> --%>
										</td>
										<td width="300">${i.getTenDT()}</td>
										<td class="text-right"><form
												action="GioHang?them=${i.getMaDT()}" method="post">
												<input type="number" min="1" value="${i.getSlMua()}"
													style="width: 50px" name="sl" required>
												<button type="submit" class="btn btn-primary">Update</button>
											</form>
										<td class="text-right">${i.getGia()}</td>
										<td class="text-right">${i.getThanhTien()}</td>
										<td>
											<!-- Nút xóa, bấm vào sẽ xóa thông tin dựa vào khóa chính `sp_ma` -->
											<a href="GioHang?xoa=${i.getMaDT()}"
											class="btn btn-danger btn-delete-sanpham"> <i
												class="fa fa-trash" aria-hidden="true"></i> Xóa
										</a>
										</td>
									</tr>
								</c:forEach>


							</tbody>
							<tbody id="datarow">
								<tr>
									<td>ssp</td>
									<td class="text-center">__${gh.tongSachHC()}__</td>
									<td class="text-center">tổng tiền</td>
									<td class="text-center">=</td>
									<td class="text-right">${gh.tongTien() }</td>
									<td class="text-center"><a href="DatMua"
										class="btn btn-primary btn-md"><i
											class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;Thanh
											toán</a></td>
									<td class="text-center"><a
										href="GioHang?xoaALL=<%="all"%>"
										class="btn btn-danger btn-delete-sanpham"> <i
											class="fa fa-trash" aria-hidden="true"></i> Xóa tất cả
									</a></td>
								</tr>

							</tbody>
						</table>
						<a href="Menu" class="btn btn-warning btn-md"><i
							class="fa fa-arrow-left" aria-hidden="true"></i>&nbsp;Quay về
							trang chủ</a>
					</div>
					<%-- <%} %> --%>
				</div>
			</div>
			<!-- End block content -->
			<!-- footer -->
			<footer class="footer mt-auto py-3">
				<div class="container">
					<span>Bản quyền © bởi <a href="https://nentang.vn">Nền
							Tảng</a> - <script>
								document.write(new Date().getFullYear());
							</script>.
					</span> <span class="text-muted">Hành trang tới Tương lai</span>

					<p class="float-right">
						<a href="Menu">Về đầu trang</a>
					</p>
				</div>
			</footer>


		</c:otherwise>
	</c:choose>

	<!-- end footer -->

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="../vendor/jquery/jquery.min.js"></script>
	<script src="../vendor/popperjs/popper.min.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Custom script - Các file js do mình tự viết -->
	<script src="../assets/js/app.js"></script>
</body>

<%-- <img src=<%=a.getAnh()%>
									class="rounded mx-auto d-block" alt="..."> --%>
</html>