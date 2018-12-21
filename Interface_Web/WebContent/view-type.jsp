<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Options</title>




<%
	List<TypeEntity> type2 = (List<TypeEntity>) request.getAttribute("type");
	System.out.println(type2);
%>
</head>
<body>
	<%
		for (int i = 0; i < type2.size(); i++) {
	%>

	<h5>
		<%=type2.get(i).getName()%></h5>

	<%
		}
	%>


</body>
</html>