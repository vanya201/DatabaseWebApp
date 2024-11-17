<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update seller</title>
</head>
<body>
<p>Please update product fields and press
    Update product button or press Cancel button.</p>
<c:url var="sellerUrl" value="/seller.jsp"/>
<form method="post" action="seller">
    <input type="hidden" name="actiontype" value="updateseller"/>
    <input type="hidden" name="sellerid" value="${param.sellerid}"/>
    <p>Seller id: <c:out value="${param.sellerid}"/></p>
    <p>Product name:
        <input type="text" name="sellername" value="${param.sellername}"/></p>
    <p>Product description:
        <input type="text" name="selleremail"
               value="${param.selleremail}"/></p>
    <input type="submit" name="updateseller" value="Update seller"/>
    <input type= "button" onclick="window.location.href='${sellerUrl}'"
           value="Cancel">
</form>
</body>
</html>