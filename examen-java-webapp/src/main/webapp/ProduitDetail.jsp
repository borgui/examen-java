<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Produit"%>
<%@ page import="webservice.Entrepot"%>
<%@ page import="webservice.Categorie"%>


<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<fmt:setBundle basename="messages"/> 

<%
	Produit produit = (Produit) request.getAttribute("produit");
	List<Entrepot> entrepots = (List<Entrepot>) request.getAttribute("listeEntrepot");
	List<Categorie> categories = (List<Categorie>) request.getAttribute("listeCategorie");

%>
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2><fmt:message key="produit.title.manage" /></h2>
			</div>
			<div class="content">
			<div><%produit.getId(); %></div>
				<form method='get' action='ProduitServlet?action=modifierProduit'>
							<input hidden name="action" value="modifierProduit">
							<input hidden name="id" value="<%= produit.getId()%>">
						
							<label><fmt:message key="produit.table.nom" /></label>
							<input type='text' name='nom' value="<%= produit.getNom() %>" required/>
							
							<label><fmt:message key="produit.table.description" /></label>
							<input type='text' name='description' value="<%= produit.getDescription() %>" required />
							
							<label>URL Image</label>
							<input type='text' name='image' value="<%= produit.getImage() %>" required />
							
							<label><fmt:message key="produit.table.prix" /></label>
							<input type='text' name='prix' value="<%= produit.getPrix() %>"  required />
							
							<label><fmt:message key="produit.table.stock" /></label>
							<input type='text' name='stock' value="<%= produit.getStock() %>"  required/>
							
							<label><fmt:message key="produit.table.categorie" /> :</label>
							<select name="idCategorie" id="categorie" required>
							    <%for(Categorie categorie : categories){ %>
							    <option value="<%= categorie.getId() %>"><%= categorie.getLibelle() %></option>
							    <% } %>
							</select>							
							
							<label><fmt:message key="produit.table.entrepot" /> :</label>
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