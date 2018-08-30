<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Garage Olivier  | Auto's | Toevoegen"></v:head>
</head>
<body>
	<header>
			<h1>Garage Olivier </h1>
			<v:menu/>
	</header>
	<div class="content">
		<h2>Auto toevoegen</h2>
		<form method='post' action='<c:url value="/autos"/>'>
			<input type='submit' value='Toevoegen'>
		</form>
	</div>
</body>
</html>