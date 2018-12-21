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
	VehiculesEntity vehicule = (VehiculesEntity) request.getAttribute("vehicule_id");
	System.out.println(vehicule);
%>
</head>
<body>

<h2>Detail du vehicule : <%=vehicule.getName()%></h2>


	<ul>
		<li>Nom du vehicule: <%=vehicule.getName()%></li>

		<li>Prix du vehicule: <%=vehicule.getPrice()%></li>
		
		<li>Quantite du vehicule: <%=vehicule.getQuantity()%></li>
		
		<li><%=vehicule.getType().getName()%></li>
		
		<%
		String test = new String();
		List<OptionsEntity> options = vehicule.getOption();
		for (int j = 0; j < options.size(); j++) {
		%>
		
			<% test=options.get(j).getName()+","; 
			%>
			
	<%
		}
	%>
		<li><%= test %></li>


<a href="/Interface_Web/Cart_Servlet?user_id=1&vehicule_id=7"> Ajouter au panier</a>


</ul>




</body>
</html>