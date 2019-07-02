<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Entrepot"%>

<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />

<%
	Entrepot entrepot = (Entrepot) request.getAttribute("entrepot");
%>
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Gérer entrepot</h2>
			</div>
			<div class="content">
				<form method='get' action='EntrepotServlet?action=modifierEntrepot'>
							<input hidden name="action" value="modifierEntrepot">
							<input hidden name="id" value="<%= entrepot.getId()%>">
						
							<label>Nom</label>
							<input type='text' name='nom' value="<%= entrepot.getNom() %>" />
							
							<label>Pays</label>
							<input type='text' name='pays' value="<%= entrepot.getPays() %>" required />
							
							
							<input type='submit' name='submit' value="Modifier">
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />