<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Category List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Category List</h2>
    <div class="d-flex justify-content-between mb-3">
        <form class="d-flex" action="list_user" method="get">
            <input class="form-control me-2" type="search" placeholder="Search" name="search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <a href="create_user.jsp" class="btn btn-primary"><button type="button">Create</button></a>
    </div>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th><a href="?sort=id">Category_Id</a></th>
            <th><a href="?sort=category_name">Category_Name</a></th>

            <th><a href="?sort=description">description</a></th>

            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td>${category.id}</td>
                <td>${category.category_name}</td>
                <td>${category.description}</td>

                <td>
                    <a href="Edit_Category?id=${category.id}" class="btn btn-warning btn-sm">Edit</a>
                </td>
                <td>
                    <form action="delete_Category" method="POST" style="display:inline;">
                        <input type="hidden" name="id" value="${category.id}"/>
                        <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="admin.jsp" class="btn btn-primary">Back to Admin</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
