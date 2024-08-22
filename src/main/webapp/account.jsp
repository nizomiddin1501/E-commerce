
<%@ page import="uz.developers.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  HttpSession sessions = request.getSession(false);
  User user = (User) request.getAttribute("user");
  User user1 = new User();


%>

<html>
<head>

    <title>Account</title>

</head>
<body>



<%@include file="includes/navbar.jsp" %>
<div class="container mt-5">
  <h2>Account Information</h2>

  <div class="container">
    <h2>Account Information</h2>
    <p><strong>Name:</strong> <%= user.getName()%></p>
    <p><strong>Email:</strong> <%= user.getEmail() %></p>
    <p><strong>Password:</strong> <%= user.getPassword()%></p>
    <p><strong>Photo:</strong> <img src="<%= user.getPhoto() %>" alt="Profile Picture" class="rounded-circle" style="width: 100px; height: 100px;"></p>
    <p><strong>Account:</strong> <%= user.getAccount()%></p>
  </div>





</div>





</body>
</html>
