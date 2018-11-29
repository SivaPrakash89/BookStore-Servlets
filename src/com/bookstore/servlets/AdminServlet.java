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

import com.bookstore.bean.Book;
import com.bookstore.dao.classes.BookDao;
import com.bookstore.dao.interfaces.BookDaoInterface;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		BookDaoInterface bookDao = new BookDao();
		switch(action){
			
		case "add":
			String isbn = request.getParameter("isbn");
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			double price = Double.parseDouble(request.getParameter("price"));
			long stock = Long.parseLong(request.getParameter("stock"));
			
			int success = bookDao.addBook(isbn, title, author, price, stock);
			if(success != 0){
				PrintWriter out= response.getWriter();
					out.println("<script type=\"text/javascript\">");
				   out.println("alert('Book added successfully!');");
				   out.println("</script>");
				   List<Book> booksList = bookDao.getAllBooks();
					session.setAttribute("BookList", booksList);
				   RequestDispatcher rd=request.getRequestDispatcher("/adminhome.jsp");
				   rd.include(request, response);
			}
			else{
				PrintWriter out= response.getWriter();
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Failed to add Book!');");
				   out.println("</script>");
				   RequestDispatcher rd=request.getRequestDispatcher("/adminhome.jsp");
				   rd.include(request, response);
			}
			break;
		case "delete":
			String isbnDelete = request.getParameter("id");
			int done = bookDao.deleteBook(isbnDelete);
			if(done != 0){
				PrintWriter out= response.getWriter();
				out.println("<script type=\"text/javascript\">");
			   out.println("alert('Book Deleted!');");
			   out.println("</script>");
			   List<Book> booksList = bookDao.getAllBooks();
				session.setAttribute("BookList", booksList);
			   RequestDispatcher rd=request.getRequestDispatcher("/adminhome.jsp");
			   rd.include(request, response);
			}
			else {
				PrintWriter out= response.getWriter();
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Error while deleting Book!');");
				   out.println("</script>");
				   RequestDispatcher rd=request.getRequestDispatcher("/adminhome.jsp");
				   rd.include(request, response);
			}
			break;
			
		case "update":
			String isbnUpdate = request.getParameter("id");
			Book book = bookDao.getBook(isbnUpdate);
			session.setAttribute("Book", book);
			RequestDispatcher rd=request.getRequestDispatcher("/updateBook.jsp");
			rd.include(request, response);
			break;
			
		case "updateBook":
			String isbnU = request.getParameter("isbn");
			Long stockU = Long.parseLong(request.getParameter("stock"));
			int updated = bookDao.updateStock(isbnU, stockU);
			if(updated != 0){
				PrintWriter out= response.getWriter();
				out.println("<script type=\"text/javascript\">");
			   out.println("alert('Book Updated!');");
			   out.println("</script>");
			   List<Book> booksList = bookDao.getAllBooks();
				session.setAttribute("BookList", booksList);
			   RequestDispatcher rdu =request.getRequestDispatcher("/adminhome.jsp");
			   rdu.include(request, response);
			}
			else {
				PrintWriter out= response.getWriter();
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Error while updating Book!');");
				   out.println("</script>");
				   RequestDispatcher rdu =request.getRequestDispatcher("/adminhome.jsp");
				   rdu.include(request, response);
			}
		}
		
	}

}
