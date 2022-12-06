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
				<a href="https://www.javaguides.net" class="navbar-brand">Trang chủ</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Đăng nhập thành công</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container text-center">
		<a href="/datlich/timslot" class="btn btn-primary">Đặt lịch</a>
	</div>
	<script type="text/javascript">
	
	var query = window.location.search.substring(1);console.log(query);
	if(query=='thanhcong'){
		alert('Đặt lịch thành công !');
	}
	</script>
</body>
</html>
