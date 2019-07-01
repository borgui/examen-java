<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />

<%@ page import="java.util.List" %>
<%@ page import="webservice.Livraison" %>
<!-- Contenu partiel -->
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div id="content">
				<h2>Livraisons</h2>
				<%
					List<Livraison> livraisons = (List<Livraison>) request.getAttribute( "listeLivraisons" );
					
					if (livraisons.size() != 0) {
					%>
					<table class="table table-striped">
					  <thead>
					    <tr>
					    	<th scope="col">Numéro</th>
					      	<th scope="col">Date</th>
					      	<th scope="col">Numéro de commande</th>
					      	<th scope="col">Numéro d'état</th>
					    </tr>
					  </thead>
					  <tbody>
					<%
		            for(Livraison livraison : livraisons){
		            	%>	 
					    <tr>
					      <td><a href='ControllerServlet?action=detailsLivraison&idLivraison=<%= livraison.getId() %>' ><%= livraison.getId() %></a></td>
					      <td><%= livraison.getDate() %></td>
					      <td><%= livraison.getIdCommande() %></td>
					      <td><%= livraison.getIdEtatLivraison() %></td>
					    </tr>
					    <%
		            }
		            %>	
					  </tbody>
					</table>
					<%
					}
					%>
			</div>
		</div>
	</div>
</div>

<core:import url="Footer.jsp" />