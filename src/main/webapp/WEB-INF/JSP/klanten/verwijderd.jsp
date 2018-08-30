<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
	<v:head title="Klant ${param.naam} verwijderd" />
</head>
<body>
	<header>
		<h1>Garage Olivier </h1>
		<v:menu />
	</header>
	<h2>Klant ${param.naam} verwijderd</h2>
</body>
</html>