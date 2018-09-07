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
		<c:choose>
			<c:when test="${not empty page}">
				<table>
					<thead>
						<tr>
							<th><c:url value="" var="url">
									<c:param name="sort" value="familienaam" />
								</c:url> <a href="${url}">Technieker</a></th>
							<th><c:url value="" var="url">
									<c:param name="sort" value="adres.straat" />
								</c:url> <a href="${url}">Adres</a></th>
							<th><c:url value="" var="url">
									<c:param name="sort" value="adres.postcode" />
								</c:url> <a href="${url}">Gemeente</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items='${page.content}' var='technieker'>
							<tr>
								<td>${technieker.naam}</td>
								<td>${technieker.adres.straat}&nbsp;${technieker.adres.huisNr}</td>
								<td>${technieker.adres.postcode}&nbsp;${technieker.adres.gemeente}</td>
							</tr>
						</c:forEach>
						<tr>
							<td><a href="<c:url value='/techniekers/toevoegen'/>">Technieker
									toevoegen</a></td>
						</tr>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<p>Geen Herstellingen gevonden.</p>
				<table>
					<tr>
						<td><a href="<c:url value='/techniekers/toevoegen'/>">herstelling
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