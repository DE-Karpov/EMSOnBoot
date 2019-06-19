<!DOCTYPE html>
<html lang="en">
<head>
    <title>Profile</title>
    <#include "head.ftl">
</head>
<body class="mainClass1">
<div id="box1">
    <#include "navbar.ftl">
    <br>
    <div class="WelcomeText">
        <p style="color: white">Dear, ${user}</p>
        <p class="WritingTextInMainPage">Welcome to Express Mail Shop!</p>
    </div>
    <div class="informayion">
        <div class="NameInput" style="padding: 10px">
            <label>Username: </label>
            <label>${user}</label>
        </div>
        <div class="EmailInput" style="padding: 10px">
            <label>Login: </label>
            <label>${login}</label>
        </div>

        <div class="AgeInput" style="padding: 10px">
            <label>Age: </label>
            <label>${age}</label>
        </div>

        <div class="GenderCheck" style="padding: 10px">
            <label>Gender: </label>
            <label>${gender}</label>
        </div>

        <div class="AddressInfo" style="padding: 10px">
            <label>Address information: <label>
                    <label>${address}</label>
        </div>

        <div class="Phone" style="padding: 10px">
            <label>Phone Number: <label>
        </div>

    </div>

    <div id="fotter">
        <p> KARPOV & MUSINA TEAM 2019</p>
    </div>
</div>
<script>
    document.body.style.overflow = 'hidden';
    document.getElementById("box1").style.height = document.documentElement.clientHeight - 20 + 'px';
    document.getElementById("box1").style.width = document.documentElement.clientWidth - 20 + 'px';

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