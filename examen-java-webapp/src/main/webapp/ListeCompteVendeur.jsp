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
	
					if (compteVendeurList == null) {
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
							<th scope="col">Modifier</th>
							<th scope="col">Supprimer</th>
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
							<td><a href="AdminServlet?action=getVendeurDetail&id=<%=compteVendeur.getId()%>">Modifier</a></td>
							<td>Supprimer</td>
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
			<div class="content">
				<form method='get' action='AdminServlet?action=ajoutVendeur'>
							<input hidden name="action" value="ajoutVendeur">
							<label>Nom</label>
							<input type='text' name='nom' required />
							
							<label>Prenom</label>
							<input type='text' name='prenom' required />
							
							<label>Email</label>
							<input type='text' name='email' required />
							
							<label>Pseudo</label>
							<input type='text' name='login' required />
							
							<label>Password :</label>
							<input type='text' name='password' required />
							
							
							<input type='submit' name='submit' value="Ajouter">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />