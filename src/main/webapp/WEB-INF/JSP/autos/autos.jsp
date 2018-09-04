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
			<form:input class="searchbar" path="nummerplaat" autofocus="autofocus" />
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
		</form:form>
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
						<spring:url var='herstelingeenUrl' value='/herstellingen/{id}'>
							<spring:param name='id' value='${auto.autoId}' />
						</spring:url>
						<td>
							<a href="${herstelingeenUrl}"><i class="fa fa-wrench" title="Herstellingen tonen"></i></a>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td><a href="<c:url value='/autos/toevoegen'/>">Auto
							toevoegen</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>