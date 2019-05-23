<#ftl encoding='UTF-8'>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignIn Page</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body class="mainClass">

<#if error??>
    <div class="alert" role="alert" style="color: white">Wrong login or password.</div>
</#if>


<div class="wrapperr">
    <div class="butn">
        <a href="/signUp">
            <button style="margin: auto; text-align: center">SIGNUP</button>
        </a>
    </div>
</div>
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
            <input type="checkbox" id="remeber-me" name="customRadioInline1" class="custom-control-input">
            <label class="custom-control-label" for="remeber-me">Remember me</label>
        </div>
    </div>
    <button type="submit">Submit</button>
</form>
<div id="fotter">
    <p> KARPOV & MUSINA TEAM 2019</p>
</div>

</body>
</html>