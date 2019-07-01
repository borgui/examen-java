<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="java.util.List" %>
<%@ page import="webservice.Facture" %>
<core:import url="Header.jsp" />

			<div id="main-wrapper">
				<div class="container">
					<div id="content">
							<%
							if (request.getAttribute("detailsFacture") != null) {
								Facture facture = (Facture) request.getAttribute("detailsFacture");
							%>
								<h3>Facture</h3>
								<label>Date</label>
								<p><%= facture.getDate() %></p>
								<label>Numéro de commande</label>
								<p><%= facture.getIdCommande() %></p>
							<%
								}
							%>
					</div>
				</div>
			</div>

<core:import url="Footer.jsp" />