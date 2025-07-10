<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div class="main-div">
		<div class="left-panel">
				<img src="${pageContext.request.contextPath}/images/signup.jpeg" alt="Signup image" style="width: 400px;"/>
		</div>
		
		<div class="right-panel">
		     
			<h1>Sign Up</h1>
		<form action="/students/signup" method="POST" >
				<label>Enter UserName:</label><br/>
				<input type="text" placeholder="Enter username" name="username" class="data"></input><br/>
				
				<label>Enter password:</label><br/>
				<input type="password" placeholder="Enter password" name="passwd" class="data"></input><br/>
				
				<c:if test="${not empty error}">
               <p style="color:red;">${error}</p>
                </c:if>
				
				<input type="submit" value="Submit" class="button"/><br/>
				
				<div class="link">
				<label>Already SignedIn?</label>
				<a href="${pageContext.request.contextPath}/students/loginform"">Login</a>
				</div>
			</form>
			</div>
		</div>	
</body>
</html>