<%@ page import="uz.developers.model.User" %>
<%@ page import="uz.developers.service.UserProductService" %>
<%@ page import="uz.developers.service.DbConnection" %>
<%@ page import="uz.developers.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/22/2024
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  HttpSession sessions = request.getSession();
  User user = (User) sessions.getAttribute("user");
  UserProductService userProductService = new UserProductService(DbConnection.getConnection());
  List<Product> userProducts = userProductService.getProductsByUserId(user.getId());
%>
<html>
<head>
    <title>My Products</title>
</head>
<body>



<div class="container">
  <h2>Your Purchased Products</h2>
  <div class="row">
    <%
      if (userProducts != null && !userProducts.isEmpty()) {
        for (Product product : userProducts) {
    %>
    <div class="col-md-3 my-3">
      <div class="card w-100" style="width: 18rem;">
        <img class="card-img-top" src="images/<%= product.getImage() %>" alt="<%= product.getName() %>">
        <div class="card-body">
          <h5 class="card-title"><%= product.getName() %></h5>
          <p class="card-text">Price: $<%= product.getPrice() %></p>
        </div>
      </div>
    </div>
    <%
      }
    } else {
    %>
    <p>You haven't purchased any products yet.</p>
    <%
      }
    %>
  </div>
</div>



</body>
</html>
