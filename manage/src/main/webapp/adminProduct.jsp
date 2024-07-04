<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Products</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .img-thumbnail {
      width: 100px; /* Set a fixed width */
      height: auto; /* Maintain aspect ratio */
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <h1 class="mb-4">Product List</h1>

  <!-- Create Button -->
  <div class="mb-4">
    <a href="createProduct.jsp" class="btn btn-success">Create New Product</a>
  </div>

  <!-- Search Form -->
  <form method="get" action="searchProducts" class="form-inline mb-4">
    <input type="text" name="query" class="form-control mr-2" placeholder="Search products">
    <button type="submit" class="btn btn-primary">Search</button>
  </form>

  <table class="table table-bordered table-hover">
    <thead class="thead-dark">
    <tr>
      <th>ID</th>
      <th>Product Name</th>
      <th>Price</th>
      <th>Created At</th>
      <th>Category Name</th>
      <th>Description</th>
      <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
      <tr>
        <td>${product.productId}</td>
        <td>${product.product_name}</td>
        <td>${product.price}</td>
        <td>${product.created_at}</td>
        <td>${product.category_name}</td>
        <td><img class="img-thumbnail" src="${product.description}" alt="Product Image" /></td>
        <td>
          <a href="editProduct?id=${product.productId}" class="btn btn-warning btn-sm">Edit</a>
          <a href="deleteProduct?id=${product.productId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <a href="admin.jsp" class="btn btn-primary">Back to Admin</a>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
