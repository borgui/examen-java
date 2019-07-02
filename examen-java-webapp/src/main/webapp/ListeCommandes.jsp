<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Commande"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Liste des commandes</h2>
				<%
				if (session.getAttribute("session-role") == "responsableAchat") {
				%>
					<div class="img-add-annonce"><a href="ControllerServlet?action=addCommande"><img alt="ajout_icon" src="images/icon_add.png"></a></div>
				<%
				}
				%>
				
				<%
					List<Commande> commandesList = (List<Commande>) request.getAttribute( "commandesList" );
					List<String> nomFournisseursList = (List<String>) request.getAttribute("fournisseursList");
	
					if (commandesList.size() == 0) {
				%>
				<p>Il n'y a aucune commande !</p>
				<%
					} else {
				%>
				<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
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
