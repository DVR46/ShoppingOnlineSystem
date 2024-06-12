package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CartService;

/**
 * Servlet implementation class DeleteCartProduct
 */
@WebServlet("/delete-cart-product")
public class DeleteCartProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteCartProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId = Integer.valueOf(request.getParameter("cartId"));
		
		CartService.deleteProduct(cartId);
		response.sendRedirect("cart");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
