<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %><%--excption내장객체사용가능 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>err.jsp</title>
</head>
<body style = "background-color:pink">
<%--Exception e = (Exception)request.getAttribute("e"); --%>
실패: <%--=e.getMessage() --%>
<%=exception.getMessage() %>


</body>
</html>