<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="java.util.List" %>
<%@ page import="webservice.Livraison" %>
<core:import url="Header.jsp" />

			<div id="main-wrapper">
				<div class="container">
					<div id="content">
							<%
							if (request.getAttribute("detailsLivraison") != null) {
								Livraison livraison = (Livraison) request.getAttribute("detailsLivraison");
							%>
								<h3>Livraison</h3>
								<label>Date</label>
								<p><%= livraison.getDate() %></p>
								<label>Numéro de commande</label>
								<p><%= livraison.getIdCommande() %></p>
								<label>Numéro d'état</label>
								<p><%= livraison.getIdEtatLivraison() %></p>
							<%
								}
							%>
					</div>
				</div>
			</div>

<core:import url="Footer.jsp" />