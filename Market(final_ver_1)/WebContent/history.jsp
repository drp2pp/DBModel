<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>열어본 상품 보기</title>

</head>
<body>
당신의 WishList
<br>
<br>
<c:forTokens var="i" items="${history }" delims=",">
<a href="/minishop/product/getProduct?prodNo=${i}&menu=search"
	target="rightFrame">${i}</a>
<br>
</c:forTokens>

</body>
</html>