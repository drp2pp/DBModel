<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
	<c:if test="${page.currentPage <= page.pageUnit }">
		◀ 이전
	</c:if>
	<c:if test="${page.currentPage > page.pageUnit }">
		<a href="javascript:fncGetList('${page.startUnitPage-1}')">◀ 이전</a>
	</c:if>
	
	<c:forEach var="i" begin="${page.startUnitPage}" step="1" end="${page.endUnitPage}">
		<a href="javascript:fncGetList('${i}')">${i}</a>
	</c:forEach>
	
	<c:if test="${page.endUnitPage >= page.totalPage }">
		이후 ▶
	</c:if>
	<c:if test="${page.endUnitPage < page.totalPage }">
		<a href="javascript:fncGetList('${page.endUnitPage+1}')">이후 ▶</a>
	</c:if>