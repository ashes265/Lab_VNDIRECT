<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="template">
  <tiles:putAttribute name="body">
    <h1>User</h1>
    <p>User name: ${user.username}</p>
    <p>Password: ${user.password}</p>
    <p>Email: ${user.email}</p>
    <p>Age: ${user.age}</p>
    <p>Group: ${user.group.name}</p>
  </tiles:putAttribute>
</tiles:insertDefinition>
