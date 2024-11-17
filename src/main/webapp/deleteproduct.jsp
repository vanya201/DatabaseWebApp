<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Delete product</title>
</head>
<body>
<p>Below product will be deleted:</p>
<p>Product id ${param.productid}</p>
<p>Product name ${param.productname}</p>
<p>Product description ${param.productdescription}</p>
<p>Could you please confirm?</p>
<c:url var="productUrl" value="/product.jsp"/>
<form method="post" action="product">
    <input type="hidden" name="actiontype" value="deleteproduct"/>
    <input type="hidden" name="productid" value="${param.productid}">
    <input type="submit" name="deleteproduct" value="Delete product">
    <input type= "button" onclick="window.location.href='${productUrl}'"
           value="Cancel">
</form>
</body>
</html>