<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>User List</h1>
        <table border="1" style="width: 80%;margin: auto">
            <tr>
                <td>Name</td>
                <td>Action</td>
            </tr>

            <c:forEach items="${users}" var="it" varStatus="loop">
                <tr>
                    <td>
                        <a href="/user/detail/${it.username}">${it.username} - age: ${it.age}</a>
                    </td>
                    <td><a href="/user/delete/${it.username}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <h3>Average age: ${average}</h3>
    </tiles:putAttribute>
</tiles:insertDefinition>



