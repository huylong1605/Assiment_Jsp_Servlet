<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Employee</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Edit Employee</h2>
    <form action="edit" method="post">
        <div class="mb-3">
            <input type="hidden" name="id" value="${user.id}" />
        </div>
        <div class="mb-3">
            <label for="username" class="form-label">Username:</label>
            <input type="text" class="form-control" id="username" name="username" value="${user.userName}" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" name="password" value="${user.password}" required>
        </div>
        <div class="mb-3">
            <label for="phoneNumber" class="form-label">phoneNumber:</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" required>
        </div>
        <div class="mb-3">
            <label for="role" class="form-label">role:</label>
            <%--<input type="text" class="form-control" id="role" name="role" value="${user.role}" required>--%>
                <select class="form-select" id="role" name="role" required>
                    <option value="admin" ${user.role eq 'admin' ? 'selected' : ''}>Admin</option>
                    <option value="manager" ${user.role eq 'manager' ? 'selected' : ''}>Manager</option>
                    <option value="user" ${user.role eq 'user' ? 'selected' : ''}>User</option>
                </select>
        </div>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
