<%@page import="com.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operations</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<%
	List<User> ulist = (List<User>) session.getAttribute("ulist");
%>
<% String message = request.getParameter("message"); 
    	if(message != null){
    	%>
	<div class="alert alert-primary alert-dismissible fade show"
		role="alert">
		<strong>Message</strong> <%= message %>
		<button type="button" class="btn-close" data-bs-dismiss="alert"
			aria-label="Close"></button>
	</div>
	<%	
    	}
    %>
    
<div class="container">
	<h1 class="display-3 text-center">Operations</h1>
	<table class="table">
		
		<thead>
			<tr>
			<th>User Id</th>
			<th>User Name</th>
			<th>User Address</th>
			<th>User Phone</th>
			<th>User Email</th>
			<th>User Password</th>
			<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<% for(User u : ulist){ %>
			<tr>
			<td><%= u.getUserId() %></td>
			<td><%= u.getUserName() %></td>
			<td><%= u.getUserAddress() %></td>
			<td><%= u.getUserPhoneNumber() %></td>
			<td><%= u.getUserEmail() %></td>
			<td><%= u.getUserPassword() %></td>
			<td>
				<a href="RegisterServlet?process=updateUser&userId=<%= u.getUserId()%>"><button type="button" class="btn btn-warning">Update</button></a>
				<a href="RegisterServlet?process=deleteUser&userId=<%= u.getUserId()%>"><button type="button" class="btn btn-danger">Delete</button></a>
			</td>
			</tr>
			<%} %>
		</tbody>
	
	</table>
	
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>