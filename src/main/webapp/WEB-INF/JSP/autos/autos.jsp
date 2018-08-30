<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
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
		<table>
			<thead>
				<tr>
					<th>Merk</th>
					<th>Type</th>
					<th>Bouwjaar</th>
					<th>nummerplaat</th>
					<th>Klant</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${autos}' var='auto'>
					<tr>
						<td>${auto.merk}</td>
						<td>${auto.type}</td>
						<td>${auto.bouwjaar}</td>
						<td>${auto.nummerplaat}</td>
						<td>${auto.klant.naam}</td>
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