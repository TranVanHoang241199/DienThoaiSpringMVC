<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_admin.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ ADMIN</title>
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
	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">

				<h2>Hãng sản xuất</h2>
				<p>${tbLoai}</p>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link active" href="MenuAdmin">Tất
							cả</a></li>
					<c:forEach items="${dsLoaim}" var="h">
						<li class="nav-item"><a class="nav-link" href="MenuAdmin?mladm=${h.getMaLoai() }">${h.getTenLoai()}</a></li>
					</c:forEach>
					<li class="nav-item"><a class="nav-link disabled" href="#">--o0o--</a>
					</li>
				</ul>
				<hr class="d-sm-none">
				<h2>About Me</h2>
				<h5>Photo of me:</h5>
				<div class="fakeimg">Fake Image</div>
				<p>Some text about me in culpa qui officia deserunt mollit
					anim..</p>
			</div>
			<div class="col-sm-8">
				<h2>Điện Thoại</h2>
				<h5>${tbDT }</h5>
				<div class="row">
					<hr>
					<c:forEach var="h" items="${dsDT}">
						<div class="col-md-3">
							<br>
							<div class="card">
								<img class="card-img-top"
									src="<c:url value='/img/${h.getAnh()}'/>" alt="Card image">
								<div class="card-body">
									<h6 class="card-title">${h.getTenDT()}(${h.getMaDT()})</h6>

									<p class="card-text">$ ${h.getGia() }</p>
									<a href="MenuAdmin?xoadt=${h.getMaDT()}"
										class="btn btn-danger">Xóa DT</a>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>

</body>
</html>
