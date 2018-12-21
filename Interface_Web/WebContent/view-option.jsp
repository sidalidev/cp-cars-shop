<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="entities.*" %> 
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Options</title>




<%
@SuppressWarnings("unchecked")
List<OptionsEntity> options = (List<OptionsEntity>) request.getAttribute("option");

	%>
</head>
<body>
<%
				for (int i = 0; i < options.size(); i++) {
			%>
			
       <h5> <%=options.get(i).getName()%></h5>
       
       <%
				}
			%>
</body>		
</html>