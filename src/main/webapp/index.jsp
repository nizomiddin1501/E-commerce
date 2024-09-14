<%@ page import="uz.developers.model.User" %>
<%@ page import="uz.developers.service.ProductService" %>
<%@ page import="uz.developers.service.DbConnection" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.developers.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    User auth = (User) request.getSession().getAttribute("auth");
    if (auth != null) {
        request.setAttribute("auth", auth);
    }

    ProductService productService = new ProductService(DbConnection.getConnection());
    List<Product> products = productService.getAllProduct();

%>
<html>
<head>
    <title>Shopping cart</title>
    <%@include file="includes/head.jsp" %>


</head>
<body>


<%@include file="includes/navbar.jsp" %>


<div class="container">
    <div class="card-header my-3">All Products</div>
    <div class="row">


            <%
                if (  !products.isEmpty()) {
                    for (Product product : products) {%>
            <div class="col-md-3 my-3">
                <div class="card w-100" style="width: 18rem;">
                    <img class="card-img-top" src="images/<%= product.getImage()%>" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><%= product.getImage()%>
                        </h5>
                        <h6 class="price">Price: $<%= product.getPrice()%>
                        </h6>
                        <h6 class="category">Category: <%= product.getCategory()%>
                        </h6>
                        <div class="mt-3 d-flex justify-content-between">
                            <a href="add-to-cart?id=<%= product.getId()%>" class="btn btn-dark">Add to card</a>
                            <a href="productDetails?id=<%= product.getId() %>" class="btn btn-primary">Details</a>
                        </div>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>


    </div>
</div>


<%@include file="includes/footer.jsp" %>
</body>
</html>
