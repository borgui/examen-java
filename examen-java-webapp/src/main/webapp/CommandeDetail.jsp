<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />
<%@ page import="java.util.List" %>
<%@ page import="webservice.Commande"%>
<%@ page import="webservice.Fournisseur"%>

<div  class="gestion-commande">
	<div class="container">
		<div id="content">
			<%-- <%
			if (request.getParameter("action") == "commandeDetail") {
			%>	 --%>
				<%
				if (request.getAttribute("commande") != null) {
					Commande commande = (Commande) request.getAttribute("commande");
				%>
				<h2 class="info-perso">Détails de la commande</h2>
				<div id="content">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Date</th>
								<th scope="col">Produit</th>
								<th scope="col">Quantité</th>
								<th scope="col">Prix</th>
								<th scope="col">Nom fournisseur</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row"><%= commande.getId() %></th>
								<td><%= commande.getDate().toString() %></td>
								<td><%= commande.getProduit() %></td>
								<td><%= commande.getQuantite() %></td>
								<td><%= commande.getPrix() %></td>
								<td><%= request.getAttribute("fournisseur") %></td>
							</tr>
						</tbody>
					</table>
					<%-- <a href="ControllerServlet?action=editCommande&idCommande=<%= commande.getId() %>">Modifier</a> --%>
				<%
				} else {
					%>
					<%
					if(request.getAttribute("listeFournisseurs") != null){
						List<Fournisseur> listeFournisseurs = (List<Fournisseur>) request.getAttribute("listeFournisseurs");
					%>
						<form method='get' action='ControllerServlet'>
							<input type="hidden" name="action" value="ajouterCommande">
							
							<label>Produit</label>
							<input type='text' name='produit' required />
							
							<label>Quantité</label>
							<input type='text' name='quantite' required />
							
							<label>Prix</label>
							<input type='text' name='prix' required />
							
							<label>Fournisseur :</label>
							<select name="fournisseurSelect">
								<%
								for(Fournisseur fournisseur : listeFournisseurs){
									%> 
									<option value="<%= fournisseur.getId() %>"><%= fournisseur.getNom() %></option>
									<%
								}
								%>
							</select>
							
							<input type='submit' name='action' value="Ajouter">
						</form>
					<%
					}
					%>
				<%
				}
				%>
			</div>            
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />