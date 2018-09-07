<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Herstellingen | Toevoegen"></v:head>
</head>
<body>
	<header>
			<h1>Garage Olivier </h1>
			<v:menu/>
	</header>
	<div class="content">
		<h2>Herstelling toevoegen</h2>
		<c:url value="/herstellingen" var="url"/>
		<form:form action="${url}" modelAttribute="herstelling"
			id="createform" method="post">

			<form:label path="herstelDatumForm">
		Hersteldatum:
		<form:errors path="herstelDatumForm" />
			</form:label>
			<form:input path="herstelDatumForm" autofocus="autofocus" required="required"
				type="date" />

			<form:label path="auto">
		Auto:
		<form:errors path="auto" delimiter=", " />
			</form:label><br>
			<form:select items='${autos}' itemLabel="naam" itemValue="autoId" path='auto' size='5'/>

			<br>
			<form:label path='techniekers'>
		Techniekers:
		<form:errors path='techniekers' delimiter=', ' />
			</form:label><br>
			<form:select items='${techniekers}' itemLabel="naam" itemValue="id" path='techniekers' size='5' multiple="multiple"/>

			<br>
			<form:label path='aantalUren'>
		Aantal uren:
		<form:errors path='aantalUren' delimiter=', ' />
			</form:label>
			<form:input path='aantalUren' required='required' type='number' />

			<form:hidden path='versie' />

			<input type='submit' value='Herstelling toevoegen' id='submitknop'>

			<script>
				document.getElementById('createform').onsubmit = function() {
					document.getElementById('submitknop').disabled = true;
				};
			</script>
		</form:form>
	</div>
</body>
</html>