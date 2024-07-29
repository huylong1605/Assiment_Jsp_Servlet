<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="CssHomeShop.css" rel="stylesheet" />
    <STYLE>
        .nav-link .badge {
            font-size: 0.75rem; /* Kích thước chữ của số lượng sản phẩm */
            padding: 0.3em 0.6em; /* Khoảng cách bên trong của số lượng sản phẩm */
            transform: translate(-50%, -50%); /* Định vị lại số lượng sản phẩm */
            top: 20%; /* Điều chỉnh vị trí dọc */
            left: 70%; /* Điều chỉnh vị trí ngang */
        }
    </STYLE>
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="#!">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">All Products</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                        <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                    </ul>
                </li>

            </ul>


            <form class="d-flex">

                <div class="d-flex align-items-center me-3">
                     <c:if test="${sessionScope.role != null}">
                    <span class="me-2">${sessionScope.role.userName}</span>
                    <a class="btn btn-outline-dark" href="logout">Logout</a>
                     </c:if>
                </div>

                <div class="d-flex align-items-center me-3">
                    <a class="nav-link position-relative" href="CartList">
                        <i class="bi bi-cart-fill" style="font-size: 1.5rem; margin-right: 5px;"></i>
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-dark"
                              style="font-size: 0.75rem; padding: 0.3em 0.6em;">
                            ${countCart}
                        </span>
                        Cart
                    </a>
                </div>
            </form>
        </div>
    </div>
</nav>
<!-- Header-->
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Shop in style</h1>
            <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>

        </div>
    </div>
</header>
<!-- Section-->
<section class="py-5">

    <%--<form class="d-flex" method="get" action="ListProduct">
        <!-- Brand Combo Box -->
        <select class="form-select me-2" style=" width: 150px; margin-left: 120px;"  name="category_name">
            <option value="All">Select Brand</option>
            <c:forEach var="c" items="${categoryy}">
                <option value="${c.category_name}">${c.category_name}</option>
            </c:forEach>

        </select>

        <button class="btn btn-outline-dark" type="submit">Filter</button>
    </form>--%>

        <div class="categories">

            <form class="d-flex" action="ListProduct" method="get">
                <select class="form-select me-2" style=" width: 150px; margin-left: 120px;" name="category_name" onchange="this.form.submit()">
                    <option value="">All Categories</option>
                    <c:forEach var="category" items="${categoryy}">
                        <option value="${category.category_name}" ${param.category_name == category.category_name ? 'selected' : ''}>${category.category_name}</option>
                    </c:forEach>
                </select>


            </form>
        </div>

    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach var="productc" items="${products}">
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Product image-->
                    <img class="card-img-top" src="${productc.description}" alt="..." />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">${productc.product_name}</h5>
                            <!-- Product price-->
                                ${productc.price}
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="productDetail?id=${productc.product_id}">View Detail Product</a></div>
                    </div>
                </div>
            </div>

            </c:forEach>

        </div>
    </div>
    <div class="container">
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <c:forEach begin="1" end="${endP}" var="i">
                    <li class="page-item" >

                        <a  class= "page-link ${tag == i ? "active" : " "}" href="ListProduct?category_name=${param.category_name}&index=${i}">${i}</a>

                    </li>

                </c:forEach>

            </ul>
        </nav>
    </div>


</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
