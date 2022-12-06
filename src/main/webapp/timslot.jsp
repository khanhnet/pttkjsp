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
	<style>
	.btn-default{
	height:34px !important;
	}
	</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Đặt
					lịch</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Quay lại</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container">
		<form action="" method="get" class="row">

			<fieldset class="form-group col-md-6">
				<label>Chọn thời gian</label>
				<div class='input-group date' id='datetimepicker1'>
					<input name='time' type='text' class="form-control" required/> <span
						class="input-group-addon"> <span
						class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</fieldset>

			<fieldset class="form-group col-md-6">
				<label>Chọn dịch vụ</label> 
				<select name="dichvu" class="selectpicker col-md-12 form-control" multiple
					data-live-search="true" required>
					<c:forEach var="dichvu" items="${listDichvu}">

						<option value="${dichvu.ma}" >${dichvu.ten}</option>
					</c:forEach>
				</select>
			</fieldset>
			<div class="col-md-12">
				<button type="submit" class="btn btn-success"
					style="width: 72px; height: 38px;">Tìm</button>
			</div>

		</form>
	</div>


	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Mã</th>
					<th>Tên</th>

					<th></th>
				</tr>
			</thead>
			<tbody>
				<!--   for (Todo todo: todos) {  -->
				<c:forEach var="user" items="${listUser}">

					<tr>
						<td><c:out value="${user.ma}" /></td>
						<td><c:out value="${user.ten}" /></td>
						<td><a href="timkhachhang?idslot=<c:out value='${user.ten}' />&<c:out value='${textget}' />">Chọn</a></td>
					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>

		</table>
	</div>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.15.1/moment.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/js/bootstrap-datetimepicker.min.js"></script>

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.7.14/css/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker({format: 'Y-M-DD H:m:00',minDate: new Date()});
		});
		$('select').selectpicker();
	</script>
</body>
</html>
