<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 13.
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>식당예약</title>
</head>
<body>

<h2>예약하기</h2>

<form action="${pageContext.request.contextPath}/booking/proceed">
    <p>
        <input type="text" name="customerName" placeholder="예약자" style="width: 100%; padding: 6px;"/>
    </p>

    <p>
        <input type="number" name="guests" placeholder="예약인원" style="width: 100%; padding: 6px;"/>
    </p>
    <p>
        <input type="date" name="bookingDate" placeholder="예약인원" style="width: 100%; padding: 6px;"/>
    </p>
    <p>
        <input type="text" name="contact" placeholder="이메일주소" style="width: 100%; padding: 6px;"/>
    </p>
    <p>
        <textarea name="requests" placeholder="요청사항" style="width: 100%; padding: 6px;"></textarea>
    </p>
    <p>
        <button type="submit" style="width: 100%; padding: 6px;">예약 진행하기</button>
    </p>
</form>

<p>부적절한 데이터가 포함되어 있습니다.</p>

</body>
</html>
