<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="User.js" defer></script>
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">User List</h2>
    <div class="d-flex justify-content-between mb-3">
        <form class="d-flex" action="SearchUser" method="get">
            <input class="form-control me-2" type="search" placeholder="searchUser" id="searchUser" name="searchUser" value="${param.searchUser}" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>

    </div>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th><a href="?sort=id">Id</a></th>
            <th><a href="?sort=userName">User Name</a></th>
            <th>Password</th>
            <th><a href="?sort=phoneNumber">Phone Number</a></th>
            <th><a href="?sort=role">Role</a></th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.role}</td>
                <td>
                    <a href="edit?id=${user.id}" class="btn btn-warning btn-sm">Edit</a>
                </td>
                <td>
                    <form action="deleteUser" method="POST" style="display:inline;" onsubmit="return confirmDelete('${user.userName}')">
                        <input type="hidden" name="id" value="${user.id}"/>
                        <button type="submit" class="btn btn-danger btn-sm" >Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
