<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>score.jsp</title>
</head>
<body>
<%!int totalScore;//0으로 자동 초기화  //총점  
	int totalCnt;  //인원수
	DecimalFormat df = new DecimalFormat("#.0"); //클래스 뒤에 커서 class ctrl space bar;소수점 한자리까지 표현 
	%>
<%
String score = request.getParameter("score");
int scoreNum = Integer.parseInt(score); //영화 총점이 누적이 되어야 하므로 별점 5점이나 1점은 숫자로 변환을 햐야 총점에 누적되고 총점이 평점으로 계산이 된다. 
//int totalScore = 0;
totalScore += scoreNum;
totalCnt++; 
float avgScore= (float)totalScore/totalCnt; //(float))11/4=>2.XX 
%>
선택하신 별점은<%=scoreNum%> 점입니다<br>
영화 총점은 <%=totalScore %> 점입니다. <br>
참여한 인원수는<%=totalCnt%> 명입니다. 
<hr>
영화 평점은<%=df.format(avgScore)%> 점입니다
</body>
</html>