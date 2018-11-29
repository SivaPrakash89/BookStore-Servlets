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
<title>Update Book</title>
</head>
<%
Book book = (Book)session.getAttribute("Book");
%>
<body>
<div class="row">
<div class="container">
<form class="form-horizontal" action="AdminServlet" method="post">
<div class="form-group">
 <label class="control-label col-sm-2">ID:</label>
 <div class="col-sm-10">
 <input type="text" name="isbn" class="form-control" readonly value=<%=book.getIsbn()%>>
 </div>
 </div>
 <div class="form-group">
<label class="control-label col-sm-2">Title:</label>
<div class="col-sm-10">
<input class="form-control" type="text" name="title" readonly value=<%=book.getTitle()%>>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2">Author:</label>
<div class="col-sm-10">
<input class="form-control" type="text" name="author" readonly value=<%=book.getAuthor()%>>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2">Price:</label>
<div class="col-sm-10">
<input class="form-control" type="text" name="price" readonly value=<%=book.getPrice()%>>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2">Stock:</label>
<div class="col-sm-10">
<input class="form-control" type="text" name="stock" value=<%=book.getStock()%>>
</div>
</div>
 <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" name="action" value="updateBook">Update Book</button>
    </div>
  </div>
</form>
</div>
</div>
</body>
</html>