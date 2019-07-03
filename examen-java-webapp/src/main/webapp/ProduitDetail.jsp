<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Produit"%>
<%@ page import="webservice.Entrepot"%>
<%@ page import="webservice.Categorie"%>


<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />

<%
	Produit produit = (Produit) request.getAttribute("produit");
	List<Entrepot> entrepots = (List<Entrepot>) request.getAttribute("listeEntrepot");
	List<Categorie> categories = (List<Categorie>) request.getAttribute("listeCategorie");

%>
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Gérer produit</h2>
			</div>
			<div class="content">
			<div><%produit.getId(); %></div>
				<form method='get' action='ProduitServlet?action=modifierProduit'>
							<input hidden name="action" value="modifierProduit">
							<input hidden name="id" value="<%= produit.getId()%>">
						
							<label>Nom</label>
							<input type='text' name='nom' value="<%= produit.getNom() %>" required/>
							
							<label>Description</label>
							<input type='text' name='description' value="<%= produit.getDescription() %>" required />
							
							<label>Prix</label>
							<input type='text' name='prix' value="<%= produit.getPrix() %>"  required />
							
							<label>Stock</label>
							<input type='text' name='stock' value="<%= produit.getStock() %>"  required/>
							
							<label>Categorie :</label>
							<select name="idCategorie" id="categorie" required>
							    <%for(Categorie categorie : categories){ %>
							    <option value="<%= categorie.getId() %>"><%= categorie.getLibelle() %></option>
							    <% } %>
							</select>							
							
							<label>Entrepot :</label>
							<select name="idEntrepot" id="entrepot" required>
							    <%for(Entrepot entrepot : entrepots){ %>
							    <option value="<%= entrepot.getId() %>"><%= entrepot.getNom() %></option>
							    <% } %>
							</select>							
							
							<input type='submit' name='submit' value="Modifier">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />