<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title>���� �����ȸ</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/css/admin.css" type="text/css">
<script type="text/javascript">
function fncGetList(currentPage){
	document.getElementById("currentPage").value=currentPage;
	document.detailForm.submit();
}
</script>
</head>

<body bgcolor="#ffffff" text="#000000">
<div style="width: 98%; margin-left: 10px;">

<form name="detailForm" action="/minishop/purchase/listPurchase" method="post">

<table width="100%" height="37" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"
			width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%"
			style="padding-left: 10px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="93%" class="ct_ttl01">���� �����ȸ</td>
			</tr>
		</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"
			width="12" height="37"></td>
	</tr>
</table>



<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="margin-top: 10px;">
	<tr>
		<td colspan="11">��ü ${page.totalCount} �Ǽ�, ����  ${page.currentPage} ������</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">�ֹ�No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">ȸ��ID</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">ȸ����</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">��ȭ��ȣ</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">�����Ȳ</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">��������</td>

	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>


	<c:forEach var="i" items="${list }">

	<tr class="ct_list_pop">
		<td align="center"><a href="/minishop/purchase/getPurchase?tranNo=${i.tranNo}">${i.tranNo}</td>
		<td></td>
		<td align="left"><a href="/minishop/user/getUser?userId=${i.buyer.userId}">${i.buyer.userId}</a></td>
		<td></td>
		<td align="left">${i.receiverName}</td>
		<td></td>
		<td align="left">${i.receiverPhone}</td>
		<td></td>
		<td align="left">
		<c:if test="${!empty i.tranCode}">
			<c:choose>
				<c:when test="${i.tranCode=='0  '}">
					���� ���� �Ϸ� ���� �Դϴ�.
				</c:when>
				<c:when test="${i.tranCode=='1  '}">
					���� ��� �� �����Դϴ�.
				</c:when>
				<c:when test="${i.tranCode=='2  '}">
					���� ��� �Ϸ� �����Դϴ�.
				</c:when>
			</c:choose>
		</c:if>
		</td>
		<td></td>
		<td align="left">
		<c:if test="${!empty i.tranCode && i.tranCode=='1  '}">
			<a href="/minishop/purchase/updateTranCode?tranNo=${i.tranNo}&tranCode=2">���ǵ���</a>
		</c:if>
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>

</table>





<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
			<input type="hidden" id="currentPage" name="currentPage" value=""/>
			<c:import url="/common/pageNavigator.jsp"/>
    	</td>
	</tr>
</table>

<!--  ������ Navigator �� --></form>

</div>
</body>
</html>
