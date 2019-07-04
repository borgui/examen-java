<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="webservice.Entrepot"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<fmt:setBundle basename="messages"/>
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2><fmt:message key="entrepot.title" /></h2>
				<%
					List<Entrepot> entrepotList = (List<Entrepot>) request.getAttribute( "listeEntrepot" );
	
					if (entrepotList == null) {
				%>
				<p><fmt:message key="entrepot.err.notfound" /></p>
				<%
					} else {
				%>
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col"><fmt:message key="entrepot.table.nom" /></th>
							<th scope="col"><fmt:message key="entrepot.table.pays" /></th>
							<th scope="col"><fmt:message key="entrepot.table.modifier" /></th>
							<th scope="col"><fmt:message key="entrepot.table.supprimer" /></th>
						</tr>
					</thead>
					<tbody>
						<%
							for(Entrepot entrepot : entrepotList){
						%>
						<tr>
							<th scope="row"><%= entrepot.getId() %></a></th>
							<td><%= entrepot.getNom() %></td>
							<td><%= entrepot.getPays() %></td>
							<td><a href="EntrepotServlet?action=getEntrepotDetail&id=<%=entrepot.getId()%>"><fmt:message key="entrepot.table.modifier" /></a></td>
							<td><a href="EntrepotServlet?action=supprimerEntrepot&id=<%=entrepot.getId()%>"><fmt:message key="entrepot.table.supprimer" /> </a></td>
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
				<form method='get' action='EntrepotServlet'>
							<input hidden name="action" value="ajoutEntrepot">
							<label><fmt:message key="entrepot.table.nom" /></label>
							<input type='text' name='nom' required />
							
							<label><fmt:message key="entrepot.table.pays" /></label>
							<input type='text' name='pays' required />
							
							<input type='submit' name='submit' value="Ajouter"/>
						</form>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />