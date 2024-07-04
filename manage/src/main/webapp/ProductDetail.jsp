<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Detail</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-image {
            max-width: 100%;
            height: auto;
        }
        .product-info {
            margin-top: 20px;
        }
        .product-title {
            font-size: 2em;
            margin-bottom: 10px;
        }
        .product-price {
            font-size: 1.5em;
            color: #28a745;
            margin-bottom: 20px;
        }
        .product-description {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <img src="${product.description}" alt="Product Image" class="product-image">
        </div>
        <div class="col-md-6">
            <div class="product-info">
                <h1 class="product-title">${product.product_name}</h1>
                <p class="product-price">$${product.price}</p>
                <p class="product-description">${product.created_at}</p>
                <a class="btn btn-primary" href="addToCart?Pid=${product.product_id}" role="button">Add to Cart</a>
                <button class="btn btn-secondary">Buy Now</button>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
