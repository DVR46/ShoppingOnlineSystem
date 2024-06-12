package controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Products;
import model.users;
import service.HomeService;
import service.ProductService;


@WebServlet("/homepage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Paging
		int limit = 5;
		if(request.getParameter("limit") != null) {
			limit = (Integer.valueOf(request.getParameter("limit")));
		}
		request.setAttribute("limit", limit);
		
		int quantity = (int) HomeService.quantityProducts(limit);
		request.setAttribute("quantity", quantity);
		
		ArrayList<Products> products = new ArrayList<Products>();
		if(request.getParameter("index") != null) {
			int index = Integer.valueOf(request.getParameter("index"));
			products = HomeService.displayProducts(index, limit);
		}
		else {
			products = HomeService.displayProducts(1, limit);
		}
		request.setAttribute("products", products);
		
	//User
		HttpSession session = request.getSession();
		users user = (users) session.getAttribute("user");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomePage.jsp");
		dispatcher.forward(request, response);
		
	}
	


}
