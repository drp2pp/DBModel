<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link rel="stylesheet" href="/css/admin.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<body bgcolor="#ffffff" text="#000000">

<form name="detailForm" method="post">



<table width="100%" height="37" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"
			width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%"
			style="padding-left: 10px;">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="93%" class="ct_ttl01">상품상세조회</td>
				<td width="20%" align="right">&nbsp;</td>
			</tr>
		</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"
			width="12" height="37"></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="margin-top: 13px;">
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">상품번호 <img
			src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"></td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="105">${provo.prodNo}</td>
			</tr>
		</table>

		</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">상품명 <img
			src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"></td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">${provo.prodName}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">상품이미지 <img
			src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"></td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01"><img src = "/images/uploadFiles/null"></img></td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">상품상세정보 <img
			src="/images/ct_icon_red.gif" width="3" height="3" align="absmiddle"></td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">${provo.prodDetail}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">제조일자</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">${provo.manuDate}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">가격</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">${provo.price}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
	<tr>
		<td width="104" class="ct_write">등록일자</td>
		<td bgcolor="D6D6D6" width="1"></td>
		<td class="ct_write01">${provo.regDate}</td>
	</tr>
	<tr>
		<td height="1" colspan="3" bgcolor="D6D6D6"></td>
	</tr>
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	style="margin-top: 10px;">
	<tr>
		<td width="53%"></td>
		<td align="right">

		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<c:if test="${!empty provo.proTranCode}">
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif"
						width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01"
						style="padding-top: 3px;"><a href="/minishop/product/listProduct?menu=search">확인</a></td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif"
						width="14" height="23"></td>
				</c:if>
				<c:if test="${empty provo.proTranCode}">
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif"
						width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01"
						style="padding-top: 3px;"><a href="/minishop/purchase/addPurchaseView?prodNo=${provo.prodNo}">구매</a></td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif"
						width="14" height="23"></td>
	
					<td width="30"></td>
	
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif"
						width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01"
						style="padding-top: 3px;"><a href="javascript:history.go(-1)">이전</a></td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif"
						width="14" height="23"></td>
				</c:if>
			</tr>
		</table>
		
		</td>
	</tr>
</table>
</form>
</body>
</html>