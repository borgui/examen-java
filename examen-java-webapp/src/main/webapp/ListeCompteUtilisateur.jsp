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
				<%Integer idProfil = (Integer) request.getAttribute("idProfil"); %>
				<h2>Gérer comptes <%if(idProfil == 1){ %>clients <%} else { %>vendeurs <%} %></h2>
				<%
					List<Utilisateur> compteUtilisateurList = (List<Utilisateur>) request.getAttribute( "listeCompteUtilisateur" );
	
					if (compteUtilisateurList == null) {
				%>
				<p>Il n'y a aucun compte</p>
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
							<th scope="col">Suspendre/ Débloquer</th>
						</tr>
					</thead>
					<tbody>
						<%
							for(Utilisateur compteUtilisateur : compteUtilisateurList){
						%>
						<tr>
							<th scope="row"><%= compteUtilisateur.getId() %></a></th>
							<td><%= compteUtilisateur.getPrenom() %></td>
							<td><%= compteUtilisateur.getNom() %></td>
							<td><a href="AdminServlet?action=getUtilisateurDetail&id=<%=compteUtilisateur.getId()%>">Modifier</a></td>
							<td><a href="AdminServlet?action=supprimerUtilisateur&id=<%=compteUtilisateur.getId()%>&idProfil=<%=idProfil%>">Supprimer </a></td>
							<%
								if (compteUtilisateur.isSuspended() == false) {
							%>
							<td><a href="AdminServlet?action=suspendreDebloqUser&id=<%=compteUtilisateur.getId()%>">Suspendre</a></td>
							<%
								}
								else
								{
							%>
							<td><a href="AdminServlet?action=suspendreDebloqUser&id=<%=compteUtilisateur.getId()%>">Débloquer</a></td>
							<%
								}
							%>
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
				<form method='get' action='AdminServlet'>
							<input hidden name="action" value="ajouterUtilisateur">
							<input hidden name="idProfil" value="<%= idProfil %>">
							
							<label>Nom</label>
							<input type='text' name='nom' required />
							
							<label>Prenom</label>
							<input type='text' name='prenom' required />
							
							<label>Email</label>
							<input type='text' name='email' required />
							
							<label>Pseudo</label>
							<input type='text' name='login' required />
							
							<label>Password :</label>
							<input type='password' name='password' required />
							
							
							<input type='submit' name='submit' value="Ajouter">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />