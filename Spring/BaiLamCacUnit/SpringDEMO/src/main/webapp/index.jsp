<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Hello World!</h2>
<h3>Thong diep gui tu controller: ${message}</h3>
<h1> In Class - Major: ${class.major}</h1>
<table>
    <tr>
        <th>
            Name
        </th>
        <th>
            Major
        </th>
    </tr>
    <c:forEach items="${class.students}" var="stu">
        <tr>
            <td>
                ${stu.name}
            </td>
            <td>
                ${major} - ${stu.university.name}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
