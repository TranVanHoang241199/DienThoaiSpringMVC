<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="QltphamAdmin"><ion-icon
				name="book-sharp"></ion-icon> Thực Phẩm</a>
	</nav>
	<form method="post" action="addbook?ml=${ml }"
		enctype="multipart/form-data"
		class="position-absolute top-50 start-50 translate-middle"
		style="width: 300px;">
		file: <input type="file" name="txtfile"> <input type="submit"><br>
	</form>

</body>
</html>