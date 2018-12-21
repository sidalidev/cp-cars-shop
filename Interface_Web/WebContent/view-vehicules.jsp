<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>


<%
	List<VehiculesEntity> vehicule = (List<VehiculesEntity>) request.getAttribute("vehicule");
%>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Liste des véhicules</title>
<link rel="stylesheet" href="assets/semantic-ui/semantic.min.css" />
</head>
<body>
	<div style="padding: 1em;">
		<h1>Liste des véhicules</h1>
		<div class="ui divided items">


			<%
				for (int i = 0; i < vehicule.size(); i++) {
			%>

			<div class="item">
				<div class="ui small image">
					<img src="assets/images/vehicules/car.jpg">
				</div>
				<div class="content">
					<div class="header"><%=vehicule.get(i).getName()%></div>
					<div class="meta">
						<span class="price">Prix: <%=vehicule.get(i).getPrice()%>
							&euro;
						</span><br> <span class="stay">Quantite: <%=vehicule.get(i).getQuantity()%></span><br>
						<span class="stay">Type: <%=vehicule.get(i).getType().getName()%></span>
					</div>
					<div class="description">
						<h3>Options</h3>
						<p>

							<%
								String test = new String();
									List<OptionsEntity> options = vehicule.get(i).getOption();
									for (int j = 0; j < options.size(); j++) {
							%>
							<%
								test = options.get(j).getName() + ",";
										System.out.println(test);
							%>
							<%
								}
							%>
							<%=test%>

							<%
								String url = new String();
									url = "/Interface_Web/Vehicule_Servlet?id=" + vehicule.get(i).getId();
							%>
							<br>
							<a href=<%=url%>>Voir plus</a>
						</p>
					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="assets/semantic-ui/semantic.min.js"></script>
</html>