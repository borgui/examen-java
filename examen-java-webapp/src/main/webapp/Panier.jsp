<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Panier"%>
<%@ page import="webservice.PanierProduit"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2>Panier</h2>
				<%
					Panier panier = (Panier) request.getAttribute("panier");
					double total = 0;

					if (panier.getPanierProduits() == null) {
				%>
				<p>Votre panier est vide</p>
				<%
					} else {
				%>
	<div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"> </th>
                            <th scope="col">Produit</th>
                            <th scope="col" class="text-center">Quantité</th>
                            <th scope="col" class="text-right">Prix</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                    <% for(PanierProduit panierProduit : panier.getPanierProduits()){ %>
                        <tr>
                            <td><img src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                            <td><%=panierProduit.getProduit().getNom()%></td>
                            <td><input class="form-control" type="text" name="quantite" value="<%= panierProduit.getQuantite() %>" /></td>
                            <td class="text-right"><%= panierProduit.getProduit().getPrix() * panierProduit.getQuantite() %> &euro;</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                       <% total += panierProduit.getProduit().getPrix() * panierProduit.getQuantite();
                       } %>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Sub-Total</td>
                            <td class="text-right"><%= total %></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>Shipping</td>
                            <td class="text-right">0 &euro;</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
=                           <td></td>
                            <td><strong>Total</strong></td>
                            <td class="text-right"><%= total %>&euro;<strong></strong></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <button class="btn btn-block btn-light">Continue Shopping</button>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <button class="btn btn-lg btn-block btn-success text-uppercase">Checkout</button>
                </div>
            </div>
        </div>
    </div>
    <%} %>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />