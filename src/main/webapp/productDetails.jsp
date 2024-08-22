<%@ page import="uz.developers.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/22/2024
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
%>
<html>
<head>
    <title>Product Details</title>
</head>
<body>


<div class="container">
    <div class="row">
        <div class="col-md-6">
            <img src="images/<%= product.getImage()%>" class="img-fluid" alt="<%= product.getName() %>">
        </div>
        <div class="col-md-6">
            <h2><%= product.getName() %></h2>
            <p>Category: <%= product.getCategory() %></p>
            <p>Price: $<%= product.getPrice() %></p>
            <form action="/purchase" method="post">
                <input type="hidden" name="productId" value="<%= product.getId() %>">
                <button type="submit" class="btn btn-success">Buy Now</button>
                <a href="/purchase?id=<%= product.getId() %>" class="btn btn-primary">Buy</a>
            </form>
        </div>
    </div>
</div>




</body>
</html>
