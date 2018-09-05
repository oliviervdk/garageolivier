<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Herstellingen"></v:head>
</head>
<body>
	<header>
		<h1>Garage Olivier</h1>
		<v:menu />
	</header>
	<div class="content">
		<h2>Herstellingen</h2>
		<table>
			<thead>
				<tr>
					<th><c:url value="" var="url">
							<c:param name="sort" value="herstelDatum" />
						</c:url> <a href="${url}">HerstelDatum</a></th>
					<th><c:url value="" var="url">
							<c:param name="sort" value="auto.nummerplaat" />
						</c:url> <a href="${url}">Auto</a></th>
					<th><c:url value="" var="url">
							<c:param name="sort" value="techniekers.familienaam" />
						</c:url> <a href="${url}">Techniekers</a></th>
					<th><c:url value="" var="url">
							<c:param name="sort" value="aantalUren" />
						</c:url> <a href="${url}">Aantal uren</a></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${page.content}' var='herstelling'>
					<tr>
						<td><spring:eval expression="herstelling.herstelDatum" /></td>
						<td>${herstelling.auto.naam}</td>
						<td><c:forEach items='${herstelling.techniekers}'
								var='technieker' varStatus="status">
								${technieker.naam}<c:if test="${not status.last}">, </c:if>
							</c:forEach></td>
						<td>${herstelling.aantalUren}</td>
					</tr>
				</c:forEach>
				<tr>
					<td><a href="<c:url value='/herstellingen/toevoegen'/>">herstelling
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