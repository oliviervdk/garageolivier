<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Techniekers | Toevoegen"></v:head>
</head>
<body>
	<header>
		<h1>Garage Olivier </h1>
		<v:menu/>
	</header>
	<div class="content">
		<h2>Technieker toevoegen</h2>
		<c:url value="/techniekers" var="url"/>
		<v:createform url="${url}" modelAttribute="technieker" knopTekst="technieker toevoegen"/>
	</div>
</body>
</html>