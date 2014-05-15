<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>eMarket</title>

<link href="/css/left.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
function history(){
	popWin = window.open("/minishop/product/getHistory","popWin","left=300, top=200, width=300, height=200, marginwidth=0, marginheight=0, scrollbars=no, scrolling=no, menubar=no, resizable=no");
}
</script>

</head>

<body background="/images/left/imgLeftBg.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"  >

<table width="159" border="0" cellspacing="0" cellpadding="0">

<!--menu 01 line-->
<tr>
<td valign="top"> 
		<table  border="0" cellspacing="0" cellpadding="0" width="159" >	
		<tr>
		<c:if test="${!empty user}">
		<tr>
		<td class="Depth03"><a href="/minishop/user/getUser" target="rightFrame">개인정보조회</a></td>
		</tr>
		</c:if>
		<c:if test="${user.role=='admin'}">
		<tr>
		<td class="Depth03" ><a href="/minishop/user/listUser" target="rightFrame">회원정보조회</a></td>
		</tr>
		</c:if>
		<tr>
		<td class="DepthEnd">&nbsp;</td>
		</tr>
		</table>

</td>
</tr>

		<c:if test="${user.role=='admin'}">
<!--menu 02 line-->
<tr>
<td valign="top"> 

		<table  border="0" cellspacing="0" cellpadding="0" width="159">
		<tr>
		<td class="Depth03"><a href="../product/addProductView.jsp;" target="rightFrame">판매상품등록</a></td>
		</tr>
		<tr>
		<td class="Depth03"><a href="/minishop/product/listProduct?menu=manage" target="rightFrame">판 매 관 리</a></td>
		</tr>
		<tr>
		<td class="DepthEnd">&nbsp;</td>
		</tr>
		</table>
</td>
</tr>
</c:if>

<!--menu 03 line-->
<tr>
<td valign="top">
		<table  border="0" cellspacing="0" cellpadding="0" width="159">
		<tr>
		<td class="Depth03"><a href="/minishop/product/listProduct?menu=search" target="rightFrame">상 품 검 색</a></td>
		</tr>
		<c:if test="${!empty user}">
		<tr>
		<td class="Depth03"><a href="/minishop/purchase/listPurchase" target="rightFrame">구매이력조회</a></td>
		</tr>
		</c:if>
		<tr>
		<td class="DepthEnd">&nbsp;</td>
		</tr>
		<tr>
		<td class="Depth03"><a href="javascript:history()">최근 본 상품</a></td>
		</tr>
		</table>
</td>
</tr>

</table>

</body>
</html>