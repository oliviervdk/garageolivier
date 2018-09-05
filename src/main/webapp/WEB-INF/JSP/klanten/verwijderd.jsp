<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Klant ${klant.naam} verwijderd" />
</head>
<body>
	<header>
		<h1>Garage Olivier</h1>
		<v:menu />
	</header>
	<div class="verwijder">
		<h2>Weet u zeker dat u klant ${klant.naam} wil verwijderen?</h2>
		Als u ${klant.naam} verwijderd, worden ook bijhorende auto's en
		herstellingen verwijderd.
		<spring:url value='/klanten/{id}/verwijderd' var='verwijderURL'>
			<spring:param name='id' value='${klant.klantId}' />
		</spring:url>
		<form method="post" action="${verwijderURL}">
			<h3>${klant.naam} verwijderen?</h3>
			<button type="submit">Doorgaan</button>
			<button formmethod="get" formaction="<c:url value='/klanten'/>">Annuleren</button>
		</form>
	</div>
</body>
</html>