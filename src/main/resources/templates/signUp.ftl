<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
                <a class="nav-link" href="/login">Sign In</a>
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

<form  method="post" action="/signUp">
    <h1 style="color: white; text-align: center">Sign Up</h1>
    <div class="NameInput">
        <label>Name and Surname</label>
        <input type="text" placeholder="Name Surname" name="name" id="name">
    </div>
    <div class="LoginInput">
        <label>Login</label>
        <input type="text" placeholder="Enter login" name="login" id="login>
    </div>
    <div class=" PasswordInput">
        <label>Password</label>
        <input type="password" placeholder="Password" name="password" id="password">
    </div>
    <div class="AgeInput">
        <label>Age</label>
        <input type="password" placeholder="20" name="age" id="age">
    </div>
    <div class="GenderCheck">
        Gender
        <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" id="f" name="gender" value="F" class="custom-control-input">
            <label class="custom-control-label" for="f">F</label>
        </div>
        <div class="custom-control custom-radio custom-control-inline">
            <input type="radio" id="m" name="gender" value="M" class="custom-control-input">
            <label class="custom-control-label" for="m">M</label>
        </div>
    </div>

    <button type="submit" class="subbmitButton">Submit</button>
</form>
<div id="fotter">
    <p> KARPOV & MUSINA TEAM 2019</p>
</div>

</body>
</html>