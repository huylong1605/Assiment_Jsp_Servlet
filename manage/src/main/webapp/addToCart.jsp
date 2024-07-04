<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .cart-container {
            margin-top: 50px;
        }
        .cart-item {
            padding: 20px 0;
            border-bottom: 1px solid #ddd;
        }
        .total {
            font-size: 1.5rem;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container cart-container">
    <h1 class="text-center">Shopping Cart</h1>

    <!-- Loop through cart items -->
    <c:forEach var="item" items="${CartList}">
        <div class="row cart-item">
            <div class="col-md-2">
                <img src="${item.description}" class="img-fluid" alt="Product Image">
            </div>
            <div class="col-md-4">
                <h4>${item.product_name}</h4>

            </div>
            <div class="col-md-2">
                <input type="number" class="form-control" value="${item.quantity}">
            </div>
            <div class="col-md-2">
                <p class="price">${item.price}</p>
            </div>
            <div class="col-md-2">
                <button class="btn btn-danger">Remove</button>
            </div>
        </div>
    </c:forEach>

    <div class="row">
        <div class="col-md-12 text-right">
            <p class="total">Total: $25.00</p> <!-- Calculate total dynamically -->
            <a href="ListProduct" class="btn btn-success">Back Home Shop</a>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
</body>
</html>
