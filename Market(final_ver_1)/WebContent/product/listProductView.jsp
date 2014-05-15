<%@ page contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>${(empty menu || menu=="manage")?"상품 관리":"상품 목록 조회"}</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">

<script type="text/javascript">
function fncGetList(currentPage){
	document.getElementById("currentPage").value=currentPage;
	document.detailForm.submit();
}
</script>

<link rel="stylesheet" href="/css/admin.css" type="text/css">

</head>

<body bgcolor="#ffffff" text="#000000">
<div style="width:98%; margin-left:10px;">

<form name="detailForm" action="/minishop/product/listProduct?menu=${(empty menu || menu=='manage')?'manage':'search'}" method="post">

<table width="100%" height="37" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="15" height="37"><img src="/images/ct_ttl_img01.gif" width="15" height="37"></td>
		<td background="/images/ct_ttl_img02.gif" width="100%" style="padding-left:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="93%" class="ct_ttl01">
						${menu=="manage"?"상품 관리":"상품 목록 조회"}
					</td>
				</tr>
			</table>
		</td>
		<td width="12" height="37"><img src="/images/ct_ttl_img03.gif" width="12" height="37"></td>
	</tr>
</table>


<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>

		<td align="right">
			<select name="searchCondition" class="ct_input_g" style="width:80px">
				<option value="0" ${search.searchCondition==0? "selected":"" }>상품번호</option>
				<option value="1" ${search.searchCondition==1? "selected":"" }>상품명</option>
				<option value="2" ${search.searchCondition==2? "selected":"" }>상품가격</option>
			</select>
			<input type="text" name="searchKeyword" value="${search.searchKeyword}" class="ct_input_g" style="width:200px; height:19px" >
		</td>
	

		<td align="right" width="70">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="17" height="23"><img src="/images/ct_btnbg01.gif" width="17" height="23"></td>
					<td background="/images/ct_btnbg02.gif" class="ct_btn01" style="padding-top:3px;">
						<a href="javascript:fncGetList(1);">검색</a>
					</td>
					<td width="14" height="23"><img src="/images/ct_btnbg03.gif" width="14" height="23"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>



<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td colspan="11" >전체 ${page.totalCount} 건수, 현재 ${page.currentPage} 페이지</td>
	</tr>
	<tr>
		<td class="ct_list_b" width="100">상품No</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">상품명</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b" width="150">가격</td>
		<td class="ct_line02"></td>
		<td class="ct_list_b">등록일</td>	
		<td class="ct_line02"></td>
		<td class="ct_list_b">현재상태</td>	
	</tr>
	<tr>
		<td colspan="11" bgcolor="808285" height="1"></td>
	</tr>
	
	<c:forEach var="i" items="${list}">
	<tr class="ct_list_pop">
		<td align="center">${i.prodNo}</td>
		<td></td>
		
		<td align="left">
		<c:if test="${user.role=='admin' || empty i.proTranCode}">
			<c:if test="${menu=='search'}">
				<a href="/minishop/product/getProduct?prodNo=${i.prodNo}">
			</c:if>
			<c:if test="${menu=='manage' && empty i.proTranCode}">
				<a href="/minishop/product/updateProductView?prodNo=${i.prodNo}">
			</c:if>
		</c:if>${i.prodName}</a></td>

		<td></td>

		<td align="left">${i.price}</td>

		<td></td>

		<td align="left">${i.regDate}</td>
		<td></td>

		<td align="left">
		<c:if test="${user.role=='admin'}">
			<c:if test="${!empty i.proTranCode}">
				<c:if test="${i.proTranCode=='0  '}">
					구매완료
					<c:if test="${menu=='manage'}">
						<a href="/minishop/purchase/updateTranCodeByProd?prodNo=${i.prodNo}&tranCode=1"> 배송하기</a>
					</c:if>
				</c:if>
				<c:if test="${i.proTranCode=='1  '}">
					배송 중
				</c:if>
				<c:if test="${i.proTranCode=='2  '}">
					배송 완료
				</c:if>
			</c:if>
			<c:if test="${empty i.proTranCode}">
				판매중
			</c:if>
		</c:if>
		<c:if test="${user.role=='user' || empty user.role}">
			${empty i.proTranCode?'판매중':'재고없음'}
		</c:if>
		</td>	
	</tr>
	
	<tr>
		<td colspan="11" bgcolor="D6D7D6" height="1"></td>
	</tr>
	</c:forEach>
		
</table>

<table width="100%" border="0" cellspacing="0" cellpadding="0" style="margin-top:10px;">
	<tr>
		<td align="center">
			<input type="hidden" id="currentPage" name="currentPage" value=""/>
			<c:import url="/common/pageNavigator.jsp"/>
    	</td>
	</tr>
</table>
<!--  페이지 Navigator 끝 -->

</form>

</div>
</body>
</html>
