<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>week06/memberListView.jsp</title>
</head>
<body>
    <h1>Member List</h1>
    <c:choose>
        <c:when test="${not empty memberList}">
            <table border="1">
                <thead>
                <tr>
                    <th>Map Index</th>
                    <th>Key</th>
                    <th>Name</th>
                    <th>Password</th>
                    <th>RegDate</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="map" items="${memberList}" varStatus="mapStatus">
                        <c:forEach var="entry" items="${map}">
                            <tr>
                                <td>${mapStatus.index}</td>
                                <td>${entry.key}</td>
                                <td>${entry.value.name}</td>
                                <td>${entry.value.password}</td>
                                <td>${entry.value.registerDateTime}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <p>No members found.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>