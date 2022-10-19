<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>EL Example</title>
    </head>
    <body>
        <h1>Implicit Objects</h1>
        <c:forEach var="reqHeader" items="${header}">
            ${reqHeader.key} = ${reqHeader.value}<br/>
            ${reqHeader.value} - length = ${fn:length(reqHeader.value)}<br/>
        </c:forEach>
    </body>
</html>