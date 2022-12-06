<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Dat lich</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Trang
					chủ</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>" class="nav-link">Đăng
						nhập thành công</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container text-center">
		<div class="row">
			<div class="col-md-6">
				<h1>Thông tin khách hàng</h1>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Mã: <c:out value="${khachhang.ma}" /></li>
					<li class="list-group-item">Họ và tên: <c:out
							value="${khachhang.ten}" /></li>
					<li class="list-group-item">Email: <c:out
							value="${khachhang.email}" /></li>
					<li class="list-group-item">Số điện thoại: <c:out
							value="${khachhang.sdt}" /></li>
					<li class="list-group-item">Địa chỉ: <c:out
							value="${khachhang.diachi}" /></li>
				</ul>
			</div>
			<div class="col-md-6">
				<h1>Thông tin lịch đặt</h1>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">SLot : <c:out value="${idslot}" /></li>
					<li class="list-group-item">Thời gian đặt : <c:out
							value="${time}" /></li>
					<li class="list-group-item"><c:out
							value="${listdv.substring(0, listdv.length() - 1)}" /></li>
				</ul>
			</div>
			<div class="col-md-12">
				<a href="<%=request.getContextPath()%>" class="btn btn-danger">Hủy</a> 
					<a href="luulichdat?<c:out value='${textget}' />"
					class="btn btn-success">Xác nhận</a>
			</div>
		</div>
	</div>
</body>
</html>
