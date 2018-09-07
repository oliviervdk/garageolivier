<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Auto's"></v:head>
</head>
<body>
	<header>
		<h1>Garage Olivier</h1>
		<v:menu />
	</header>
	<div class="content">
		<h2>Auto's</h2>
		<form:form method="get" action="/autos"
			modelAttribute="nummerplaatForm">
			<form:label path="nummerplaat">
				Zoek op nummerplaat:
				<form:errors path="nummerplaat" />
			</form:label>
			<form:input class="searchbar" path="nummerplaat"
				autofocus="autofocus" />
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form:form>
		<c:choose>
			<c:when test="${not empty page}">
				<table>
					<thead>
						<tr>
							<th><c:url value="" var="url">
									<c:param name="sort" value="merk" />
								</c:url> <a href="${url}">Merk</a></th>
							<th><c:url value="" var="url">
									<c:param name="sort" value="type" />
								</c:url> <a href="${url}">Type</a></th>
							<th><c:url value="" var="url">
									<c:param name="sort" value="bouwjaar" />
								</c:url> <a href="${url}">Bouwjaar</a></th>
							<th><c:url value="" var="url">
									<c:param name="sort" value="nummerplaat" />
								</c:url> <a href="${url}">Nummerplaat</a></th>
							<th><c:url value="" var="url">
									<c:param name="sort" value="klant.familienaam" />
								</c:url> <a href="${url}">Klant</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items='${page.content}' var='auto'>
							<tr>
								<td>${auto.merk}</td>
								<td>${auto.type}</td>
								<td>${auto.bouwjaar}</td>
								<td>${auto.nummerplaat}</td>
								<td>${auto.klant.naam}</td>
								<spring:url var='herstellingenUrl' value='/herstellingen/{id}'>
									<spring:param name='id' value='${auto.autoId}' />
								</spring:url>
								<td><a href="${herstellingenUrl}"><i
										class="fa fa-wrench" title="Herstellingen tonen"></i></a></td>
								<spring:url var='wijzigUrl' value='/wijzigen/{id}'>
									<spring:param name='id' value='${auto.autoId}' />
								</spring:url>
								<td><a href="${wijzigUrl}"><i
										class="fa fa-exchange" title="Nieuwe eigenaar toekennen"></i></a></td>
							</tr>
						</c:forEach>
						<tr>
							<td><a href="<c:url value='/autos/toevoegen'/>">Auto
									toevoegen</a></td>
						</tr>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<p>Geen Auto's gevonden.</p>
				<table>
					<tr>
						<td><a href="<c:url value='/autos/toevoegen'/>">Auto
								toevoegen</a></td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
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