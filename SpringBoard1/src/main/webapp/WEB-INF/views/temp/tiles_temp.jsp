<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<link rel="stylesheet" href="/resources/css/common.css?ver=13">
<link rel="stylesheet" href="/resources/css/board.css">
<c:forEach items="${jsList}" var="item">
	<script defer src="/resources/js/${item}.js?ver=1"></script>
</c:forEach>
<script defer src="/resources/js/common.js"></script>
</head>
<body>
	<div id="container">
		<tiles:insertAttribute name="header" />
		<section>
			<tiles:insertAttribute name="content" />			
		</section>		
	</div>
</body>
</html>
