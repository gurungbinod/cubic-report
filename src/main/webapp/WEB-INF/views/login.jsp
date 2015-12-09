<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login into App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
	<link rel="stylesheet" href="static/css/style.css" type="text/css" />
</head>
<body>

	<div id="login_container">
		<form id="formLogin" action="j_spring_security_check" method="post">
			<h2>User Login</h2>
			<div class="form-group">
				<label for="email">Email</label> <input
					type="text" class="form-control" id="email"
					placeholder="Email" name="j_username" value="gurung.binod@gmail.com">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input
					type="password" class="form-control" id="password"
					placeholder="Password" name="j_password" value="password">
			</div>
			<div class="checkbox">
				<label> <input type="checkbox" name="remember"> Remember Me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>

	<!-- Latest compiled and minified JavaScript -->
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
		integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
		crossorigin="anonymous"> </script>
		
		
		
	<script type="text/javascript">
	
	$(function (){
		/* $(document).on("submit","#formLogin",function (e) {
			e.preventDefault();
			var data = $(this).serialize();
			$.ajax({
				url:"<c:url value='/login' />",
				type:"post",
				data:data,
				dataType:"json",
			})
			.done(function (data) {
				
				console.log(data);
				if (data.status == true) {
					alert("login successful");
					window.location = "<c:url value='/secure/dashboard' />";
				} else {
					alert("Bad Credentials");
				}
			})
			.error(function () {
				console.log('ERROR::');
			}); */
		})
	});
	
	
	
	</script>
		</body>
		</html>
	