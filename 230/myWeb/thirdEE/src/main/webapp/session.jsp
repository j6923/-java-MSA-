<%@page import = "java.text.SimpleDateFormat" %>
<%@page import ="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>session.jsp</title>
</head>
<body>
����ID: <%=session.getId() %><br>
���� IS NEW : <%=session.isNew() %><br>
���� �������ð�: <%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(session.getLastAccessedTime())) %>
</body>
</html>