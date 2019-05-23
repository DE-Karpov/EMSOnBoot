<#ftl encoding='UTF-8'>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignIn Page</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
</head>

<body class="mainClass">
<#if error??>
    <div class="alert" role="alert">Wrong login or password.</div>
</#if>
<form method="post" action="/login">
    <h1 style="color: white; text-align: center">Sign In</h1>
    <div class="EmailInput">
        <label>Login</label>
        <input type="text" placeholder="Enter login" name="login" id="login">
    </div>
    <div class="PasswordInput">
        <label>Password</label>
        <input type="password" placeholder="Password" name="password" id="password">
    </div>
    <br>
    <div>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Remember me
        </label>
    </div>
    <button type="submit">Submit</button>
</form>
<div id="fotter">
    <p> KARPOV & MUSINA TEAM 2019</p>
</div>

</body>
</html>