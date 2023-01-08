<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="java.util.Date" %>
<%
 Date now = new Date();
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  현재 시간은 ? <%=now %>
</h1>
<c:if test="${list ne null }">
<p> 널이 아니지롱 </p>
</c:if>
<P>${ list }</P>
</body>
</html>
