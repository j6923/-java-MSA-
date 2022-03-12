<%@page import="com.my.customer.vo.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul>
<%Customer c = (Customer)session.getAttribute("loginInfo"); 
if(c==null){//로그인 안도니 경우 
	%>
    <li><a href="./html/login.html">로그인</a></li>
    <li><a href="./html/signup.html">가입</a></li>
<%
}else{
%><li><%=c.getName()%>님 반갑습니다.<a href = "logout">로그아웃</a></li>
<%
}
%>
    <li><a href="productlist">상품</a></li>
    <li><a href="cartlist">장바구니</a></li>
<%
if(c!=null){//로그인이 된 경우 
%>

     <li><a href="orderlist">주문목록</a></li>
<%
}
%>
</ul>