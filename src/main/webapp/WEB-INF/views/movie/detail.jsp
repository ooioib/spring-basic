<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 14.
  Time: 오후 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movie :: Spring</title>
</head>
<body>
<div style="text-align: center; width:680px; margin : auto">
    <h3>${found.title}</h3>
    <p>
        <small style="color:lightgray"><b>장르</b></small> ${found.genre}
        <small style="color:lightgray"><b>개봉일</b> </small>${found.releaseDate}
    </p>
    <h4>시놉시스</h4>
    <p style="white-space: pre-wrap">${found.description}</p>
</div>
</body>
</html>
