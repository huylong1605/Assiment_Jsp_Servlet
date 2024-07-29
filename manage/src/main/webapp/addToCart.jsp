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
    <script src="User.js" defer></script>
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
    <br>
    <div id="success-message" class="alert alert-success" role="alert" style="display: none;">
        Đã xóa sản phẩm thành công
    </div>
    <div class="row header-row">
        <div class="col-md-1">Chọn</div>
        <div class="col-md-2">Sản phẩm</div>
        <div class="col-md-3">Tên</div>
        <div class="col-md-2">Số lượng</div>
        <div class="col-md-2">Giá</div>
        <div class="col-md-2">Thao tác</div>
    </div>
    <!-- Loop through cart items -->
    <c:forEach var="item" items="${CartList}">
        <div class="row cart-item">
            <div class="col-md-1">
                <input type="checkbox" class="form-check-input" name="selectedProducts" value="${item.cart_id}">
            </div>
            <div class="col-md-2">
                <img src="${item.description}" class="img-fluid" alt="Product Image">
            </div>
            <div class="col-md-3">
                <h4>${item.product_name}</h4>
                <p>Category: ${item.category_name}</p>
                <p>Date Added: ${item.add_date}</p>
            </div>
            <div class="col-md-2">
                <input type="number" class="form-control" value="${item.quantity}">
            </div>
            <div class="col-md-2">
                <p class="price">${item.price}</p>
            </div>
            <div class="col-md-2">
                <form action="deleteProductCart" method="POST" style="display:inline;" onsubmit="return confirmDelete('${item.category_name}')">
                    <input type="hidden" name="cartId" value="${item.cart_id}"/>
                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                </form>
            </div>
        </div>
    </c:forEach>

    <div class="row">
        <div class="col-md-12 text-right">
            <p class="total">Total: ${totalPrices}</p> <!-- Calculate total dynamically -->
            <a href="ListProduct" class="btn btn-success">Back Home Shop</a>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="shoppingCart.js" defer></script>
</body>
</html>
