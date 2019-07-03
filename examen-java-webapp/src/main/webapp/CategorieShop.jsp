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
				<h2> Catégories de produit</h2>
				<%
					List<Categorie> categorieList = (List<Categorie>) request.getAttribute( "listeCategorie" );
	
					if (categorieList == null) {
				%>
				<p>Il n'y a aucune categorie</p>
				<%
					} else {
				%>
				<div class="row">
						<%
							for(Categorie categorie : categorieList){
						%>
						<div class="col-3">
						<a href="ProduitServlet?action=getProduitCategorie&categorieId=<%= categorie.getId()%>" class="btn btn-primary"><%= categorie.getLibelle() %></a>
						</div>
						<%
							}
						%>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />