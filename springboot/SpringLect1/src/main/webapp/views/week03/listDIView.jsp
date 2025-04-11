<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="animal" items="${animalService.animals}" varStatus="status">
		<li>${status.count} : <c:out value="${animal.sound()}"/>
	</c:forEach>
</body>
</html>