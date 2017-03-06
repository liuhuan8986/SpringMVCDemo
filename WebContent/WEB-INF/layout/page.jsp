    <%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="GBK"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
    <%@ page session="false" %>
<html>
<head>
<%-- <link rel="stylesheet" type="text/css"  href='<s:url value="/css/style.css"></s:url>'> --%>
</head>
<body>
	<div id="header" >
		<t:insertAttribute name="header"/>
	</div>
	<div id="content">
		<t:insertAttribute name="body"/>
	</div>
	<div id="footer" >
		<t:insertAttribute name="footer"/>
	</div>
</body>
</html>