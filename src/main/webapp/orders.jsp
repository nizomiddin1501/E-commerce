<%@ page import="uz.developers.model.User" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/16/2024
  Time: 5:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
//        response.sendRedirect("index.jsp");
    }
//    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
//    List<Cart> cartProduct = null;
//    if (cart_list != null) {
//        request.setAttribute("cart_list", cart_list);
//    }
%>
<html>
<head>



    <title>Orders</title>
    <%@include file="includes/head.jsp"%>
    
</head>
<body>
<%@include file="includes/navbar.jsp"%>




<%@include file="includes/footer.jsp"%>
</body>
</html>
