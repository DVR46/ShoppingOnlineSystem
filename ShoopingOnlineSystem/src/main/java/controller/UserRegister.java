package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.users;
import service.UserService;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/user-register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title  = "Register";
		request.setAttribute("title", title);
		
		String action = "user-register";
		request.setAttribute("action", action);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login&Register.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = UserService.findId(request.getParameter("nameUser"), request.getParameter("passwordUser"), 0);
		
		if(id == 0) {
			boolean check = UserService.createAccount(request.getParameter("nameUser"), request.getParameter("passwordUser"));
			if(check) {
				response.sendRedirect("user-login");
			}
			else {
				response.sendRedirect("user-register");
			}
		}
		else {
			response.sendRedirect("user-register");
		}

	}

}
