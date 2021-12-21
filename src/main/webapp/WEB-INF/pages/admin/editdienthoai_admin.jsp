<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar_admin.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chỉnh sửa loại món ăn</title>
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
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: white;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}
</style>
</head>
<body>
	<c:if test="${tB != null }">
		<script type="text/javascript">
			alert("Cập nhật thành công.")
		</script>
	</c:if>
	<form action="editDienThoai?maSP=${dtBean.getMaDT()}" method="post">
		<div class="container">
			<h1 style="text-align: center">Chỉnh sửa Diện thoại</h1>
			<hr>
			<hr>
			<label for="name"><b>Tên Điện thoại</b></label> <input type="text"
				name=tendt placeholder="Tên Điện Thoại"
				value="${dtBean.getTenDT()}" required> 
				<label
				for="address"><b>Giá</b></label> <input type="text"
				name="gia" placeholder="Giá"
				value="${dtBean.getGia()}" required>
				 <label
				for="name"><b>Số lượng</b></label> <input type="text"
				name="soLuong" placeholder="Số lượng"
				value="${dtBean.getSoLuong()}" required> 
				<label for="name"><b>Mã
					loại</b></label>
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user fa"
					aria-hidden="true"></i></span> <select class="form-control" name="mldt"
					id="name">
					<c:forEach var="item" items="${loaiList }">
						<option value="${item.maLoai }">${item.tenLoai }</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<input type="file" name="txtfile">
			<br>
			<br>
			<br> <input type="submit" class="registerbtn" value="Cập nhật"
				name="btnUpdateTypeFood">
		</div>
	</form>
	<br>
	<br>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Footer</p>
	</div>
</body>
</html>