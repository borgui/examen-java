<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Entrepot"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Gérer entrepot</h2>
				<%
					List<Entrepot> entrepotList = (List<Entrepot>) request.getAttribute( "listeEntrepot" );
	
					if (entrepotList == null) {
				%>
				<p>Il n'y a aucun entrepot</p>
				<%
					} else {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nom</th>
							<th scope="col">Pays</th>
							<th scope="col">Modifier</th>
							<th scope="col">Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(Entrepot entrepot : entrepotList){
						%>
						<tr>
							<th scope="row"><%= entrepot.getId() %></a></th>
							<td><%= entrepot.getNom() %></td>
							<td><%= entrepot.getPays() %></td>
							<td><a href="EntrepotServlet?action=getEntrepotDetail&id=<%=entrepot.getId()%>">Modifier</a></td>
							<td><a href="EntrepotServlet?action=supprimerEntrepot&id=<%=entrepot.getId()%>">Supprimer </a></td>
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
				<form method='get' action='EntrepotServlet'>
							<input hidden name="action" value="ajoutEntrepot">
							<label>Nom</label>
							<input type='text' name='nom' required />
							
							<label>Pays</label>
							<input type='text' name='pays' required />
							
							<input type='submit' name='submit' value="Ajouter">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />