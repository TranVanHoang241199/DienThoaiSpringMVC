<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_admin.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

			<div class="col-sm-5">
				<div class="main">
					<div class="main-center">
						<h2>Thêm điện thoại</h2>
						<br>
						<form class="" method="post" action="<c:url value="/addPhone" />"  enctype= "multipart/form-data">

							<div class="form-group">
								<label for="email">Tên Điện Thoại</label>
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="tendt"
										placeholder="Nhập tên" />
								</div>
							</div>
							<div class="form-group">
								<label for="name">Giá</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="giadt" id="name"
										placeholder="Nhập giá" />
								</div>
							</div>

							<div class="form-group">
								<label for="name">Số Lượng</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="soluongdt" id="name"
										placeholder="Nhập số lượng" />
								</div>
							</div>
							<div class="form-group">
								<label for="name">Mã Loại</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> 
										<select class="form-control" name="mldt" id="name">
										   <c:forEach var="item" items="${loaiList }">
										   		 <option value="${item.maLoai }">${item.tenLoai }</option>
										   </c:forEach>
										  </select>
								</div>
							</div>
							
							<input type="file" name="txtfile">
							
						<!-- 	<div class="form-group">
								<label for="usr">ẢNH:</label>
								<div class="custom-file">
									<input type="file" class="custom-file-input" name="txtfile">
									<label class="custom-file-label" for="customFile"
										id="customFile">Choose file</label>
								</div>
							</div> -->
							<br>
							<br>
							<br>
							<button type="submit">Thêm Điện Thoại</button>

						</form>
					</div>
					<!--main-center"-->
				</div>
				<!--main-->

			</div>
			<div class="col-sm-7">
				<h2>Điện Thoại</h2>
				<h5>${tbDT }</h5>
				<br>
				<div class="row">
					<br>
					<c:forEach items="${dsDT }" var="h">
						<div class="col-md-4"><a href="editDienThoai?maSP=${h.getMaDT()}">
							<br>
							<div class="card">
								<img class="card-img-top"
									src="<c:url value='/img/${h.getAnh()}'/>" alt="Card image">
								<div class="card-body">
									<h4 class="card-title">${h.getTenDT()}(${h.getMaDT()})</h4>

									<p class="card-text">$ ${h.getGia() }</p>
									<a href="AddThoaiAdmin?xoadt=${h.getMaDT()}"
										class="btn btn-danger">Xóa DT</a>
								</div>
							</div></a>
						</div>
						
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

	<!--container-->
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>
</body>
</html>