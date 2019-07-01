<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="java.util.List" %>
<%@ page import="webservice.AccuseReception" %>
<core:import url="Header.jsp" />

			<div id="main-wrapper">
				<div class="container">
					<div id="content">
							<%
							if (request.getAttribute("detailsAccuseReception") != null) {
								AccuseReception accuseReception = (AccuseReception) request.getAttribute("detailsAccuseReception");
							%>
								<h3>Accusé réception</h3>
								<label>Date</label>
								<p><%= accuseReception.getDate() %></p>
								<label>Numéro de commande</label>
								<p><%= accuseReception.getIdCommande() %></p>
								<label>Numéro de livraison</label>
								<p><%= accuseReception.getIdLivraison() %></p>
							<%
								}
							%>
					</div>
				</div>
			</div>

<core:import url="Footer.jsp" />