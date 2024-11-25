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
<body>W
<jsp:useBean id="sellerDAO"
             class="stu.cn.ua.dao.SellerDAO" scope="application"/>
<h1>Seller page</h1>
<form method="post" action="seller_search.jsp">
    <label for="sellername">Enter Seller Name:</label>
    <input type="text" id="sellername" name="sellername" required/>
    <input type="submit" value="Search"/>
</form>
<form method="post" action="seller">
    <table style="width:100%" border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Email</td>
            <td>Action</td>
        </tr>
        <c:forEach var="seller" items="${sellerDAO.allEntities}">
            <tr>

                <td>
                    <c:out value="${seller.id}"/>
                </td>
                <td>
                    <c:out value="${seller.name}"/>

                </td>
                <td>
                    <c:out value="${seller.email}"/>
                </td>
                <td>
                    <c:url var="deleteUrl" value="/deleteseller.jsp">
                        <c:param name="sellerid" value="${seller.id}"/>
                        <c:param name="sellername" value="${seller.name}"/>
                        <c:param name="selleremail"
                                 value="${seller.email}"/>
                    </c:url>
                    <c:url var="updateUrl" value="/updateseller.jsp">
                        <c:param name="sellerid" value="${seller.id}"/>
                        <c:param name="sellername" value="${seller.name}"/>
                        <c:param name="selleremail"
                                 value="${seller.email}"/>
                    </c:url>
                    <p><a href="${deleteUrl}">Delete seller</a></p>
                    <p><a href="${updateUrl}">Update seller</a></p>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>
            </td>
            <td>
                <input type="text" name="sellername"/>
            </td>
            <td>
                <input type="text" name="selleremail"/>
            </td>
            <td>
                <input type="hidden" name="actiontype" value="addseller"/>
                <input type="submit" name="addseller" value="Add seller">
            </td>
        </tr>
    </table>
</form>
<div style="text-align: center; margin-bottom: 20px;">
    <a href="product.jsp">
        <button style="padding: 10px 20px; font-size: 16px; background-color: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer;">
            Go to Product page
        </button>
    </a>
</div>
</body>
</html>