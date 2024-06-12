<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<link rel = "stylesheet" href = "HomePage.css">
</head>
<body>
	<header>
		<div id = "menu_container">
			<a href = "homepage"><img src = "https://tainghe.com.vn/media/brand/soundpeats.png"></a>
			<form>
			<input type = "text" placeholder="Search">
			<button type = "submit">
			<i class = "search_icon"></i>
			</button>
			</form>
			<ul>
				<c:if test="${user.getId() > 0}">
				<c:set var="display"  value="none"></c:set>
				<li>${user.getUserName() }</li>
				<li><a href = "user-log-out">Log Out</a></li>
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
<!-- 	 		<h1>Product Type</h1> -->
	 			<div id = "products">
	 				<c:forEach items = "${carts}" var = "carts">
	 				<div id = "box">
		 				<div class = "infor-product">
			 					<img src = ${carts.getProduct().getImage() }>
			 					<h1>${carts.getProduct().getName()}</h1>
			 					<p class = "des" >${carts.getProduct().getDescription() }</p>
			 					<p class= "price" >$${carts.getProduct().getPrice() }</p>	
			 					<div class = "modify-product">
			 						<a class = "detail-button" href = "detail-product?productId=${carts.getProduct().getId() }">Detail</a>
			 						<a class = "delete-button" href = "delete-cart-product?cartId=${carts.getId() }" >Delete</a> 
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