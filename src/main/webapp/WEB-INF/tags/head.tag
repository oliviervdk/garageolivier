<%@ tag description='head onderdeel van pagina' pageEncoding='UTF-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ attribute name='title' required='true' type='java.lang.String'%>
<title>${title}</title>
<link rel='icon' href='<c:url value="/images/carIcon.png"/>'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name='viewport' content='width=device-width,initial-scale=1'>
<link rel='stylesheet' href='<c:url value="/css/default.css"/>'>