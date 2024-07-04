<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="stylee.css">
    <style>
        #sidebar-wrapper {
            width: 250px;
        }

        #sidebar-wrapper .sidebar-heading {
            padding: 0.875rem 1.25rem;
            font-size: 1.2rem;
            font-weight: bold;
        }

        #sidebar-wrapper .list-group {
            width: 100%;
        }

        #sidebar-wrapper .list-group-item {
            border: none;
            border-radius: 0;
            padding: 0.75rem 1.25rem;
        }

        #sidebar-wrapper .list-group-item:hover {
            background-color: #007bff;
            color: white;
        }

        #welcome-message {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 80vh;
            color: #007bff; /* Bootstrap primary color */
        }

        #welcome-message h1 {
            font-size: 4rem;
            font-weight: bold;
        }
    </style>
</head>
<body>
<!-- Top Taskbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Admin Dashboard</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <c:if test="${sessionScope.role != null}">
                <li class="nav-item">
                    <a class="nav-link" href="#">Hello, ${sessionScope.role.userName}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </c:if>
        </ul>
    </div>
    <div class="collapse navbar-collapse" >
        <ul class="navbar-nav ml-auto">
            <c:if test="${sessionScope.role == null}">

                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>

<div class="d-flex">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
        <div class="sidebar-heading">Navigation</div>
        <div class="list-group list-group-flush">
            <c:choose>
<c:when test="${sessionScope.role != null}">
            <a href="list_user" class="list-group-item list-group-item-action" >Users</a>
            <a href="categoryList" class="list-group-item list-group-item-action">Category</a>
            <a href="ListProductCategory" class="list-group-item list-group-item-action">Products</a>
    </c:when>
            <c:otherwise >
                <a href="#" class="list-group-item list-group-item-action" >Users</a>
                <a href="#" class="list-group-item list-group-item-action">Category</a>
                <a href="#" class="list-group-item list-group-item-action">Products</a>
            </c:otherwise>
            </c:choose>
        </div>
    </div>

    <!-- Main Content -->
    <div class="container mt-4" id="page-content-wrapper">
        <div id="welcome-message">
            <h1>Welcome Admin</h1>
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="text-center py-4 bg-dark text-white">
    <div class="container">
        <p>&copy; 2024 Admin Dashboard. All rights reserved.</p>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
