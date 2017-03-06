<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="GBK"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spittr</title>
</head>
<body>

	<%-- <h1><s:message code="spitter.welcome"/></h1> --%>
	<h1>welcome</h1>
	<s:url value="/spitter/register" var="test" >
		<s:param name="max" value="60"/>
		<s:param name="min" value="20"/>
	</s:url>
	
	<s:url value="/spitter/register/{username}" var="test2" htmlEscape="true">
		<s:param name="max" value="60"/>
		<s:param name="min" value="20"/>
		<s:param name="username">ËÀÉñ</s:param>
	</s:url>
<%-- 	<h1>${test }</h1>
	<h1>${test2 }</h1> --%>
	<a href="#">Splittles</a>
	<!-- <a href="./spitter/register">Register</a> -->
	<a href='<s:url value="/spitter/register"></s:url>'>Register</a>
</body>
</html>