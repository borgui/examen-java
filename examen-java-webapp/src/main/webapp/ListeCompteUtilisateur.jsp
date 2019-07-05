<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Utilisateur"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<fmt:setBundle basename="messages"/>

<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<%Integer idProfil = (Integer) request.getAttribute("idProfil"); %>
				<h2><fmt:message key="user.title" /> <%if(idProfil == 1){ %>clients <%} else { %>vendeurs <%} %></h2>
				<%
					List<Utilisateur> compteUtilisateurList = (List<Utilisateur>) request.getAttribute( "listeCompteUtilisateur" );
	
					if (compteUtilisateurList == null) {
				%>
				<p><fmt:message key="user.err.notfound" /></p>
				<%
					} else {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col"><fmt:message key="user.table.nom" /></th>
							<th scope="col"><fmt:message key="user.table.prenom" /></th>
							<th scope="col"><fmt:message key="user.table.modifier" /></th>
							<th scope="col"><fmt:message key="user.table.supprimer" /></th>
							<th scope="col"><fmt:message key="user.table.susdeb" /></th>
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
							<td><a href="AdminServlet?action=getUtilisateurDetail&id=<%=compteUtilisateur.getId()%>"><fmt:message key="user.table.modifier" /></a></td>
							<td><a href="AdminServlet?action=supprimerUtilisateur&id=<%=compteUtilisateur.getId()%>&idProfil=<%=idProfil%>"><fmt:message key="user.table.supprimer" /> </a></td>
							<%
								if (compteUtilisateur.isSuspended() == false) {
							%>
							<td><a href="AdminServlet?action=suspendreDebloqUser&id=<%=compteUtilisateur.getId()%>"><fmt:message key="user.table.suspendre" /></a></td>
							<%
								}
								else
								{
							%>
							<td><a href="AdminServlet?action=suspendreDebloqUser&id=<%=compteUtilisateur.getId()%>"><fmt:message key="user.table.debloquer" /></a></td>
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
							
							<label><fmt:message key="user.table.nom" /></label>
							<input type='text' name='nom' required />
							
							<label><fmt:message key="user.table.prenom" /></label>
							<input type='text' name='prenom' required />
							
							<label><fmt:message key="user.table.email" /></label>
							<input type='text' name='email' required />
							
							<label><fmt:message key="user.table.login" /></label>
							<input type='text' name='login' required />
							
							<label><fmt:message key="user.table.mdp" /> :</label>
							<input type='password' name='password' required />
							
							
							<input type='submit' name='submit' value="Ajouter">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />