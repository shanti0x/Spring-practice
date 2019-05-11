<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>


	<title> Spring security Company  Home Page</title>

</head>

<body>


	<h2>
	
	My top secret Stuff</h2>
	
	<hr>
	<p> 
	Welcome to Spring Security company home page!
	</p> 
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>

</body>
</html>