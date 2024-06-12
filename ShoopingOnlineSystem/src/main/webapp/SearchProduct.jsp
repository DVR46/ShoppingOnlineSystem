<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel = "stylesheet" href = "HomePage.css">

</head>
<body>
	<header>
		<div id = "menu_container">
			<a href = "homepage"><img src = "https://tainghe.com.vn/media/brand/soundpeats.png"></a>
			<form action = "search-product" method = "get">
			<input type = "text" placeholder="Search" name = "name" value = "${key }" required>
			<button type = "submit">
			<i class = "search_icon"></i>
			</button>
			</form>
			<ul>
				<li><a href = "user-login" >Login</a></li>
				<li><a href = "user-register">Register</a></li>
				<li><a href = "">Cart<i class = "cart_icon"></i></a></li>
				<li><a href = "">Messages<i class = "mess_icon"></i></a></li>
			</ul>
		</div>
	 </header>
	 
	 <section id = "body_page">
	 	<aside id ="left_side">
	 	
	 	</aside>
	 	
	 	<content>
	 		<div id = "name-search">
	 		<h1>${key }</h1>
	 		<p>${quantity } ket qua</p>
	 		</div>
	 		
	 			<div id = "product_type">
<!-- 	 		<h1>Product Type</h1> -->
	 			<div id = "products">
	 				<c:forEach items = "${products}" var = "products">
	 				<div id = "box" href = "">
		 				<div class = "infor-product">
			 					<img src = ${products.getImage() }>
			 					<h1>${products.getName()}</h1>
			 					<p class = "des" >${products.getDescription() }</p>
			 					<p class= "price" >$${products.getPrice() }</p>	
			 					<div class = "modify-product">
			 						<a class = "detail-button" href = "detail-product?id=${products.getId() }"  target = "_blank">Detail</a>
			 						<a class = "edit-button" href = "edit-product?id=${products.getId() }">Edit</a>
			 						<a class = "delete-button" href = "delete-product?id=${products.getId() }" >Delete</a> 
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
	 
</body>
</html>