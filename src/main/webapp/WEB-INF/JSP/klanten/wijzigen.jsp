<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | ${klant.naam} | Wijzigen"></v:head>
</head>
<body>
	<header>
			<h1>Garage Olivier </h1>
			<v:menu/>
	</header>
	<div class="content">
		<h2>Klant ${klant.naam} wijzigen</h2>
		<spring:url value="/klanten/{id}/wijzigen" var="url">
			<spring:param name="id" value="${klant.id}"/>
		</spring:url>
		<v:createform url="${url}" modelAttribute="klant" knopTekst="Klant wijzigen"/>
	</div>
</body>
</html>