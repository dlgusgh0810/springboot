<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
byName 방식에 의해 주입된 객체 : ${obj.cat}<br>
Constructor 방식에 의해 주입된 객체 : ${obj.sms}<br>
byType 방식에 의해 주입된 객체 : ${obj.dog}
</body>
</html>