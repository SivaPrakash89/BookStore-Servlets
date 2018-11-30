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
<title>Profile</title>
</head>
<%
Address address = (Address)session.getAttribute("Address");
session.removeAttribute("Address");
%>
<body>
<div class="row">
<div class="container">
<form class="form-horizontal" action="CustomerServlet" method="post">
<div class="form-group">
 <label class="control-label col-sm-2">House No:</label>
 <div class="col-sm-10">
 <input type="text" name="houseno" class="form-control" value=<%=address.getHouseNo()%>>
 </div>
 </div>
 <div class="form-group">
<label class="control-label col-sm-2">Street:</label>
<div class="col-sm-10">
<input class="form-control" type="text" name="street" value=<%=address.getStreet()%>>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2">Area:</label>
<div class="col-sm-10">
<input class="form-control" type="text" name="area" value=<%=address.getArea()%>>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2">City:</label>
<div class="col-sm-10">
<input class="form-control" type="text" name="city" value=<%=address.getCity()%>>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2">Pincode:</label>
<div class="col-sm-10">
<input class="form-control" type="text" name="pincode" value=<%=address.getPincode()%>>
</div>
</div>
 <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
    <input type="hidden" name="userupdate" value=<%=session.getAttribute("userIdUpdate")%>>
      <button type="submit" class="btn btn-success" name="action" value="updateAddress">Update Address</button>
      <button type="submit" class="btn btn-default" name="action" value="back">Back</button>
    </div>
  </div>
</form>
</div>
</div>
</body>
</html>