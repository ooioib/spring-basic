<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 12.
  Time: 오후 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Wep App</title>
</head>
<body>

<h1>주차요금 계산</h1>
<form action="${pageContext.request.contextPath}/parking/calculate">
    <p>
        <label>차량번호 : <input type="text" name="car"/> </label>
    </p>
    <p>
        <label>주차시간(분) : <input type="number" name="minutes"/> </label>
    </p>
    <p>
        <label>구매금액(원) : <input type="text" name="purchase"/> </label>
    </p>
    <p>
        <button type="submit">정산하기</button>
    </p>
</form>
</body>
</html>
