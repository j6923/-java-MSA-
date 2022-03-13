<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>include.jsp</title>
<meta charset="UTF-8">

<link rel="stylesheet" href="../css/index.css">   
</head>
<body>
<h1>include directive</h1>
<%@ include file="a.jsp"%><%--jsp용 .java파일이 generate될 때 _jspService()내부에 a.jsp의 내용이 out.write()인자로 모두 포함됨 --%>

<hr>
<h1>include tag</h1>
<jsp:include page="a.jsp"></jsp:include>

</body>
</html>