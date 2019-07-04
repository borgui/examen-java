<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Commande"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<fmt:setBundle basename="messages"/>
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2><fmt:message key="commande.title" /></h2>
				<%
					List<Commande> commandeList = (List<Commande>) request.getAttribute( "listeCommande" );
	
					if (commandeList == null) {
				%>
				<p><fmt:message key="commande.err.notfound" /></p>
				<%
					} else {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col"><fmt:message key="commande.date" /></th>
							<th scope="col"><fmt:message key="commande.status" /></th>
						</tr>
					</thead>
					<tbody>
						<%
							for(Commande commande : commandeList){
						%>
						<tr>
							<th scope="row"><%= commande.getId() %></a></th>
							<td><%= commande.getDate() %></td>
							<td><%= commande.getStatus().getLibelle() %></td>
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
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />