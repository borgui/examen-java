<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />

<%@ page import="java.util.List" %>
<%@ page import="webservice.Facture" %>
<!-- Contenu partiel -->
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div id="content">
				<h2>Factures</h2>
				<%
					List<Facture> factures = (List<Facture>) request.getAttribute( "listeFactures" );
					
					if (factures.size() != 0) {
					%>
					<table class="table table-striped">
					  <thead>
					    <tr>
					    	<th scope="col">Numéro</th>
					      	<th scope="col">Date</th>
					      	<th scope="col">Numéro de commande</th>
					      	<%
								if(session.getAttribute("session-role") == "comptable"){
							%>
							<th scope="col">Ajouter un paiement</th>
							<%
								}
							%>
					    </tr>
					  </thead>
					  <tbody>
					<%
		            for(Facture facture : factures){
		            	%>	 
					    <tr>
					      <td><a href='ControllerServlet?action=detailsFacture&idFacture=<%= facture.getId() %>' ><%= facture.getId() %></a></td>
					      <td><%= facture.getDate() %></td>
					      <td><%= facture.getIdCommande() %></td>
					      <%
								if(session.getAttribute("session-role") == "comptable"){
							%>
							<th scope="col"><a href="ControllerServlet?action=ajoutPaiement&idFacture=<%= facture.getId() %>"><img alt="ajout_icon" src="images/icon_add.png"></a></th>
							<%
								}
							%>
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
