package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;
import service.ProductService;

@WebServlet("/search-product")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("name");
		if(key.trim().equals("")) {
			response.sendRedirect("homepage");
		}
		else {
			ArrayList<Products> products = ProductService.searchProduct(key);
			request.setAttribute("key", key);
			request.setAttribute("quantity", products.size());
			request.setAttribute("products", products);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("SearchProduct.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
