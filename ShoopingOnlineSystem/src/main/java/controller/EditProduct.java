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



@WebServlet("/admin-edit-product")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = "Chinh sua san pham";
		request.setAttribute("title", title);
		
		String action = "admin-edit-product";
		request.setAttribute("action", action);
		
		int id = Integer.valueOf(request.getParameter("id"));
		request.setAttribute("p", ProductService.findById(id));

		RequestDispatcher dispatcher = request.getRequestDispatcher("ModifyProduct.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		ProductService.editProduct(Integer.valueOf(request.getParameter("idPrd")), 
				request.getParameter("namePrd"), request.getParameter("desPrd"), 
				Double.valueOf(request.getParameter("pricePrd")));
		
		response.sendRedirect("homepage");
		
		
	}
}
