<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Landing Page with Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">MyCompany</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="#features">Features</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#about">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#contact">Contact</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-primary text-white" href="login.jsp">Login</a>
            </li>
        </ul>
    </div>
</nav>

<!-- Landing Section -->
<header class="jumbotron text-center">
    <div class="container">
        <h1 class="display-4">Welcome to MyCompany</h1>
        <p class="lead">Your solution for amazing web experiences.</p>
        <a href="#login" class="btn btn-primary btn-lg">Get Started</a>
    </div>
</header>

<!-- Features Section -->
<section id="features" class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h3>Feature 1</h3>
                <p>Description of feature 1.</p>
            </div>
            <div class="col-md-4">
                <h3>Feature 2</h3>
                <p>Description of feature 2.</p>
            </div>
            <div class="col-md-4">
                <h3>Feature 3</h3>
                <p>Description of feature 3.</p>
            </div>
        </div>
    </div>
</section>

<!-- About Section -->
<section id="about" class="py-5 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h2>About Us</h2>
                <p>Information about the company.</p>
            </div>
            <div class="col-md-6">
                <h2>Our Mission</h2>
                <p>Details about the company's mission.</p>
            </div>
        </div>
    </div>
</section>

<!-- Contact Section -->
<section id="contact" class="py-5">
    <div class="container">
        <h2>Contact Us</h2>
        <form>
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" required>
            </div>
            <div class="form-group">
                <label for="message">Message</label>
                <textarea class="form-control" id="message" rows="3" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</section>

<!-- Login Section -->
<section id="login" class="py-5 bg-light">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h2 class="text-center">Login</h2>
                <form>
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <input type="email" class="form-control" id="email" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" id="password" required>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Login</button>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="text-center py-4">
    <div class="container">
        <p>&copy; 2024 MyCompany. All rights reserved.</p>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
