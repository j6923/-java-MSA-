<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileInputStream"%>
<%@page errorPage = "err.jsp" %> <%--현재 jsp에서 예외발생하면 그 즉시 버퍼clear, err.jsp로 forward하라 --%>
<%@page buffer = "1024kb" %><%--버퍼크기 조정 8kb가 기본이다.--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pagedirective.jsp</title>
</head>
<body>
<%--1~99999반복하여 값 출력 --%>

<%
for(int i=1; i<=99999;i++){//버퍼가 꽉 차게 됨. 
	%><%=i %>	
<%
}
%>
<%--a.txt파일 읽기 --%>
<%--<%
FileInputStream fis;
fis = new FileInputStream("a.txt");
--%> 
<%--두번째 방법 : 버퍼 크게 해놓고 예외 보이지만 정상 부분 아닌 것 모호하다. --%>
<%--<%
FileInputStream fis;
try{
	fis = new FileInputStream("a.txt");
}catch(FileNotFoundException e){
	out.print("a.txt파일이 없습니다. 관리자에게 문의하세요.");
}

--%>

<%--세번째 방법 : 정상처리 되다가 예외 발생했다는 정상 처리 다른 페이지로 알린다 권장사항 --%>

<%---<%
FileInputStream fis;
try{
	fis = new FileInputStream("a.txt");
}catch(FileNotFoundException e){
	
	request.setAttribute("e", e);
	RequestDispatcher rd = request.getRequestDispatcher("err.jsp");
	rd.forward(request, response);
}--%>

<%FileInputStream fis;
fis = new FileInputStream("a.txt");
%>


</body>
</html>