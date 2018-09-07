<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!doctype html>
<html>
<head>
<v:head title="Garage Olivier | Eigenaar wijzigen | Auto's"></v:head>
</head>
<body>
<header>
		<h1>Garage Olivier</h1>
		<v:menu />
	</header>
	<div class="content">
		<h2>Eigenaar wijzigen</h2>
		<h3>Details</h3>
		${auto.merk}&nbsp;${auto.type}&nbsp;(${auto.nummerplaat})
		<c:url value="/autos" var="url"/>
		<form:form action="${url}" modelAttribute="auto" method="post">

			<form:label path="klant">
		<h3>Klanten</h3>
		<form:errors path="klant" />
			</form:label>
			<form:select items="${klanten}" itemLabel="naam" itemValue="klantId" path="klant" size="5" required="required" />
			<form:hidden path='versie' />
			<input type='submit' value='Eigenaar wijzigen' id='submitknop'>
		</form:form>
	</div>
</body>
</html>