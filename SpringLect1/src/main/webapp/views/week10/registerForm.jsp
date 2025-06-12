<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>응답 내용</title>
</head>
<body>
    <h2><spring:message code="member.info"/></h2>
    <form:form modelAttribute="registerRequest" method="post" action="/membershipSubmit">

        <p>
            <label><spring:message code="email"/>:<br>
                <form:input path="email"/>
                <form:errors path="email"/>
            </label>
        </p>
        <p>
            <label><spring:message code="name"/>:<br>
                <form:input path="name"/>
                <form:errors path="name"/>
            </label>
        </p>
        <p>
            <label><spring:message code="password"/>:<br>
                <form:input path="password"/>
                <form:errors path="password"/>
            </label>
        </p>
        <p>
            <label><spring:message code="password.confirm"/>:<br>
                <input type="password" name="confirmPassword" id="confirmPassword" value="${registerRequest.confirmPassword}" onfocus="this.value = '';">
            </label>
        </p>
        <input type="submit" value="<spring:message code="register.btn" />">
    </form:form>
</body>
</html>