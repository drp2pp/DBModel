
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
<form name="updatePurchase" action="/minishop/purchase/updatePurchaseView?tranNo=0" method="post">

������ ���� ���Ű� �Ǿ����ϴ�.
<table border=1>
		<tr>
		<td>��ǰ��ȣ</td><td>${purvo.purchaseProd.prodNo}</td>
	</tr>
	<tr>
		<td>�����ھ��̵�</td><td>${purvo.buyer.userId}</td>
	</tr>
	<tr>
		<td>���Ź��</td>
		<td>${purvo.paymentOption=='1'?"���ݱ���":"ī�屸��"}</td>
	</tr>
	<tr>
		<td>�������̸�</td><td>${purvo.receiverName}</td>
	</tr>
	<tr>
		<td>�����ڿ���ó</td><td>${purvo.receiverPhone}</td>
	</tr>
	<tr>
		<td>�������ּ�</td><td>${purvo.receiverAddr}</td>
	</tr>
		<tr>
		<td>���ſ�û����</td><td>${purvo.receiverRequest}</td>
	</tr>
	<tr>
		<td>����������</td><td>${purvo.divyDate}</td>
	</tr>

</table>
</form>
</body>
</html>