<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Klanten" />
</head>
<body>
	<header>
		<h1>Garage Olivier</h1>
		<v:menu />
	</header>
	<div class="content">
		<h2>Klanten</h2>
		<form:form method="get" action="/klanten"
			modelAttribute="klantNaamForm">
			<form:label path="naam">
				Zoek op naam:
				<form:errors path="naam" />
			</form:label>
			<form:input class="searchbar" path="naam" autofocus="autofocus" />
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form:form>
		<table>
			<thead>
				<tr>
					<th><c:url value="" var="url">
							<c:param name="sort" value="familienaam" />
						</c:url> <a href="${url}">Klant</a></th>
					<th><c:url value="" var="url">
							<c:param name="sort" value="adres.straat" />
						</c:url> <a href="${url}">Adres</a></th>
					<th><c:url value="" var="url">
							<c:param name="sort" value="adres.postcode" />
						</c:url> <a href="${url}">Gemeente</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${page.content}' var='klant'>
					<tr>
						<td>${klant.naam}</td>
						<td>${klant.adres.straat}&nbsp;${klant.adres.huisNr}</td>
						<td>${klant.adres.postcode}&nbsp;${klant.adres.gemeente}</td>
						<spring:url var='wijzigUrl' value='/klanten/{id}/wijzigen'>
							<spring:param name='id' value='${klant.klantId}' />
						</spring:url>
						<td><a href="${wijzigUrl}"><i class="fa fa-edit"
								title="Klant wijzigen"></i></a></td>
						<spring:url value='/klanten/{id}/verwijderen' var='verwijderURL'>
							<spring:param name='id' value='${klant.klantId}' />
						</spring:url>
						<td><a href="${verwijderURL}"><i class="fa fa-bomb"
								title="Klant verwijderen"></i></a></td>
						<spring:url var='autosUrl' value='/autos/{id}'>
							<spring:param name='id' value='${klant.klantId}' />
						</spring:url>
						<td><a href="${autosUrl}"><i class="fa fa-car"
								title="Auto's tonen"></i></a></td>

					</tr>
				</c:forEach>
				<tr>
					<td><a href="<c:url value='/klanten/toevoegen'/>">Klant
							toevoegen</a></td>
				</tr>
			</tbody>
		</table>
		<nav>
			<c:forEach var="pageNr" begin="1" end="${page.totalPages}">
				<c:choose>
					<c:when test="${pageNr-1 == page.number}">       ${pageNr}     </c:when>
					<c:otherwise>
						<c:url value="" var="url">
							<c:param name="page" value="${pageNr-1}" />
							<c:param name="sort" value="${param.sort}" />
						</c:url>
						<a href="${url}">${pageNr}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</nav>
	</div>
</body>
</html>