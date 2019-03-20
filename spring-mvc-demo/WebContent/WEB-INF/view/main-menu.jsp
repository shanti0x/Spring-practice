<!DOCTYPE HTML>
<html>
<head>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/my-test.css">

<script
	src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>
<body>

	<h2>Spring MVC Demo - Home Page</h2>
	<a href="hello">Plain Hello World</a>

	<br>
	<br>

	<img
		src="${pageContext.request.contextPath}/resources/images/spring-logo.png" width="107" height="98" />

	<br>
	<br>

	<input type="button" onclick="doSomeWork()" value="Click Me" />

	<hr>
	<a href="showForm"> Hello World form</a>
</body>

</html>