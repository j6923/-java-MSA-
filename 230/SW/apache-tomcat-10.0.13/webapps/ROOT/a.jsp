<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송결과</title>
</head>
<body>
보내준 text값:<%=request.getParameter("t") %><br>
보내준 password값:<%=request.getParameter("p") %><br>
보내준 checkbox들값:
<%String[]tArr = request.getParameterValues("c");
  if(tArr != null){
	  for(String t: tArr){
		out.print(t);
		out.print(",");
	  }
	  out.print("<br>");
  }
%>
보내준 radio값:<%=request.getParameter("r") %>
<br>
보내준 hidden값:<%=request.getParameter("h") %><br>
보내준 textarea값:<%=request.getParameter("ta") %><br>

</body>
</html>