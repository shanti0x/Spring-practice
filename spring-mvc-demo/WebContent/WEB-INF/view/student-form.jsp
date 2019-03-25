<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- cand form este incarcat Spring MVC va chema getter methods - student.getFirstName() si lastName -->
	<!-- iar cand introducem datele, submit va apela setFirstName() -->

	<form:form action="processForm" modelAttribute="student">

First name: <form:input path="firstName" />

		<br>
		<br>

Last name: <form:input path="lastName" />

		<br>
		<br>
		Country:
		<form:select path="country">

			<form:options items="${student.countryOptions}" />
			<!-- 			items se refera la colectia de date -->


			<!-- 			varianta 2 -->
			<%-- 		<form:option value="Brazil" label="Brazil"/>  --%>
			<%-- 		<form:option value="France" label="France"/>  --%>
			<%-- 		<form:option value="Germany" label="Germany"/>  --%>
			<%-- 		<form:option value="India" label="India"/>  --%>

		</form:select>
		<br>
		<br>
		
		Favorite Language:
		Java<form:radiobutton path="favoriteLanguage" value="Java" /> 
		C#<form:radiobutton path="favoriteLanguage" value="C#" /> 
		PHP<form:radiobutton path="favoriteLanguage" value="PHP" /> 
		Ruby<form:radiobutton path="favoriteLanguage" value="Ruby" />

		<!-- la submit, spring va apela student.setFavoriteLanguage() -->

		<br>
		<br>
		Operating Systems:
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />


		<br>
		<br>


		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>