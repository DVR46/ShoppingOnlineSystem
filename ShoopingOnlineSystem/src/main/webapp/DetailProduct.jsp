<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thong tin san pham</title>
<link rel = "stylesheet" href = "DetailProduct.css">
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
	 
	 <nav id = "link">
	 	<p></p>
	 	<h1>${p.getName() }</h1>
	 </nav>
	 
	  <section id = "body_page">
	 	<aside id ="left_side">
	 	
	 	</aside>
	 	<content>
	 		<div id = "left-infor">
	 		<img src = "${p.getImage() }">
	 		
	 		<div class = "box-type-color">
	 		<c:forEach begin = "1" end = "4">
	 			<div class = "box-type-color-infor">
	 				<div class = "type-color">
	 					<img src = >
	 					<p>Mau</p>
	 				</div>
	 			</div>
	 		</c:forEach>
	 		</div>
	 		
	 		<div class = "box-description">
	 			<h1>${p.getDescription() }</h1>
	 		</div>
	 		
	 		</div>
	 		
	 		<div id = "right-infor">
	 		
	 			<div class = "box-price">
	 				<h1>$${p.getPrice() }</h1>
	 				
	 				<div class = "box-buy">
		 				<a href = >Mua</a>
		 				<a href = >Tra Gop</a>
		 				<a href = >Lien He</a>
		 				<a href = "add-to-cart?id=${p.getId() }">Add to Cart</a>
	 				</div>
	 			</div>
	 		
	 		</div>
	 	</content>
	 	<aside id ="right_side">
	 	
	 	</aside>
	 </section>
</body>
</html>