<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>ȸ������</title>
</head>
<body>
    <h3>���� ȸ�� ����</h3>
    <strong>���� : ${registerRequest.email}</strong>
    <strong>�̸� : ${registerRequest.name}</strong>
    <strong>��ȣ : ${registerRequest.password}</strong>
    <strong>Ȯ�� : ${registerRequest.confirmPassword}</strong>
    <br><h3> ȸ�� ������ �Ϸ��߽��ϴ�.</h3><br>
    <p><a href="<c:url value='/main'/>">[ù ȭ�� �̵�]</a></p>
</body>
</html>