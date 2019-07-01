<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Paiement"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Liste des Paiements</h2>
				<%
					List<Paiement> paiementsList = (List<Paiement>) request.getAttribute( "listePaiements" );
	
					if (paiementsList.size() == 0) {
				%>
				<p>Il n'y a aucun paiement</p>
				<%
					} else {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Date</th>
							<th scope="col">Id de la commande</th>
							<th scope="col">Id de la facture</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(Paiement paiement : paiementsList){
						%>
						<tr>
							<th scope="row"><%= paiement.getId() %></a></th>
							<td><%= paiement.getDate().toString() %></td>
							<td><a href="ControllerServlet?action=commandeDetail&idCommande=<%= paiement.getIdCommande() %>"><%= paiement.getIdCommande() %></td>
							<td><a href="ControllerServlet?action=detailsFacture&idFacture=<%= paiement.getIdFacture() %>"><%= paiement.getIdFacture() %></td>
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