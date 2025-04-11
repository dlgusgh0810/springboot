<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="smsArray" items="${scopeBeanArray}" varStatus="status">
		<c:forEach var="sms" items="${smsArray}" varStatus="status">
			${status.count} : <c:out value="${sms}" /><br>
		</c:forEach>
		<c:out value="==================================" /> <br>
	</c:forEach>
</body>
</html>