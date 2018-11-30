<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.bookstore.bean.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
</head>
<body>
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
 <form class="form-horizontal" action="CustomerServlet">
<button type="submit" class="btn btn-light">Profile</button>
</form>
</nav>

<!-- <form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form> -->
<table class="table table-dark table-striped table-bordered table-hover">
<thead class="thead-dark">
<tr>
<td>ID</td>
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
<td><%=(b.getIsbn())%></td>
<td><%=(b.getTitle())%></td>
<td><%=(b.getAuthor())%></td>
<td><%=(b.getPrice())%></td>
<td><%=(b.getStock())%></td>
</tr>
<%} %>
</table>
</body>
</html>