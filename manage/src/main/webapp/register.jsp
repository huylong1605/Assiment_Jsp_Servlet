<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/15/2024
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        .login-container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f8f9fa;
        }
        .login-form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        .login-form h2 {
            margin-bottom: 20px;
        }
    </style>
</head>

<body>

<div class="login-container">
    <form class="login-form" action="register" method="post">
        <h2 class="text-center">Register</h2>
        <div class="form-group">

            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" name="username"  required>
             <p style="color: red"> ${message2} </p>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">

            <label for="re_password">re_Password:</label>
            <input type="password" class="form-control" id="re_password" name="re_password" required>
            <p style="color: red"> ${message1} </p>
        </div>
        <div class="form-group">
            <label for="phone">Phone number:</label>
            <input type="phone" class="form-control" id="phone" name="phone" required>
            <% if (request.getAttribute("message3") != null) { %>
            <p style="color:red;"><%= request.getAttribute("message3") %></p>
            <% } %>
            <% if (request.getAttribute("message4") != null) { %>
            <p style="color:red;"><%= request.getAttribute("message4") %></p>
            <% } %>
        </div>
        <button type="submit" class="btn btn-primary btn-block">register</button>
    </form>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

