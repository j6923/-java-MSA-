<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int i;  //스크리브로 i 변수 선언 
i = 10; 
i++;
%>

지역변수 i값: <%out.print(i);%>,
<%=i %>
<hr>
<%!int i; 
//메서드 밖에 선언 %>   
지역변수 i값: <%=i  %><%--0? 11? --%>

<br>
멤버변수 i값: <%=this.i %>   <%--변수 i의 값을 출력 page.i와는 다르다. --%>

</body>
</html>