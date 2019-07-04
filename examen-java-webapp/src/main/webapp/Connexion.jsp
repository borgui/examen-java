<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<core:import url="Header.jsp" />

<fmt:setBundle basename="messages"/> 

<div id="main-wrapper">
	<div class="container">
		<div id="content">
			<h2><fmt:message key="connexion.title" /></h2>
			<form method="post" action="AuthentificationServlet">
				<input type="hidden" name="action" value="connexion">
				<label><fmt:message key="connexion.login" /></label><input type='text' name='login' />
				<label><fmt:message key="connexion.mdp" /></label><input type='password' name='password' />
				<input type='submit' name='submit' value="submit">
			</form>
		</div>
	</div>
</div>

<core:import url="Footer.jsp" />