<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Auto's | Toevoegen"></v:head>
</head>
<body>
	<header>
		<h1>Garage Olivier</h1>
		<v:menu />
	</header>
	<div class="content">
		<h2>Auto toevoegen</h2>
		<c:url value="/autos" var="url"/>
		<form:form action="${url}" modelAttribute="auto"
			id="createform" method="post">

			<form:label path="merk">
		Merk:
		<form:errors path="merk" />
			</form:label>
			<form:input path="merk" autofocus="autofocus" required="required"
				maxlength="50" />

			<form:label path="type">
		Type:
		<form:errors path="type" />
			</form:label>
			<form:input path="type" required="required" maxlength="50" />

			<form:label path='bouwjaar'>
		Bouwjaar:
		<form:errors path='bouwjaar' delimiter=', ' />
			</form:label>
			<form:input path='bouwjaar' required='required' type='number'
				min='1900' />

			<form:label path='nummerplaat'>
		Nummerplaat.:
		<form:errors path='nummerplaat' delimiter=', ' />
			</form:label>
			<form:input path='nummerplaat' required='required' maxlength='45' />

			<form:label path='klant'>
		Klant:
		<form:errors path='klant' delimiter=', ' />
			</form:label><br>
			<form:select items='${klanten}' itemLabel="naam" itemValue="id" path='klant' size='5'/>

			<form:hidden path='versie' />

			<input type='submit' value='Auto toevoegen' id='submitknop'>

			<script>
				document.getElementById('createform').onsubmit = function() {
					document.getElementById('submitknop').disabled = true;
				};
			</script>
		</form:form>
	</div>
</body>
</html>