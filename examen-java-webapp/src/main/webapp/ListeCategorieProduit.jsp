<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Categorie"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Gérer catégorie produit</h2>
				<%
					List<Categorie> categorieList = (List<Categorie>) request.getAttribute( "listeCategorie" );
	
					if (categorieList == null) {
				%>
				<p>Il n'y a aucune categorie</p>
				<%
					} else {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Libelle</th>
							<th scope="col">Modifier</th>
							<th scope="col">Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(Categorie categorie : categorieList){
						%>
						<tr>
							<th scope="row"><%= categorie.getId() %></a></th>
							<td><%= categorie.getLibelle() %></td>
							<td><a href="CategorieServlet?action=getCategorieDetaill&id=<%=categorie.getId()%>">Modifier</a></td>
							<td><a href="CategorieServlet?action=supprimerCategorie&id=<%=categorie.getId()%>">Supprimer </a></td>
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
				<form method='get' action='CategorieServlet'>
							<input hidden name="action" value="ajouterCategorie">
							<label>Libelle</label>
							<input type='text' name='libelle' required />
							<input type='submit' name='submit' value="Ajouter">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />