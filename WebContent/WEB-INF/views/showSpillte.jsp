<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show</title>
	<style type="text/css">
		p{color: red;font-size: 24px}
	</style>
</head>
<body>

<p><c:out value="ID:${spiltle.id }"></c:out></p>
<c:out value="time:${spiltle.time }"></c:out><br>
<c:out value="message:${spiltle.message }"></c:out><br>
<c:out value="latitude:${spiltle.latitude}"></c:out><br>
<c:out value="longitude:${spiltle.longitude}"></c:out><br>
</body>
</html>