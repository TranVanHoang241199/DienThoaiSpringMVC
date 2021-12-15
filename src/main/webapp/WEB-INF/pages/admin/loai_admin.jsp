<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_admin.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loai ADMIN</title>
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

.main {
	padding: 40px 0;
}

.main input, .main input::-webkit-input-placeholder {
	font-size: 11px;
	padding-top: 3px;
}

.main-center {
	margin-top: 30px;
	margin: 0 auto;
	max-width: 400px;
	padding: 10px 40px;
	background: #009edf;
	color: #FFF;
	text-shadow: none;
	-webkit-box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
	-moz-box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
	box-shadow: 0px 3px 5px 0px rgba(0, 0, 0, 0.31);
}

span.input-group-addon i {
	color: #009edf;
	font-size: 17px;
}
</style>
</head>
<body>
	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-7">
				<h2>Hãng sản xuất</h2>
				<p>${tbLoai}
				<hr>
				<ul class="nav nav-pills flex-column">
					<c:forEach items="${dsLoai}" var="h">
						<table class="table table-bordered">
							<tbody>
								<tr>
									<td><li class="nav-item"><p class="nav-link">
												${h.getMaLoai()}</p></li></td>
									<td><form class="d-flex" method="post" action="LoaiAdmin?sualoai=${h.getMaLoai()}">
											<input class="form-control me-2" type="text"
												placeholder="${h.getTenLoai()}" name="taydoiLoai">
											<button class="btn btn-primary" type="submit">sửa</button>
										</form></td>

									<td><form class="" method="post" action="LoaiAdmin?xoaloai=${h.getMaLoai()}">
											<button type="submit" class="btn btn-danger">xóa</button>
										</form></td>

								</tr>
							</tbody>
						</table>
					</c:forEach>
				</ul>

			</div>
			<div class="col-sm-5">
				<div class="main">
					<div class="main-center">
						<c:choose>
							<c:when test="${mls!=null}">
								<h5>Sửa loại sản phẩm mới.</h5>
							</c:when>
							<c:otherwise>
								<h5>Thêm loại sản phẩm mới.</h5>
							</c:otherwise>
						</c:choose>

						<form class="" method="post" action="LoaiAdmin">

							<div class="form-group">
								<label for="name">Mã hãng</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="namema" id="maloai"
										placeholder="Enter mã hãng" />
								</div>
							</div>

							<div class="form-group">
								<label for="email">Tên hãng</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="nameloai"
										placeholder="Enter Tên hãng" />
								</div>
							</div>
						<button type="submit">Thêm</button>
						</form>
					</div>
					<!--main-center"-->
				</div>
				<!--main-->

			</div>
		</div>
	</div>

	<!--container-->
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>
</body>
</html>