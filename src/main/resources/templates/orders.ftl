<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Orders</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="style.css" type="text/css">
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

<body class="mainClass1">

<div id="box1">
    <#include "navbar.ftl">
    <div class="informayion">
        <div class="NameInput" style="padding: 10px">
            <#list ordersFromServer as order>
                <tr>
                    <td>${order.name}</td>
                </tr>
            </#list>
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