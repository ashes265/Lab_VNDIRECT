<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Group List</h1>
        <table border="1" style="margin: auto;width: 80%">
            <tr>
                <td>Name</td>
                <td style="text-align: center">Action</td>

            </tr>
            <tr>
                <td colspan="2">
                    <form method="get" action="/nhom/listFilter">
                        <c:if test="${filter!=null}">
                            <input type="text" name="filter" placeholder="${filter}"/>
                        </c:if>
                        <c:if test="${filter==null}">
                            <input type="text" name="filter"/>
                        </c:if>
                    </form>
                </td>
            </tr>

            <c:forEach items="${groups}" var="item" varStatus="loop">
                <tr>
                    <td>
                        <a href="/user/listFilter?id=${item.id}">${item.name}</a>
                        <ul>
                            <c:forEach items="${item.users}" varStatus="loop" var="user">
                                <li>${user.username} - ${user.age}</li>
                            </c:forEach>
                        </ul>
                    </td>
                    <td style="text-align: center">
                        <a href="../nhom/delete/${item.id}">Delete</a>/<a href="../nhom/update?id=${item.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>
