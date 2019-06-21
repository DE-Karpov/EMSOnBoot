<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light" id="nav" style="background-color: black;">
    <a class="navbar-brand" href="#" style="background-color: black;color: #f0dd24">Menu</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown" style="background-color: #f0dd24; color: #f0dd24">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/profile">Profile<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/orders">Orders</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/products">Products<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Links
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="https://www.rambler.ru">email</a>
                    <a class="dropdown-item" href="https://www.instagram.com/euphoriaendlesss">Instagram</a>
                    <a class="dropdown-item" href="https://wwww.facebook.com/GuzelMusina">Facebook</a>
                </div>
            </li>
            <#if admin??>
                <li class="nav-item active">
                    <a class="nav-link" href="/users">Users<span class="sr-only">(current)</span></a>
                </li>
            </#if>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Log Out</a>
            </li>
        </ul>
    </div>
</nav>
</body>
</html>