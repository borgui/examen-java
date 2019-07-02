<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Utilisateur"%>

<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />

<%
	Utilisateur vendeur = (Utilisateur) request.getAttribute("compteVendeur");
%>
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Gérer compte vendeur</h2>
			</div>
			<div class="content">
			<div><%vendeur.getId(); %></div>
				<form method='get' action='AdminServlet?action=modifierVendeur'>
							<input hidden name="action" value="modifierVendeur">
							<input hidden name="id" value="<%= vendeur.getId()%>">
						
							<label>Nom</label>
							<input type='text' name='nom' value="<%= vendeur.getNom() %>" />
							
							<label>Prenom</label>
							<input type='text' name='prenom' value="<%= vendeur.getPrenom() %>" required />
							
							<label>Email</label>
							<input type='text' name='email' value="<%= vendeur.getMail() %>"  required />
							
							<label>Pseudo</label>
							<input type='text' name='login' value="<%= vendeur.getLogin() %>"  />
							
							<label>Password :</label>
							<input type='text' name='password' value="<%= vendeur.getPassword() %>"  required />
							
							
							<input type='submit' name='submit' value="Modifier">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />