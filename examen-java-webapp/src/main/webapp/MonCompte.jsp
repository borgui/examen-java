<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />
<fmt:setBundle basename="messages"/> 

<%@ page import="webservice.Utilisateur"%>

<% 
	Utilisateur utilisateur = (Utilisateur) request.getAttribute( "utilisateur" );
%>


<div class="container">
    <div class="jumbotron">
        <h1 class="display-4"><fmt:message key="compte.modif.title" /></h1>
        <hr class="my-3">
        <form method="post" action="AuthentificationServlet">
        	<input type="text" hidden name="action" value="modifierCompte">
            <div class="form-group ">
                <label for="nom"><fmt:message key="compte.nom" /></label>
                <input type="text" name="nom" class="form-control" id="nom" placeholder="Entrer votre nom" value="<%= utilisateur.getNom()%>">
            </div>
            <div class="form-group">
                <label for="prenom"><fmt:message key="compte.prenom" /></label>
                <input type="text" name="prenom" class="form-control" id="prenom" value="<%= utilisateur.getNom()%>" placeholder="Entrer votre prenom">
            </div>
            <div class="form-group">
                <label for="email"><fmt:message key="compte.mail" /></label>
                <input type="email" name="email" class="form-control" id="email" value="<%= utilisateur.getMail()%>" placeholder="Entrer votre email">
            </div>
            <div class="form-group">
                <label for="login"><fmt:message key="compte.login" /></label>
                <input type="text" name="login" class="form-control" id="login" value="<%= utilisateur.getLogin()%>" placeholder="Entrer votre login">
            </div>
            <div class="form-group">
                <label for="pass"><fmt:message key="compte.mdp" /></label>
                <input type="password" name="password" class="form-control" id="pass" value="<%= utilisateur.getPassword()%>" required>
            </div>
            <div class="form-group">
                <label for="confirmpass"><fmt:message key="compte.mdpconfirm" /></label>
                <input type="password" class="form-control" id="confirmpass" name="confirmationPassword" value="<%= utilisateur.getPassword()%>" required>
            </div>
            <div class="float-right">
                <button type="submit" class="btn btn-primary"><fmt:message key="compte.modifier" /></button>
            </div>
        </form>
    </div>
</div>
</body>
