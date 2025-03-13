<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>여행 경비 계산기</title>
</head>
<body>
<h2>여행 경비 계산기</h2>
<p>
  목적지와 예상 경비 및 동행 인원수를 입력하여 제출하세요. 1인당 부담 비용을 계산해드립니다. (해외 설정시 10% 추가 계산)
</p>
<form action="${pageContext.request.contextPath}/travel/result">
  <p>
    <label>목적지 : <input type="radio" name="destination" value="domestic"/>국내</label>
    <label><input type="radio" name="destination" value="international"/>해외</label>
  </p>

  <p>
    <label>숙박비 : <input type="number" name="stayCost"/></label>
  </p>
  <p>
    <label>교통비 : <input type="number" name="trafficCost"/></label>
  </p>
  <p>
    <label>음식비 : <input type="number" name="foodCost"/></label>
  </p>
  <p>
    <label>기타비 : <input type="number" name="otherCost"/></label>
  </p>
  <p>
    <label>인원수: <input type="number" name="persons"/></label>
  </p>
  <p>
    <button type="submit">계산하기</button>
  </p>
</form>

</body>
</html>