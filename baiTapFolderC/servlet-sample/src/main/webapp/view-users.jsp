<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>%>
<%@page import="java.io.*,java.util.*, java.sql.*" %>
<%@page import="javax.servlet.http.*,javax.servlet.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>View Users</title>
    </head>
    <body>
        <sql:setDataSource var="userdb" driver="org.apache.derby.jdbc.EmbeddedDriver"
                           url="jdbc:derby:C://Java//servlet-sample//user_db" user="" password=""/>

        <sql:query dataSource="${userdb}" var="result">
            select * from hanoi_user
        </sql:query>
            <table border="1">
                <tr>
                    <th>Name</th>
                    <th>Password</th>
                    <th>Email</th>
                </tr>
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                    <th>${row.username}</th>
                    <th><c:out value="${row.password}"/></th>
                    <th>${row.email}</th>
                    <td><a href="save?action=del&user=${row.username}">Delete</a></td>
                </tr>

                </c:forEach>
            </table>
            <div>
                <a href="register.html">Add New</a>
            </div>
    </body>
</html>