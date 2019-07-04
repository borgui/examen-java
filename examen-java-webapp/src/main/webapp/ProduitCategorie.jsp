<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Produit"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<fmt:setBundle basename="messages"/> 
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2><fmt:message key="prodcateg.title" /></h2>
				<%
					List<Produit> produitList = (List<Produit>) request.getAttribute("listeProduit");

					if (produitList == null) {
				%>
				<p><fmt:message key="prodcateg.err.notfound" /></p>
				<%
					} else {
				%>
				<div class="row">
					<%
						for (Produit produit : produitList) {
					%>
					<div class="col-3">
						<div class="card" style="height:550px">
						<% if(produit.getImage() != null){ %>
						<img class="card-img-top" src="<%= produit.getImage() %>" alt="Card image cap">
						<%} else{ %>
						<img class="card-img-top" src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6c/No_image_3x4.svg/320px-No_image_3x4.svg.png" alt="Card image cap">
						
						
						<%} %>
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product"><%= produit.getNom()%></a></h4>
                            <p class="card-text" style="height:50px">
                            <%=produit.getDescription()%>
                            <br/>
                            <div><fmt:message key="prodcateg.stock" />: <%= produit.getStock() %></div>
                            <p class="bloc_left_price"><%= produit.getPrix()%> &euro;</p>
                           	<form method='get' action='PanierServlet'>
                           	<input type="text" hidden name="action" value="ajouterProduit">
                            <input type="text" hidden name="idProduit" value="<%= produit.getId() %>">
                            <input type="text" hidden name="idCategorie" value="<%= produit.getCategorie().getId() %>">
                            
                            <div class="row">
                                <div class="col-5">
                                <fmt:message key="prodcateg.quantite" />: 
                                </div>
                            
                                <div class="col-7">
                                 	<input type="text" class="form-control"  id="quantity" name="quantite" min="1" max="100" value="1">
               
                                </div>
                                <div class="col-12">
                                    <input type="submit" style="background-color: #28a745;border-color: #28a745;"  class="btn btn-success btn-block" value="Ajouter au panier"></a>
                                </div>
                            </div>
                            </form>
                        </div>
                    </div>
					</div>
					<%
							}
						%>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />