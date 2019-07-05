<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Utilisateur"%>

<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<fmt:setBundle basename="messages"/>

<%
	Utilisateur utilisateur = (Utilisateur) request.getAttribute("compteUtilisateur");
%>
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2><fmt:message key="user.title.manage" /> <%= utilisateur.getPrenom()%>&nbsp;<%= utilisateur.getNom()  %></h2>
			</div>
			<div class="content">
				<form method='get' action='AdminServlet?action=modifierUtilisateur'>
							<input hidden name="action" value="modifierUtilisateur">
							<input hidden name="id" value="<%= utilisateur.getId()%>">
							<input hidden name="idProfil" value="<%= utilisateur.getIdProfil()%>">
						
						
							<label><fmt:message key="user.table.nom" /></label>
							<input type='text' name='nom' value="<%= utilisateur.getNom() %>" />
							
							<label><fmt:message key="user.table.prenom" /></label>
							<input type='text' name='prenom' value="<%= utilisateur.getPrenom() %>" required />
							
							<label><fmt:message key="user.table.email" /></label>
							<input type='text' name='email' value="<%= utilisateur.getMail() %>"  required />
							
							<label><fmt:message key="user.table.login" /></label>
							<input type='text' name='login' value="<%= utilisateur.getLogin() %>"  />
							
							<label><fmt:message key="user.table.mdp" /> :</label>
							<input type='text' name='password' value="<%= utilisateur.getPassword() %>"  required />
							
							
							<input type='submit' name='submit' value="Modifier">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />