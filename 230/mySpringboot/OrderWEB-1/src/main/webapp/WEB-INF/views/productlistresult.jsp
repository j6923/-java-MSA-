<%@page import="com.example.demo.product.vo.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<Product> list = 
    (List)request.getAttribute("list");
%>   
<link rel="stylesheet" href="./css/productlist.css">
<script src="./js/productlist.js"></script>
<script>
$(function(){
	/*--상품상세클릭 start--*/
	productDetail();
	/*--상품상세클릭 end--*/
});
</script>
<%--<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productlistresult.jsp</title>
 --%>
	
   
    <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->
    
    
<%-- </head>
<body> --%>
<div class="productlist">
<%for(Product p: list){ 
	String prodNo = p.getProdNo();
	String prodName = p.getProdName();
	//int prodPrice = p.getProdPrice();
%>
    <div id="<%=prodNo%>"><!--상품1개-->
        <ul>
            <li><img src="./images/<%=prodNo%>.jpg" alt="<%=prodName%>"></li>
            <li><span><%=prodName%></span></li>
        </ul>
    </div>
<%} %>    
</div>
<%--</body>
</html>
 --%>