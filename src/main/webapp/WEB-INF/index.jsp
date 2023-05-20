<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:red;">Welcome!</h1>
	<p>Join our growing community</p>
	<div>
		<form:form action="/register"  method="post" modelAttribute="newUser">
			<div>
				<form:label path="userName">UserName:</form:label>
				<form:errors path="userName" class="red"/>
				<form:input type="text" path="userName"/>
			</div>
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" class="red"/>
				<form:input type="email" path="email"/>
			</div>
			<div>
				<form:label path="password">Password:</form:label>
				<form:errors path="password" class="red"/>
				<form:input type="password" path="password"/>
			</div>
			<div>
				<form:label path="confirm">confirm password:</form:label>
				<form:errors path="confirm" class="red"/>
				<form:input type="password" path="confirm"/>
			</div>
			<input type="submit" />
		</form:form>
	</div>
	<div>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div>
				<form:label path="email">Email:</form:label>
				<form:errors path="email" class="red"/>
				<form:input type="text" path="email"/>
			</div>
			<div>
				<form:label path="password">Password</form:label>
				<form:errors path="password" class="red"/>
				<form:input type="password" path="password"/>
			</div>
			<input type="submit" />
		</form:form>
	</div>
</body>
</html>