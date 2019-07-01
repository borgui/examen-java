<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />

<%@ page import="java.util.List" %>
<%@ page import="webservice.AccuseReception" %>
<!-- Contenu partiel -->
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div id="content">
				<h2>Accusés réceptions</h2>
				<%
					List<AccuseReception> accusesReceptions = (List<AccuseReception>) request.getAttribute( "listeAccusesReceptions" );
					
					if (accusesReceptions.size() != 0) {
					%>
					<table class="table table-striped">
					  <thead>
					    <tr>
					    	<th scope="col">Numéro</th>
					      	<th scope="col">Date</th>
					      	<th scope="col">Numéro de commande</th>
					      	<th scope="col">Numéro de livraison</th>
					    </tr>
					  </thead>
					  <tbody>
					<%
		            for(AccuseReception accuseReception : accusesReceptions){
		            	%>	 
					    <tr>
					      <td><a href='ControllerServlet?action=detailsAccuseReception&idAccuseReception=<%= accuseReception.getId() %>' ><%= accuseReception.getId() %></a></td>
					      <td><%= accuseReception.getDate() %></td>
					      <td><%= accuseReception.getIdCommande() %></td>
					      <td><%= accuseReception.getIdLivraison() %></td>
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