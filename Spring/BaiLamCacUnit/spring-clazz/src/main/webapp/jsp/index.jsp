<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@page language="java" pageEncoding="UTF-8"%>
<tiles:insertDefinition name="template">
	<tiles:putAttribute name="body">
		<h2>${message}</h2>
	</tiles:putAttribute>
</tiles:insertDefinition>