package filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.users;

/**
 * Servlet Filter implementation class CheckLogin
 */
@WebFilter("/*")
public class CheckLogin extends HttpFilter implements Filter {
	private final ArrayList<String> guest;
       
    public CheckLogin() {
    	guest = new ArrayList<String>();
    	guest.add("");
    	guest.add("''");
    	guest.add("/homepage");
    	guest.add("/search-product");
    	guest.add("/detail-product");
    	guest.add("/user-login");
    	guest.add("/user-register");
    	guest.add("/admin-login");
    	guest.add("/user-log-out");
    }

	public void destroy() {

	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String servletPath = req.getServletPath();
		
		String queryString = "";
		if(req.getQueryString() != null) {
			queryString = req.getQueryString();
		}
		
		HttpSession session = req.getSession();
		users loginedUser = (users) session.getAttribute("user");
		
		if(servletPath.contains("css")) {
			chain.doFilter(request, response);
			return;
		}
		if(guest.contains(servletPath)) {
			chain.doFilter(request, response);
			return;
		}
		if(servletPath.startsWith("/admin") && loginedUser == null) {
			resp.sendRedirect("admin-login?redirect=" + servletPath.substring(1) + "?" + queryString);
			return;
		}
		if(servletPath.startsWith("/admin")) {
			if(loginedUser.getRole() == 1) {
				chain.doFilter(request, response);
			}
			else {
				resp.sendRedirect("homepage");
			}
			return;
		}
		if(loginedUser == null) {
			resp.sendRedirect("user-login?redirect=" + servletPath.substring(1) + "?" + queryString);
			return;
		}
		if(loginedUser != null) {
			chain.doFilter(request, response);
			return;
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
