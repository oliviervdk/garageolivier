<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Techniekers"></v:head>
</head>
<body>
	<header>
		<h1>Garage Olivier</h1>
		<v:menu />
	</header>
	<div class="content">
		<h2>Techniekers</h2>
		<table>
			<thead>
				<tr>
					<th>Technieker</th>
					<th>Adres</th>
					<th>Gemeente</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${techniekers}' var='technieker'>
					<tr>
						<td>${technieker.naam}</td>
						<td>${technieker.adres.straat} ${technieker.adres.huisNr}</td>
						<td>${technieker.adres.postcode} ${technieker.adres.gemeente}</td>
						<spring:url var='wijzigUrl' value='/techniekers/{id}'>
							<spring:param name='id' value='${technieker}' />
						</spring:url>
						<td><a href="${wijzigUrl}">Wijzigen</a></td>
						<spring:url value='/techniekers/{technieker}/verwijderen' var='verwijderURL'>
							<spring:param name='id' value='${technieker}' />
						</spring:url>
						<td>
							<form action='${verwijderURL}' method='post'>
								<input class="submitlink" type='submit' value='Verwijderen'>
							</form>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td><a href="<c:url value='/techniekers/toevoegen'/>">Technieker
							toevoegen</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>