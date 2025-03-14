<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 14.
  Time: 오전 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie :: Spring</title>
    <style>
        table {
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #DDD;
        }

        a {
            text-decoration: none;
            color : #222;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <h3>영화 데이터베이스</h3>
    <table style="width: 680px; margin : auto;">
        <tr>
            <th>영화명</th>
            <th>개봉일</th>
        </tr>
        <c:forEach items="${movies}" var="one">
            <tr class="item">
                <td>
                    <a href="${pageContext.request.contextPath}/movie/detail?id=${one.id}">${one.title}</a>
                </td>
                <td>${one.releaseDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
