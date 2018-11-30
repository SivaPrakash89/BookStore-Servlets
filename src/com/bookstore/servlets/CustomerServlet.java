package com.bookstore.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.Address;
import com.bookstore.bean.Book;
import com.bookstore.bean.User;
import com.bookstore.dao.classes.BookDao;
import com.bookstore.dao.classes.LoginDao;
import com.bookstore.dao.interfaces.BookDaoInterface;
import com.bookstore.services.LoginService;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginService login = new LoginService();
		User user = (User) session.getAttribute("userDetails");
		String userID = user.getUserId();
		Address address = login.getAddress(userID);
		session.setAttribute("Address", address);
		session.setAttribute("userIdUpdate", userID);
		response.sendRedirect("profile.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		switch(action){
		case "updateAddress":
			String userId = request.getParameter("userupdate");
			String houseNo = request.getParameter("houseno");
			String street = request.getParameter("street");
			String area = request.getParameter("area");
			String city = request.getParameter("city");
			long pincode = Long.parseLong(request.getParameter("pincode"));
			LoginDao loginDao = new LoginDao();
			Address address = loginDao.updateAddress(userId, houseNo, street, area, city, pincode);
			if(address != null){
				PrintWriter out= response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Address updated!');");
				out.println("</script>");
				session.setAttribute("Address", address);
				RequestDispatcher rd=request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);
			}
			else{
				PrintWriter out= response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Failed to update address!');");
				out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);
			}
			break;
		case "back":
			RequestDispatcher rd=request.getRequestDispatcher("/userhome.jsp");
			rd.include(request, response);
		}
	}

}
