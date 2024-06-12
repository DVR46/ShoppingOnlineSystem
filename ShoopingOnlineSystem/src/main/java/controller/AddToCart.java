package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.users;
import service.CartService;
import service.ProductService;
import service.UserService;

@WebServlet("/add-to-cart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") == null) {
			response.sendRedirect("homepage");
			return;
		}
		
		int productId = Integer.valueOf(request.getParameter("id"));
		request.setAttribute("productId", productId);
		
		HttpSession session = request.getSession();
		users user = (users) session.getAttribute("user");
		
		CartService.addToCart(user.getId(), productId);
//		response.sendRedirect("detail-product?productId=" + productId);
		response.sendRedirect("");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
