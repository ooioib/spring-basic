<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <%--예약자 --%>
    <p>
        <input type="text" name="customerName" placeholder="예약자" style="width: 100%; padding: 6px;"
               value="${tableBooking.customerName}"/>
        <c:if test="${customerNameError != null }">
    <div style="color:red">
        예약자 이름은 필수 기입 정보입니다.
    </div>
    </c:if>
    </p>
    <%--인원수 --%>
    <p>
        <input type="number" name="guests" placeholder="예약인원" style="width: 100%; padding: 6px;"/>
        <c:if test="${guestsErrorCount != 0 }">
    <div>
        최소 인원은 2명, 최대인원은 6명입니다.
    </div>
    </c:if>
    </p>
    <%--예약일 --%>
    <p>
        <input type="date" name="bookingDate" style="width: 100%; padding: 6px;" value="${tableBooking.bookingDate}"/>
        <c:if test="${bindingResult.getFieldErrorCount('bookingDate') != 0 }">
    <div style="color:red">
        예약 가능 일자는 내일부터 선택 가능합니다.
    </div>
    </c:if>
    </p>

    <%--이메일 주소--%>
    <p>
        <input type="text" name="contact" placeholder="이메일주소" style="width: 100%; padding: 6px;"/>
    </p>
     <%--요청 사항--%>
    <p>
        <textarea name="requests" placeholder="요청사항" style="width: 100%; padding: 6px;"></textarea>
    </p>

    <p>
        <button type="submit" style="width: 100%; padding: 6px;">예약 진행하기</button>
    </p>

</form>
</body>
</html>
