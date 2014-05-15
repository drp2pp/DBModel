<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">

<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>eMarket</title>

<link href="/css/left.css" rel="stylesheet" type="text/css">

</head>

<body topmargin="0" leftmargin="0">
 
<table width="100%" height="50" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="800" height="30"><h2>eMarket</h2></td>
    <td height="30" >&nbsp;</td>
  </tr>
  <tr>
    <td height="20" align="right" background="/images/img_bg.gif">
    <table width="200" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="115">
          <c:if test="${empty user}">
              <a href="/user/loginView.jsp" target="rightFrame">login</a>   
          </c:if>        
          </td>
          <td width="14">&nbsp;</td>
          <td width="56">
          <c:if test="${!empty user}">
            <a href="/minishop/user/logout" target="_parent">logout</a>  
           </c:if> 
          </td>
        </tr>
      </table>
    </td>
    <td height="20" background="/images/img_bg.gif">&nbsp;</td>
  </tr>
</table>

</body>
</html>
