
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
<form name="updatePurchase" action="/minishop/purchase/updatePurchaseView?tranNo=0" method="post">

다음과 같이 구매가 되었습니다.
<table border=1>
		<tr>
		<td>물품번호</td><td>${purvo.purchaseProd.prodNo}</td>
	</tr>
	<tr>
		<td>구매자아이디</td><td>${purvo.buyer.userId}</td>
	</tr>
	<tr>
		<td>구매방법</td>
		<td>${purvo.paymentOption=='1'?"현금구매":"카드구매"}</td>
	</tr>
	<tr>
		<td>구매자이름</td><td>${purvo.receiverName}</td>
	</tr>
	<tr>
		<td>구매자연락처</td><td>${purvo.receiverPhone}</td>
	</tr>
	<tr>
		<td>구매자주소</td><td>${purvo.receiverAddr}</td>
	</tr>
		<tr>
		<td>구매요청사항</td><td>${purvo.receiverRequest}</td>
	</tr>
	<tr>
		<td>배송희망일자</td><td>${purvo.divyDate}</td>
	</tr>

</table>
</form>
</body>
</html>