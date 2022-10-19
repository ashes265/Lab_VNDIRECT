<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Jazz Application</title>
</head>
<body>
	<h1>Welcome to Spring Jazz </h1>
	<p><a href="/">Trang Chủ</a></p>
	<tiles:insertAttribute name="body" />
</body>
</html>