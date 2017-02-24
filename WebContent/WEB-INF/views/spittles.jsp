<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>xxxxxxxx</title>
</head>
<body>
	<c:forEach items="${spiltleList}" var="spittle">
		<li id="spittle_<c:out value="spittle.id"/>">
			<div>
				<c:out value="${spittle.message}"/>
			</div>
			<div>
				<span><c:out value="${spittle.time }"/></span>
				<span>
					(<c:out value="${spittle.latitude}"></c:out>,<c:out value="${spittle.longitude}"></c:out>)
				</span>
			</div>
		</li>
	</c:forEach>
</body>
</html>