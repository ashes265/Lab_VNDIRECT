<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Add Group</h1>
        <c:if test="${errors!=null}">
            <h1 style="color: red">${errors}</h1>
        </c:if>
        <form:form method="post" action="/nhom/luu">
            <p>
                <c:if test="${id!=null}">
                    <form:input type="text" name="id" path="id" readonly="true"></form:input>
                </c:if>
                <form:input type="text" name="name" path="name"></form:input>
            </p>
            <p class="submit">
                <input type="submit" name="add" value="ADD"/>
            </p>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>