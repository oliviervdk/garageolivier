<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<nav>
	<ul>
		<li><a href="<c:url value='/'/>">&#8962;</a></li>
		<li>
			<c:url value="/klanten" var="url">
				<c:param name="sort" value="familienaam" />
			</c:url>
			<a href="${url}">Klanten</a>
		</li>
		<li>
			<c:url value="/techniekers" var="url">
				<c:param name="sort" value="familienaam" />
			</c:url>
			<a href="${url}">Techniekers</a>
		</li>
		<li>
			<c:url value="/autos" var="url">
				<c:param name="sort" value="nummerplaat" />
			</c:url>
			<a href="${url}">Auto's</a>
		</li>
		<li>
			<c:url value="/herstellingen" var="url">
				<c:param name="sort" value="herstelDatum" />
			</c:url>
			<a href="${url}">Herstellingen</a>
		</li>
	</ul>
</nav>
