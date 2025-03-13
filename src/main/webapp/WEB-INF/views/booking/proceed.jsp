<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 25. 3. 13.
  Time: 오후 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>식당예약</title>
</head>
<body>
    <h2>예약하기</h2>
    <p>
        예약이 정상적으로 이루어졌습니다.
    </p>
    <p>
        (예약번호 : ${uuid} )
    </p>
    <p>
        예약은 <b>${booking.customerName}</b>님 이름으로
        예약일자는 <b>${tableBooking.bookingDate}</b> 입니다.
    </p>
    <p>
        자세한 사항은 예약페이지를 확인하세요.
    </p>

</body>
</html>
