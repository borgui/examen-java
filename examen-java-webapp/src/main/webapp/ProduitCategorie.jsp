<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Produit"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Boutique</h2>
				<%
					List<Produit> produitList = (List<Produit>) request.getAttribute("listeProduit");

					if (produitList == null) {
				%>
				<p>Il n'y a aucun produit</p>
				<%
					} else {
				%>
				<div class="row">
					<%
						for (Produit produit : produitList) {
					%>
					<div class="col-3">
						<div class="card">
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product"><%= produit.getNom()%></a></h4>
                            <p class="card-text">
                            <%=produit.getDescription()%>
                            <br/>
                            <div>Stock: <%= produit.getStock() %></div>
                            <p class="bloc_left_price"><%= produit.getPrix()%> &euro;</p>
                            
                            <div class="row">
                                <div class="col-5">
                                Quantite: 
                                </div>
                            
                                <div class="col-7">
                                 	<input type="text" class="form-control"  id="quantity" name="quantite" min="1" max="100" value="1">
               
                                </div>
                                <div class="col-12">
                                    <a href="#" class="btn btn-success btn-block">Ajouter au panier</a>
                                </div>
                            </div>
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