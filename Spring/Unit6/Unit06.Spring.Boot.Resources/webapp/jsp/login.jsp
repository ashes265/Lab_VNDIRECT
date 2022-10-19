<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h1>Login to Application</h1>
		<form method="post" >
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
			<p>
				
			</p>
			<p>
				
			</p>
			<p class="submit">
				<input type="submit" 
			</p>
		</form>
	</tiles:putAttribute>
</tiles:insertDefinition>