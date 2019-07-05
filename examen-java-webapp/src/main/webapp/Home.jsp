<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<core:import url="Header.jsp" />

<!-- Features -->
<div id="features-wrapper">
	<div class="container">
		<div class="row">
			<h2>Bienvenue ${!empty user ? user.nom : ''} ${!empty user ? user.prenom : ''}</h2>
		
	</div>
</div>
</div>

<core:import url="Footer.jsp" />