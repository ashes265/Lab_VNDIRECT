<%@page import="java.util.Date"%>
<html>
    <head>
        <title>JSP Example</title>
    </head>
    <body>
    <% response.setHeader("Refresh","6");%>
    <LI>Today's date is:
    <%= new Date()%>
    </LI>
    <LI>Session id: <%= session.getId()%></LI>
    </body>
</html>