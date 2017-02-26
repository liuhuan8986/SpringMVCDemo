<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
</head>
<body>
	<h1>Register</h1>
	
<!-- 	<form method="post">
		First Name:<input type="text" name="firstName"/><br/>
		Last Name:<input type="text" name="lastName"/><br/>
		UserName :<input type="text" name="username"/><br/>
		Password :<input type="text" name="password"/><br/>
		<input type="submit" value="register"/>
	</form> -->
	
	<sf:form method="post" commandName="spitter">
		First Name:<sf:input path="firstName"/><br/>
		<sf:errors path="firstName"> error error</sf:errors>
		Last Name:<sf:input path="lastName"/><br/>
		UserName :<sf:input path="username"/><br/>
		Password :<sf:password path="password"/><br/>
		<input type="submit" value="register"/>
	</sf:form>
</body>
</html>