<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>여행 경비 계산 결과</title>
</head>
<body>
<h2>여행 경비 계산 결과</h2>
<p>
  숙박비는 <b>${stayCost}</b> 원,
  교통비는 <b>${trafficCost}</b> 원,
  음식비는 <b>${foodCost}</b> 원,
  기타비용은 <b>${otherCost}</b> 원,
</p>
<p>여행총경비는 <b>${tempTotal}</b> 원이며,</p>
<p>1인당 부담비용은 <b>${costPerPerson}</b> 원 입니다.</p>

</body>
</html>
