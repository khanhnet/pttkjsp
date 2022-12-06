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
				<a href="https://www.javaguides.net" class="navbar-brand">Đặt lịch</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Quay lại</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container">
		<form action="" method="post" class="row">

			<fieldset class="form-group col-md-6">
				<label>Mã</label> <input type="number"
					value="<c:out value='${user.ma}' />" class="form-control"
					name="ma" required="required">
			</fieldset>

			<fieldset class="form-group col-md-6">
				<label>Tên</label> <input type="text"
					value="<c:out value='${user.ten}' />" class="form-control"
					name="ten" required="required">
			</fieldset>

			<fieldset class="form-group col-md-6">
				<label>Email</label> <input type="email"
					value="<c:out value='${user.email}' />" class="form-control"
					name="email" required="required">
			</fieldset>

			<fieldset class="form-group col-md-6">
				<label>Địa chỉ</label> <input type="text"
					value="<c:out value='${user.diachi}' />" class="form-control"
					name="diachi" required="required">
			</fieldset>
			<fieldset class="form-group col-md-6">
				<label>Số điện thoại</label> <input type="tel"
					value="<c:out value='${user.sdt}' />" class="form-control"
					name="sdt" required="required" pattern="[0]{1}[0-9]{9}">
					<small>Format: Bắt đầu từ 0, gồm 10 số</small>
			</fieldset>
			<div class="col-md-12">
			<button type="submit" class="btn btn-success" style="width: 72px;height: 38px;">Tìm</button>
			<button name="add" type="submit" class="btn btn-success" style="width: 72px;height: 38px;" value="new">Thêm</button>
			</div>
			
		</form>
	</div>


		<div class="container">

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã</th>
						<th>Tên</th>
						<th>Email</th>
						<th>Số điện thoại</th>
						<th>Địa chỉ</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.ma}" /></td>
							<td><c:out value="${user.ten}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.sdt}" /></td>
							<td><c:out value="${user.diachi}" /></td>
							<td><a href="xacnhan?idkhachhang=<c:out value='${user.ma}' />&<c:out value='${textgetkh}' />">Chọn</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
</body>
</html>
