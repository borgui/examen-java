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
                        <img class="card-img-top" src="https://dummyimage.com/600x400/55595c/fff" alt="Card image cap">
                        <div class="card-body">
                            <h4 class="card-title"><a href="product.html" title="View Product"><%= produit.getNom()%></a></h4>
                            <p class="card-text">produit.getDescription()</p>
                            <div class="row">
                                <div class="col">
                                    <p class="btn btn-danger btn-block"><%= produit.getPrix()%></p>
                                </div>
                                <div class="col">
                                    <a href="#" class="btn btn-success btn-block">Add to cart</a>
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