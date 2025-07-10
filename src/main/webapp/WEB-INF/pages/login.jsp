<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
	<div class="main-div">
	<div class="left-panel">
		<img src="${pageContext.request.contextPath}/images/signup.jpeg" alt="Signup image" style="width: 400px;"/>
	</div>
	<div class="right-panel">
		<h1>Login</h1>
	<form action="${pageContext.request.contextPath}/students/login" method="POST" >
			<label>Enter UserName:</label><br/>
			<input type="text" placeholder="Enter username" name="username" class="data"></input><br/>
			
			<label>Enter password:</label><br/>
			<input type="password" placeholder="Enter password" name="passwd" class="data"></input><br/>
			
			<p style="color:red">${error}</p>
			<input type="submit" value="Submit" class="button"/><br/>
			
			<div class="link">
			<label>New Register?</label>
			<a href="${pageContext.request.contextPath}/students/form">Sign In</a>
			</div>
		</form>
		
		</div>
	</div>	
</body>
</html>