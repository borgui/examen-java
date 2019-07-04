<%-- 
    Document   : index
    Created on : 3 juil. 2019, 16:22:12
    Author     : merca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />

<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Création de Compte</h1>
        <hr class="my-3">
        <form method="post" action="AuthentificationServlet">
        	<input type="text" hidden name="action" value="inscription">
            <div class="form-group ">
                <label for="nom">Nom</label>
                <input type="text" name="nom" class="form-control" id="nom" placeholder="Entrer votre nom">
            </div>
            <div class="form-group">
                <label for="prenom">Prenom</label>
                <input type="text" name="prenom" class="form-control" id="prenom" placeholder="Entrer votre prenom">
            </div>
            <div class="form-group">
                <label for="email">E-mail</label>
                <input type="email" name="email" class="form-control" id="email" placeholder="Entrer votre email">
            </div>
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" name="login" class="form-control" id="login" placeholder="Entrer votre login">
            </div>
            <div class="form-group">
                <label for="pass">Password</label>
                <input type="password" name="password" class="form-control" id="pass">
            </div>
            <div class="form-group">
                <label for="confirmpass">Confirm Password</label>
                <input type="password" class="form-control" id="confirmpass">
            </div>
            <div class="float-right">
                <button type="submit" class="btn btn-primary">Creer compte</button>
            </div>
        </form>
    </div>
</div>
</body>
