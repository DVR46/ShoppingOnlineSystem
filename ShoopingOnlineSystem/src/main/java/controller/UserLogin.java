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
import service.UserService;


@WebServlet("/user-login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title  = "User Login";
		if(request.getAttribute("title") != null) {
			title = (String) request.getAttribute("title");
		}
		request.setAttribute("title", title);
		
		String redirect = "";
		if(request.getParameter("redirect") != null) {
			redirect = request.getParameter("redirect");
		}
		request.setAttribute("redirect", redirect);
		
		int role = 0;
		if(request.getAttribute("role") != null) {
			role = (int) request.getAttribute("role");
		}
		request.setAttribute("role", role);
		
		String action = "user-login";
		request.setAttribute("action", action);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Login&Register.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = UserService.findId(request.getParameter("nameUser"), request.getParameter("passwordUser"),
				Integer.valueOf(request.getParameter("role")));
		
		String requestURI = request.getRequestURI();
		
		if(id > 0) {			
			HttpSession session = request.getSession();
			users user = UserService.findById(id, Integer.valueOf(request.getParameter("role")));
			session.setAttribute("user", user);
		}
		else {
			response.sendRedirect(request.getParameter("redirect"));
			return;
		}
		response.sendRedirect(request.getParameter("redirect"));	
	}

}
