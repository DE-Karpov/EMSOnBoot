<#ftl encoding='UTF-8'>
<!DOCTYPE html>

<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>SignIn Page</title>

    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
</head>

<body class="mainClass">

<nav class="navbar navbar-expand-lg navbar-light" id="nav" style="background-color: black;">
    <a class="navbar-brand" href="#" style="background-color: black;color: #f0dd24">Menu</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown" style="background-color: #f0dd24; color: #f0dd24">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/main">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/signUp">Sign Up</a>
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
        </ul>
    </div>
</nav>
<#if error??>
    <div class="alert" role="alert" style="color: white">Wrong login or password.</div>
</#if>
<form method="post" action="/login">
    <h1 style="color: white; text-align: center">Login</h1>
    <div class="LoginInput">
        <label>Login</label>
        <input type="text" placeholder="Enter login" name="login" id="login">
    </div>
    <div class="PasswordInput">
        <label>Password</label>
        <input type="password" placeholder="Password" name="password" id="password">
    </div>
    <div class="RemeberCheck">
        <div class="custom-control custom-radio custom-control-inline">
            <input type="checkbox" id="remember-me" name="remember-me" class="custom-control-input">
            <label class="custom-control-label" for="remember-me">Remember me</label>
        </div>
    </div>
    <button type="submit" class="subbmitButton">Submit</button>
</form>
<div id="fotter">
    <p> KARPOV & MUSINA TEAM 2019</p>
</div>

</body>
</html>