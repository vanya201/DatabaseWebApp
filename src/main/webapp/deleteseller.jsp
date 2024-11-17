<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Delete seller</title>
</head>
<body>
<p>Below seller will be deleted:</p>
<p>Seller id ${param.sellerid}</p>
<p>Seller name ${param.sellername}</p>
<p>Seller description ${param.seleremail}</p>
<p>Could you please confirm?</p>
<c:url var="sellerUrl" value="/seller.jsp"/>
<form method="post" action="seller">
    <input type="hidden" name="actiontype" value="deleteseller"/>
    <input type="hidden" name="sellerid" value="${param.sellerid}">
    <input type="submit" name="deleteseller" value="Delete seller">
    <input type= "button" onclick="window.location.href='${sellerUrl}'"
           value="Cancel">
</form>
</body>
</html>