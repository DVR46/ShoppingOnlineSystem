<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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

	 <section id = "body_page">
	 	<aside id ="left_side">
	 	
	 	</aside>
	 	
	 	<content>
	 		<div id = "product_type">
	 		<h1>Product Type</h1>
	 			<div id = "products">
	 				<c:forEach items = "${products}" var = "products">
	 				<div id = "box" href = "">
		 				<div class = "infor-product">
			 					<img src = ${products.getImage() }>
			 					<h1>${products.getName()}</h1>
			 					<p class = "des" >${products.getDescription() }</p>
			 					<p class= "price" >$${products.getPrice() }</p>	
			 					<div class = "modify-product">
			 						<a class = "detail-button" href = "detail-product?productId=${products.getId() }">Detail</a>
			 						<a class = "edit-button" href = "admin-edit-product?id=${products.getId() }">Edit</a>
			 						<a class = "delete-button" href = "admin-delete-product?id=${products.getId() }" >Delete</a> 
			 					</div> 			
		 				</div>
		 				
		 			</div>
	 				</c:forEach>
	 			</div>
	 		</div>
	 	</content>
	 	
	 	<aside id ="right_side">
	 	
	 	</aside>
	 </section>
	 
	 <footer>
	 	<div class = "page_num">
		 		<ul>
		 			<c:set  var = "index" value = "1"></c:set>
		 			<c:forEach begin = "1" end = "${quantity }">
		 			<li><a href = "homepage?index=${index }&limit=${limit}">${index }</a></li>
		 			<c:set  var = "index" value = "${index+1 }"></c:set>
		 			</c:forEach>
		 		</ul>
	 	</div>
	 </footer>
	 
</body>
</html> 