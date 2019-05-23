<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
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
<div id="box1">
    <div class="WelcomeText">
        <p style="color: white">Dear, ${user}</p>
        <p class="WritingTextInMainPage">Welcome to Express Mail Shop!</p>
    </div>

    <table class="UserInfo">
        <tr>
            <td>
                <div class="NameInput" style="padding: 10px">
                    <label>Name and Surname</label>
                </div>
            </td>

            <td>
                <div class="EmailInput" style="padding: 10px">
                    <label>Email address</label>
                </div>
            </td>
            <td>
                <div class="AgeInput" style="padding: 10px">
                    <label>Age</label>
                </div>
            </td>
            <td>
                <div class="GenderCheck" style="padding: 10px">
                    <label>Gender</label>
                </div>
            </td>
        </tr>

        <tr>
            <td>
                <div class="AddressInfo" style="padding: 10px">
                    Address information
                </div>
            </td>
            <td>
                <div class="Phone" style="padding: 10px">
                    Phone Number
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <p>

                </p>
            </td>
            <td>
                <p>

                </p>
            </td>
            <td>
                <p>

                </p>
            </td>
            <td>
                <p>

                </p>
            </td>
            <td>
                <div class="butn">
                    <a href="/login">
                        <button style="margin-right: 0; text-align: center;">LOGOUT</button>
                    </a>
                </div>
            </td>
        </tr>


    </table>


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