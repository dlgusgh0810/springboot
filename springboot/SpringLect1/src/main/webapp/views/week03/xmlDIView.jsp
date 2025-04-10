<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
XML 설정에 의해 생성된 객체 : ${obj}<br>
생성자를 통해 DI된 객체 : ${obj.sms}<br>
생성자를 통해 DI된 기본 데이터 : ${obj.num}<br>

Setter룰 통해 DI된 객체 : ${obj.unit}<br>
Setter를 통해 DI된 기본 데이터 : ${obj.msg}<br>
</body>
</html>