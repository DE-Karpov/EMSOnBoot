<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <script src="https://js.cx/libs/animate.js"></script>
</head>

<body id="WelcomeClass">
<div id="box">
    <div class="WelcomeText">
        <a id="EMS"><h1>EMS</h1></a>
        <p class="WritingTextInMainPage">Welcome to Express Mail Shop! </p>
    </div>
    <a type="button" href="login.ftl">
        <button class="buttonsInMainPage" id="but1"> Sign In</button>
    </a>
    <p></p>
    <a type="button" href="registration.ftl">
        <button class="buttonsInMainPage" id="but2">Sign Up</button>
    </a>

    <div id="fotter">
        <p> KARPOV & MUSINA TEAM 2019</p>
    </div>
</div>
<script>
    document.body.style.overflow = 'hidden';
    document.getElementById("box").style.height = document.documentElement.clientHeight - 20 + 'px';
    document.getElementById("box").style.width = document.documentElement.clientWidth - 20 + 'px';

    var wrapper = document.querySelector(".WelcomeText");
    var text = document.querySelector(".WritingTextInMainPage");

    var textCont = text.textContent;
    text.style.display = "none";

    for (var i = 0; i < textCont.length; i++) {
        (function (i) {
            setTimeout(function () {
                // Created textNode to append
                var texts = document.createTextNode(textCont[i])
                var span = document.createElement('span');
                span.appendChild(texts);

                span.classList.add("wave");
                wrapper.appendChild(span);

            }, 500 * i);
        }(i));
    }


</script>
</body>
</html>