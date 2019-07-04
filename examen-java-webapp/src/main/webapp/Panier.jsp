<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ page import="webservice.Panier"%>
<%@ page import="webservice.PanierProduit"%>
<%@ page import="java.util.List"%>
<core:import url="Header.jsp" />
<fmt:setBundle basename="messages"/> 
<div class="content">
	<div id="main-wrapper">
		<div class="container">
			<div class="content">
				<h2><fmt:message key="panier.title" /></h2>
				<%
					Panier panier = (Panier) request.getAttribute("panier");
					double total = 0;

					if (panier.getPanierProduits() == null || panier.getPanierProduits().size() == 0) {
				%>
				<p><fmt:message key="panier.err.notfound" /></p>
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
                            <th scope="col"><fmt:message key="panier.produit" /></th>
                            <th scope="col" class="text-center"><fmt:message key="panier.quantite" /></th>
                            <th scope="col" class="text-right"><fmt:message key="panier.prix" /></th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>
                    <% for(PanierProduit panierProduit : panier.getPanierProduits()){ %>
                        <tr>
                        <% if(panierProduit.getProduit().getImage() != null){ %>
                			<td><img style="width:100px" src="<%=panierProduit.getProduit().getImage() %>" /> </td>
                			<%} else { %>
                            <td><img style="width:100px" src="https://dummyimage.com/50x50/55595c/fff" /> </td>
                            <%} %>
                            <td><%=panierProduit.getProduit().getNom()%></td>
                            <td><input class="form-control" type="text" name="quantite" value="<%= panierProduit.getQuantite() %>" /></td>
                            <td class="text-right"><%= panierProduit.getProduit().getPrix() * panierProduit.getQuantite() %> &euro;</td>
                            <td class="text-right"><a href="PanierServlet?action=supprimerProduit&id=<%= panierProduit.getId() %>"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button></a> </td>
                        </tr>
                       <% total += panierProduit.getProduit().getPrix() * panierProduit.getQuantite();
                       } %>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><fmt:message key="panier.subtot" /></td>
                            <td class="text-right"><%= total %>&euro;</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><fmt:message key="panier.fdp" /></td>
                            <td class="text-right">0 &euro;</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong><fmt:message key="panier.total" /></strong></td>
                            <td class="text-right"><%= total %>&euro;<strong></strong></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <button class="btn btn-block btn-light"><fmt:message key="panier.continueshop" /></button>
                </div>
                <div class="col-sm-12 col-md-6 text-right">

                <form method="post" action="CommandeServlet">
                	<input hidden name="idPanier" value="<%= panier.getId()%>">
                	<input hidden name="total" value="<%= total%>">
                	<input hidden name="action" value="ajouterCommande">
                    <input type="submit" class="btn btn-lg btn-block btn-success text-uppercase" value="<fmt:message key="panier.checkout" />">
                </form>
                </div>
            </div>
        </div>
    </div>
    <%} %>
		</div>
	</div>
</div>
<core:import url="Footer.jsp" />