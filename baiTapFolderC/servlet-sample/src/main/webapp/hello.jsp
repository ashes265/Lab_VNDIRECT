<%@ page isELIgnored = "false" %>
<html>
<head>
<title>Welcome to our Website</title>
</head>
<body>
<marquee><font size="3" color="#FF0033">Hello World! ${param["j_username"]}!!
</font>
<font color="#0000FF">
    Hostname: <%= request.getRemoteHost() %><br/>
</font>
<font color="#0000FF">
    Session Id: <%= session.getId()%>
</font>
<h1>${say}</h1>
</body>
</html>