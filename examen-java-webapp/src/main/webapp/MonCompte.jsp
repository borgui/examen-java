<%-- 
    Document   : index
    Created on : 3 juil. 2019, 16:22:12
    Author     : merca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />
<%@ page import="webservice.Utilisateur"%>

<% 
	Utilisateur utilisateur = (Utilisateur) request.getAttribute( "utilisateur" );
%>


<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Modifier mon Compte</h1>
        <hr class="my-3">
        <form method="post" action="AuthentificationServlet">
        	<input type="text" hidden name="action" value="modifierCompte">
            <div class="form-group ">
                <label for="nom">Nom</label>
                <input type="text" name="nom" class="form-control" id="nom" placeholder="Entrer votre nom" value="<%= utilisateur.getNom()%>">
            </div>
            <div class="form-group">
                <label for="prenom">Prenom</label>
                <input type="text" name="prenom" class="form-control" id="prenom" value="<%= utilisateur.getNom()%>" placeholder="Entrer votre prenom">
            </div>
            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="email" name="email" class="form-control" id="email" value="<%= utilisateur.getMail()%>" placeholder="Entrer votre email">
            </div>
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" name="login" class="form-control" id="login" value="<%= utilisateur.getLogin()%>" placeholder="Entrer votre login">
            </div>
            <div class="form-group">
                <label for="pass">Password</label>
                <input type="password" name="password" class="form-control" id="pass" value="<%= utilisateur.getPassword()%>" required>
            </div>
            <div class="form-group">
                <label for="confirmpass">Confirm Password</label>
                <input type="password" class="form-control" id="confirmpass" name="confirmationPassword" value="<%= utilisateur.getPassword()%>" required>
            </div>
            <div class="float-right">
                <button type="submit" class="btn btn-primary">Modifier</button>
            </div>
        </form>
    </div>
</div>
</body>
