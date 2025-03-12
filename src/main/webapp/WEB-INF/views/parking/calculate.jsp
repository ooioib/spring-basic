<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Spring Web App</title>
</head>
<body>
<h1>주차요금 계산 결과</h1>
<p>
    차량번호 [ ${param.car} ] 고객님의 주차시간은 ${param.minutes} 분, 구매금액은 ${param.purchase} 원으로 주차요금이 계산됩니다.
</p>
<p>
    정산금액은 ${fee} 원입니다.
</p>


<c:choose>
    <c:when test="${fee > 0}">
        <p>
            신용카드를 카드투입구에 넣어주세요.
        </p>
    </c:when>
    <c:otherwise>
        <p>
            안녕히 가세요.
        </p>
    </c:otherwise>
</c:choose>
</body>
</html>
