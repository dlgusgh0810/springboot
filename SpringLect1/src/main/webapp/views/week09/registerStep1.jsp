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
    <h2>���</h2>
    <p>��� ����</p>
    <from action="/regist/step2" method ="post">
        <input type="hidden" name ="view" value="registerStep2">
        <label>
            <input type="checkbox" name="agree"value ="true"> ��� ����
        </label>
        <input type="submit" value="���� �ܰ�"/>
        <c:if test="${not empty message}">
            <p style="color: blue;">${message}</p>
        </c:if>
    </from>
</body>
</html>