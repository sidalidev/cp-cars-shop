<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%
	VehiculesEntity vehicule = (VehiculesEntity) request.getAttribute("vehicule_id");
	System.out.println(vehicule);
%>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Véhicule</title>
<link rel="stylesheet" href="assets/semantic-ui/semantic.min.css" />
</head>
<body>
	<div style="padding: 1em;">
		<h1>
			Details du véhicule :
			<%=vehicule.getName()%></h1>



		<li>Type: <%=vehicule.getType().getName()%></li> Options:

		<div class="ui card">
			<div class="image">
				<img src="assets/images/vehicules/car.jpg">
			</div>
			<div class="content">
				<div class="header">
					<%=vehicule.getName()%></div>
				<div class="meta">
					<a><%=vehicule.getPrice()%>&euro;</a>
				</div>
				<div class="description">
					<p>
						Quantite:
						<%=vehicule.getQuantity()%>

					</p>
					<ul>
						<%
							String option = new String();
							List<OptionsEntity> options = vehicule.getOption();
							for (int j = 0; j < options.size(); j++) {
						%>
						<%
							option = options.get(j).getName() + ",";
						%>
						<li><%=option%></li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
			<div class="extra content">
				<span class="right floated"> <a
					href="/Interface_Web/Cart_Servlet?user_id=1&vehicule_id=7">
						Ajouter au panier</a>
				</span> <span> <i class="user icon"></i>
				</span>
			</div>
		</div>

	</div>
</body>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="assets/semantic-ui/semantic.min.js"></script>
</html>