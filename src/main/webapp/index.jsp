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
    <h1 class="display-3 text-center">Registration Form</h1>
    <div class="container">
    	<form action="RegisterServlet" method="post">
    			<input type="hidden" name="process" value="registerForm">
    		  <div class="mb-3">
			    <label for="username" class="form-label">Username</label>
			    <input type="text" class="form-control" id="username" name="userName">
			  </div>
			  <div class="mb-3">
			    <label for="address" class="form-label">Address</label>
			    <input type="text" class="form-control" id="address" name="userAddress">
			  </div>
			  <div class="mb-3">
			    <label for="phone" class="form-label">Phone Number</label>
			    <input type="text" class="form-control" id="address" name="userPhoneNumber">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Email address</label>
			    <input type="email" class="form-control" id="exampleInputEmail1" name="userEmail">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">Password</label>
			    <input type="password" class="form-control" id="exampleInputPassword1" name="userPassword">
			  </div>
			  
  <button type="submit" class="btn btn-primary">Register</button>
</form>
    </div>
    </div>
    
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</html>