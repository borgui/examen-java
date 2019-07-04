<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Produit"%>
<%@ page import="webservice.Entrepot"%>
<%@ page import="webservice.Categorie"%>

<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Gérer produit</h2>
				<%
					List<Produit> produitList = (List<Produit>) request.getAttribute( "listeProduit" );
				List<Entrepot> entrepots = (List<Entrepot>) request.getAttribute("listeEntrepot");
				List<Categorie> categories = (List<Categorie>) request.getAttribute("listeCategorie");
				
					if (produitList == null) {
				%>
				<p>Il n'y a aucun produit</p>
				<%
					} else {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nom</th>
							<th scope="col">Description</th>
							<th scope="col">Prix</th>
							<th scope="col">Stock</th>
							<th scope="col">Categorie</th>
							<th scope="col">Entrepot</th>
							
							
							

							<th scope="col">Modifier</th>
							<th scope="col">Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(Produit produit : produitList){
						%>
						<tr>
							<th scope="row"><%= produit.getId() %></a></th>
							<td><%= produit.getNom() %></td>
							<td><%= produit.getDescription() %></td>
							<td><%= produit.getPrix() %></td>
							<td><%= produit.getStock() %></td>
							<td><%= produit.getCategorie().getLibelle()%></td>
							<td><%= produit.getEntrepot().getNom()%></td>
							
							<td><a href="ProduitServlet?action=getProduitDetail&id=<%=produit.getId()%>">Modifier</a></td>
							<td><a href="ProduitServlet?action=supprimerProduit&id=<%=produit.getId()%>">Supprimer </a></td>
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
				<form method='get' action='ProduitServlet'>
							<input hidden name="action" value="ajouterProduit">
						
							<label>Nom</label>
							<input type='text' name='nom' required/>
							
							<label>Description</label>
							<input type='text' name='description' required />
							
							<label>URL Image</label>
							<input type='text' name='image' required />
							
							<label>Prix</label>
							<input type='text' name='prix' required />
							
							<label>Stock</label>
							<input type='text' name='stock'  required />
							
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
							
							<input type='submit' name='submit' value="Ajouter">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />