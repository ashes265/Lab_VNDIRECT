<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<h3>Thong diep gui tu controller: ${message}</h3>
<h1> In Class - Major: ${classInfo.major}</h1>
<table>
    <tr>
        <th>
            Name
        </th>
        <th>
            Major
        </th>
    </tr>
    <c:forEach items="${classInfo.students}" var="stu">
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
