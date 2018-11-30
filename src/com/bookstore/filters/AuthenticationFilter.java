package com.bookstore.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.User;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {
	private ServletContext context;
    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie c[]=req.getCookies();
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		HttpSession session = req.getSession();
		
		if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
			this.context.log("Unauthorized access request");
			res.sendRedirect("index.html");
		}
		else if(session.isNew() && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
			chain.doFilter(request, response);
		}
		else {
			User user = (User) session.getAttribute("userObject");
			if(user == null){
				chain.doFilter(request, response);
			}
			else if(user.getRole().equals("customer") && (uri.endsWith("LogoutServlet") || uri.endsWith("LoginServlet") || uri.endsWith("userhome.jsp") || uri.endsWith("profile.jsp") || uri.endsWith("index.html"))){
				chain.doFilter(request, response);
			}
			else if(user.getRole().equals("customer") && !(uri.endsWith("LoginServlet") || uri.endsWith("userhome.jsp") || uri.endsWith("profile.jsp") || uri.endsWith("index.html"))){
				res.sendRedirect("userhome.jsp");
			}
			else if(user.getRole().equals("admin") && (uri.endsWith("LogoutServlet") || uri.endsWith("LoginServlet") || uri.endsWith("adminhome.jsp") || uri.endsWith("addBook.html") || uri.endsWith("index.html") || uri.endsWith("upateBook.html"))){
				chain.doFilter(request, response);
			}
			else if(user.getRole().equals("admin") && !(uri.endsWith("LoginServlet") || uri.endsWith("adminhome.jsp") || uri.endsWith("addBook.html") || uri.endsWith("index.html") || uri.endsWith("upateBook.html"))){
				res.sendRedirect("adminhome.jsp");
			}
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

}
