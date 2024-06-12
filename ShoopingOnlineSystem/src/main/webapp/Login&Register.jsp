<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title }</title>
<link rel = "stylesheet" href = "ModifyProduct.css">
<link rel = "stylesheet" href = "HomePage.css">
</head>
<body>
	<header>
		<div id = "menu_container">
			<a href = "homepage"><img src = "https://tainghe.com.vn/media/brand/soundpeats.png"></a>
			<form action = "search-product" method = "get">
			<input type = "text" placeholder="Search" name = "name" required>
			<button type = "submit">
			<i class = "search_icon"></i>
			</button>
			</form>
			<ul>
				<c:if test="${user.getId() > 0}">
					<c:set var="display"  value="none"></c:set>
					<li>${user.getUserName() }</li>
					<li><a href = "user-log-out">Log Out</a></li>
					<c:if test="${user.getRole() == 1}">
						<li style = "color: red">ADMIN</li>
					</c:if>
				</c:if>
				<li style = "display: ${display}"><a href = "user-login" >Login</a></li>
				<li style = "display: ${display}"><a href = "user-register">Register</a></li>
				<li><a href = "cart">Cart<i class = "cart_icon"></i></a></li>
				<li><a href = "">Messages<i class = "mess_icon"></i></a></li>
			</ul>
		</div>
	</header>

	<div id = "form">
		<h1>${title }</h1>
		<form action = "${action }?redirect=${redirect }" method = "post">
<!-- 		<label for = "id" >Nhap ID: </label> -->
		<input type = "hidden" name = "role" value = "${role }">
		<input type = "hidden" name = "idProduct" value = "${productId }">
		<label for = "user-name">User Name: </label>
		<input type = "text" id = "user-name" name = "nameUser" required>
		<label for = "pass-word">Password: </label>
		<input type = "password" id = "pass-word" name = "passwordUser" required>
		<button type = "submit">Submit</button>
		</form> 
	</div>
	
	
</body>
</html>