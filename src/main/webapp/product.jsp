<%@ page import="stu.cn.ua.domain.Seller" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product list</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:useBean id="productDAO"
             class="stu.cn.ua.dao.ProductDAO" scope="application"/>
<jsp:useBean id="sellerDAO"
             class="stu.cn.ua.dao.SellerDAO" scope="application"/>
<h1>Product page</h1>
<form method="post" action="product">
    <table style="width:100%" border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Description</td>
            <td>Seller</td>
            <td>Action</td>
        </tr>
        <c:forEach var="product" items="${productDAO.allEntities}">
            <tr>
                <td>
                    <c:out value="${product.id}"/>
                </td>
                <td>
                    <c:out value="${product.name}"/>

                </td>
                <td>
                    <c:out value="${product.description}"/>
                </td>
                <td>
                    <c:if test="${product.seller != null}">
                        <c:out value="${product.seller.name}"/>
                    </c:if>
                </td>
                <td>
                    <c:url var="deleteUrl" value="/deleteproduct.jsp">
                        <c:param name="productid" value="${product.id}"/>
                        <c:param name="productname" value="${product.name}"/>
                        <c:param name="productdescription"
                                 value="${product.description}"/>
                    </c:url>
                    <c:url var="updateUrl" value="/updateproduct.jsp">
                        <c:param name="productid" value="${product.id}"/>
                        <c:param name="productname" value="${product.name}"/>
                        <c:param name="productdescription"
                                 value="${product.description}"/>
                        <c:param name="productSellerId"
                                 value="${product.seller.id}"/>
                    </c:url>
                    <p><a href="${deleteUrl}">Delete product</a></p>
                    <p><a href="${updateUrl}">Update product</a></p>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
            </td>
            <td>
                <input type="text" name="productname"/>
            </td>
            <td>
                <input type="text" name="productdescription"/>
            </td>
            <td>
                <select name="sellerId">
                    <c:forEach var="seller" items="${sellerDAO.allEntities}">
                        <option value="${seller.id}">${seller.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="hidden" name="actiontype" value="addproduct"/>
                <input type="submit" name="addproduct" value="Add product">
            </td>

        </tr>
    </table>
</form>
<div style="text-align: center; margin-bottom: 20px;">
    <a href="seller.jsp">
        <button style="padding: 10px 20px; font-size: 16px; background-color: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer;">
            Go to Seller page
        </button>
    </a>
</div>
</body>
</html>