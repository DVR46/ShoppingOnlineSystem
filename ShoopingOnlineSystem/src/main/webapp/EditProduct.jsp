<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chinh sua san pham</title>
<link rel = "stylesheet" href = "ModifyProduct.css">
<link rel = "stylesheet" href = "HomePage.css">
</head>
<body>
	<div id = "form">
		<h1>Chinh sua san pham</h1>
		<form action = "edit-product" method = "post">
			<label for = "name">Nhap ten san pham: </label>
			<input type = "text" id = "name" name = "namePrd">
			<label for = "des">Nhap mo ta: </label>
			<input type = "text" id = "des" name = "desPrd">
			<label for = "price">Nhap gia: </label>
			<input type = "number" id = "price" name = "pricePrd">
			<button type = "submit">Submit</button>
		</form>
	</div>
</body>
</html>