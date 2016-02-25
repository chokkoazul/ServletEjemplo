<%@ page language='java' contentType='text/html;charset=iso-8859-1'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  prefix="c"  uri="http://java.sun.com/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login result</title>
</head>
<body>
<jsp:useBean id="usuario" class="cl.mac.UsuarioBean" scope="request" />
Bienvenido <jsp:getProperty name="usuario" property="nombre" /><br>
Bienvenido <c:out value="${usuario.nombre}" default="valor_nulo"/>
<a href="index.html">Volver</a>
</body>
</html>