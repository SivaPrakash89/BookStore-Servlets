package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.File;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.Book;
import com.bookstore.bean.User;
import com.bookstore.dao.classes.BookDao;
import com.bookstore.dao.interfaces.BookDaoInterface;
import com.bookstore.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		LoginService login = new LoginService();
		User loginUser = new User();
		loginUser = login.validateUser(user, pwd);
		if(loginUser  != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", user);
			response.addCookie(userName);
			BookDaoInterface bookDao = new BookDao();
			List<Book> booksList = bookDao.getAllBooks();
			session.setAttribute("BookList", booksList);
			session.setAttribute("userDetails", loginUser);
			if(loginUser.getRole().equals("admin")){
				response.sendRedirect("adminhome.jsp");
			}
			else{
				response.sendRedirect("userhome.jsp");
			}
			
		}
		else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}

}
