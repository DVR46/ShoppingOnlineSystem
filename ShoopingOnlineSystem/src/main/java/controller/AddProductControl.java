package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Products;
import service.ProductService;


@WebServlet("/admin-add-product")
public class AddProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = "Them san pham";
		request.setAttribute("title", title);
		
		String action = "admin-add-product";
		request.setAttribute("action", action);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ModifyProduct.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService.addProduct(request.getParameter("namePrd"),
				request.getParameter("desPrd"),
				Double.valueOf(request.getParameter("pricePrd")));
		
	}

}
