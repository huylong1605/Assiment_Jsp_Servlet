<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/17/2024
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <form class="login-form" action="changePass" method="post">
        <h2 class="text-center">Change Password</h2>
        <div class="form-group">

            <label for="phone">phone:</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${phone}"  >
            <p style="color: red"> ${messagePhone} </p>

        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" value="${pass}" required>
        </div>
        <div class="form-group">

            <label for="re_password">re_Password:</label>
            <input type="password" class="form-control" id="re_password" name="re_password"value="${re_pass}" required>
            <p style="color: red"> ${message} </p>
        </div>

        <button type="submit" class="btn btn-primary btn-block">register</button>
    </form>
</div>
</body>
</html>
