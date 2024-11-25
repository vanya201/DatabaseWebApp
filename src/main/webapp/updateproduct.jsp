<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update product</title>
</head>
<body>
<p>Please update product fields and press
    Update product button or press Cancel button.</p>
<c:url var="productUrl" value="/product.jsp"/>
<form method="post" action="product">
    <input type="hidden" name="actiontype" value="updateproduct"/>
    <input type="hidden" name="productid" value="${param.productid}"/>
    <p>Product id: <c:out value="${param.productid}"/></p>
    <p>Product name:
        <input type="text" name="productname" value="${param.productname}"/></p>
    <p>Product description:
        <input type="text" name="productdescription"
               value="${param.productdescription}"/></p>
    <p>Product Seller:
        <select name="sellerId">
            <c:forEach var="seller" items="${sellerDAO.allEntities}">
                <option value="${seller.id}">${seller.name}</option>
            </c:forEach>
        </select>
    <input type="submit" name="updateproduct" value="Update product"/>
    <input type= "button" onclick="window.location.href='${productUrl}'"
        value="Cancel">
        </form>
       </body>
       </html>