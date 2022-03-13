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
세션ID: <%=session.getId() %><br>
세션 IS NEW : <%=session.isNew() %><br>
세션 최종사용시간: <%=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(session.getLastAccessedTime())) %>
</body>
</html>