<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login result</title>
</head>
<body>
	<%
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		if ("edu4java".equals(user) && "eli4java".equals(pass)) {
			out.println("login ok");
		} else {
			out.println("invalid login");
		}
	%>
</body>
</html>