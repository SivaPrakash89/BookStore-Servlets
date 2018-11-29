<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bookstore.bean.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
<%
//allow access only if session exists
String user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
      <a class="navbar-brand" href="#">BookStore</a>
      <ul class="navbar-nav">
      <li class="nav-item"><a class="nav-link">Welcome <%=userName %> </a></li>
    </ul>
    <div class="col-sm-1">
<hr>
</div>
    <form class="form-horizontal" action="LogoutServlet" method="post">
<button type="submit" class="btn btn-light">Logout</button>
</form>
<div class="col-sm-1">
<hr>
</div>
<form class="form-horizontal" action="addBook.html">
      <button type="submit" class="btn btn-light">Add Book</button>
</form>
</nav>
<table class="table table-dark table-striped table-bordered table-hover">
<thead class="thead-dark">
<tr>
<td>Title</td>
<td>Author</td>
<td>Price</td>
<td>Stock</td>
</tr>
</thead>

<%
List<Book> booksList = (List<Book>)session.getAttribute("BookList"); 
for(Book b:booksList) {
%>
<tr>
<td><%=(b.getTitle())%></td>
<td><%=(b.getAuthor())%></td>
<td><%=(b.getPrice())%></td>
<td><%=(b.getStock())%></td>
<td>
<form class="form-horizontal" action="AdminServlet" method="post">
	<input type="hidden" name="id" value=<%=b.getIsbn()%>>
      <button type="submit" class="btn btn-light" name="action" value="delete">Delete</button>
      <button type="submit" class="btn btn-light" name="action" value="update">Update</button>
</form>
</td>
</tr>
<%} %>
</table>
</body>
</html>