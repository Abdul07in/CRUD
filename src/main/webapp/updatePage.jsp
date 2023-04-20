<%@page import="com.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Crud Operations</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    
    <jsp:include page="navbar.jsp"></jsp:include>
   <% User user = (User) session.getAttribute("user"); %>
    
    
    <div class="container">    
    <h1 class="display-3 text-center">Update User</h1>
    <div class="container">
    	<form action="RegisterServlet" method="post">
    			<input type="hidden" name="process" value="updateForm">
    			<input type="hidden" name="userId" value="<%= user.getUserId() %>">
    		  <div class="mb-3">
			    <label for="username" class="form-label">Username</label>
			    <input type="text" class="form-control" id="username" name="userName" value="<%= user.getUserName()%>">
			  </div>
			  <div class="mb-3">
			    <label for="address" class="form-label">Address</label>
			    <input type="text" class="form-control" id="address" name="userAddress" value="<%= user.getUserAddress() %>">
			  </div>
			  <div class="mb-3">
			    <label for="phone" class="form-label">Phone Number</label>
			    <input type="text" class="form-control" id="address" name="userPhoneNumber" value="<%= user.getUserPhoneNumber() %>">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Email address</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" name="userEmail" value="<%= user.getUserEmail() %>">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Password</label>
			    <input type="text" class="form-control" id="exampleInputPassword1" name="userPassword" value="<%= user.getUserPassword() %>">
			  </div>
			  <div class="text-center">
				  <button type="submit" class="btn btn-warning" style="width: 200px;">Update</button>
			  </div>
</form>
    </div>
    </div>
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>