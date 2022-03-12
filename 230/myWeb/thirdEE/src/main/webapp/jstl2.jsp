<%@page import="java.util.ArrayList"%>
<%@page import="com.my.customer.vo.Customer" %>
<%@page import="java.util.List" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl.jsp</title>
</head>
<body>
<h1>JspStandardTagLib</h1>
EL기반의 조건문,반복문처리가능
jstl용 library설치(프로젝트경로 WEB-INF\lib)되어야함
<hr>
<%--
String opt = request.getParameter("opt");
if(opt == null || opt.equals("")){
  out.print("작업을 선택하세요");
}
 --%>
<c:if test="${empty param.opt }">작업을 선택하세요</c:if>

<%--
if(opt.equals("add")){
}else if(opt.equals("list")){
}else if(opt.equals("modify")){
}else if(opt.equals("remove")){
}--%>
<hr>
<c:choose>
	<c:when test="${param.opt == 'add'}">추가작업을 선택했습니다
	</c:when>
	<c:when test="${param.opt == 'list'}">목록작업을 선택했습니다
	</c:when>
	<c:when test="${param.opt == 'modify' }">수정작업을 선택했습니다
	</c:when>
	<c:when test="${param.opt == 'remove' }">삭제작업을 선택했습니다
	</c:when>
	<c:otherwise>작업을 선택하세요
	</c:otherwise>
</c:choose>

<%
List<Customer>list = new ArrayList<>();
list.add(new Customer("id1", "p1", "n1", null));
list.add(new Customer("id2", "p2", "n2", null));
list.add(new Customer("id3", "p3", "n3", null));
list.add(new Customer("id4", "p4", "n4", null));
list.add(new Customer("id5", "p5", "n5", null));
request.setAttribute("list",list);
%>
<%--
List<Customer>list = (List)request.getAttribute("list");
for(Customer c:list){
	out.print(c.getId());
}
 --%>
<table>
<tr><th>번호(index:count)</th><th>아이디</th><th>이름</th></tr>
<c:forEach items = "${requestScope.list}" var="c" varStatus="status">
<tr>
<td>${status.index}:${status.count}</td>
$(c.id) $(c.name)<br></td>
</tr>
</c:forEach>
</table>
<c:forEach begin="1" end="7" var="i">
${i},
</c:forEach>

<c:forEach begin="1" end="7" var="i">
<c:if test="${ i>1}">, </c:if>
${i}
</c:forEach>
</body>
</html>