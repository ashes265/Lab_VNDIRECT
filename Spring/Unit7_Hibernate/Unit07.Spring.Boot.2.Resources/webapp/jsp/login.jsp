<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Trang Đăng Nhập</h1>
		<c:if test="${not empty error}">
			<p>Sai tên đăng nhập hoặc mật khẩu</p>
		</c:if>
		<form method="post" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<p>
				<input type="text" >
			</p>
			<p>
				<input type="password" >
			</p>
			<p class="submit">
				<input type="submit" name="commit" value="Login">
			</p>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>