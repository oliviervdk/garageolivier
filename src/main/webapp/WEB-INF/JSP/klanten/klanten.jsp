<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Klanten"></v:head>
</head>
<body>
	<header>
		<h1>Garage Olivier </h1>
		<v:menu />
	</header>
	<div class="content">
		<h2>Klanten</h2>
		<table>
			<thead>
				<tr>
					<th>Klant</th>
					<th>Adres</th>
					<th>Gemeente</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${klanten}' var='klant'>
					<tr>
						<td>${klant.naam}</td>
						<td>${klant.adres.straat} ${klant.adres.huisNr}</td>
						<td>${klant.adres.postcode} ${klant.adres.gemeente}</td>
						<spring:url var='wijzigUrl' value='/klanten/{id}'>
							<spring:param name='id' value='${klant.id}' />
						</spring:url>
						<td>
							<a href="${wijzigUrl}">Wijzigen</a>
						</td>
						<spring:url value='/klanten/{id}/verwijderen' var='verwijderURL'>
							<spring:param name='id' value='${klant.id}' />
						</spring:url>
						<td>
							<form action='${verwijderURL}' method='post'>
								<input class="submitlink" type='submit' value='Verwijderen'>
							</form>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td><a href="<c:url value='/klanten/toevoegen'/>">Klant
							toevoegen</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>