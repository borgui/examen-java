<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Utilisateur"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Gérer compte vendeurs</h2>
				<%
					List<Utilisateur> compteVendeurList = (List<Utilisateur>) request.getAttribute( "listeCompteVendeur" );
	
					if (compteVendeurList.size() == 0) {
				%>
				<p>Il n'y a aucun compte vendeur</p>
				<%
					} else {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nom</th>
							<th scope="col">Prenom</th>
							
						</tr>
					</thead>
					<tbody>
						<%
							for(Utilisateur compteVendeur : compteVendeurList){
						%>
						<tr>
							<th scope="row"><%= compteVendeur.getId() %></a></th>
							<td><%= compteVendeur.getPrenom() %></td>
							<td><%= compteVendeur.getNom() %></td>
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