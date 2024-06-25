<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Dashboard</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link rel="stylesheet" href="stylee.css">
</head>
<body>
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Admin Dashboard</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav ml-auto">

      <li class="nav-item">
        <a  class="nav-link" href="list_user">Users</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="categoryList">category</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ListProductCategory">Products</a>
      </li>
    </ul>
  </div>
</nav>

<!-- Main Content -->
<div class="container mt-4">
  <!-- Users Section -->
  <section id="users" class="mb-4">
    <h2>Manage Users</h2>
    <div class="table-responsive">
      <table class="table table-bordered">
        <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Email</th>
          <th>Role</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>1</td>
          <td>John Doe</td>
          <td>john@example.com</td>
          <td>Admin</td>
          <td>
            <button class="btn btn-sm btn-primary">Edit</button>
            <button class="btn btn-sm btn-danger">Delete</button>
          </td>
        </tr>
        <!-- More rows can be added dynamically or from backend -->
        </tbody>
      </table>
    </div>
  </section>

  <!-- Products Section -->
  <section id="products">
    <h2>Manage Products</h2>
    <div class="table-responsive">
      <table class="table table-bordered">
        <thead>
        <tr>
          <th>#</th>
          <th>Name</th>
          <th>Price</th>
          <th>Category</th>
          <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr>
          <td>1</td>
          <td>Product A</td>
          <td>$100</td>
          <td>Electronics</td>
          <td>
            <button class="btn btn-sm btn-primary">Edit</button>
            <button class="btn btn-sm btn-danger">Delete</button>
          </td>
        </tr>
        <!-- More rows can be added dynamically or from backend -->
        </tbody>
      </table>
    </div>
  </section>
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
