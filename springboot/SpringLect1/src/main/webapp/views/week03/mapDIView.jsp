<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="entry" items="${animalMap}" varStatus="status">
		<li>${entry.key} : ${entry.value} : ${entry.value.sound()}</li>
	</c:forEach>
</body>
</html>