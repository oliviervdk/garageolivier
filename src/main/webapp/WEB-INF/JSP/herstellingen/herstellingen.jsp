<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Herstellingen"></v:head>
</head>
<body>
	<header>
			<h1>Garage Olivier </h1>
			<v:menu/>
	</header>
	<div class="content">
		<h2>Herstellingen</h2>
		<table>
			<thead>
				<tr>
					<th>Hersteldatum</th>
					<th>Auto</th>
					<th>Techniekers</th>
					<th>Aantal uren</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${herstellingen}' var='herstelling'>
					<tr>
						<td>${herstelling.herstelDatum}</td>
						<td>
							${herstelling.auto.merk} ${herstelling.auto.type}<br/>
							${herstelling.auto.nummerplaat}
						</td>
						<td>
							<c:forEach items='${herstelling.techniekers}' var='technieker'>
								${technieker.naam}
							</c:forEach>
						</td>
						<td>${herstelling.aantalUren}</td>
					</tr>
				</c:forEach>
				<tr>
					<td><a href="<c:url value='/herstellingen/toevoegen'/>">herstelling
							toevoegen</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>