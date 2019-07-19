<!DOCTYPE html>
<html lang="en">
<head>
    <title>Orders</title>
    <#include "head.ftl">
</head>

<body class="mainClass1">

<div id="box1">
    <#include "navbar.ftl">
    <div class="informayion">
        <div class="NameInput" style="padding: 10px">
            <#if ordersFromServer ??>
            <tr>
                <td>
                    <div style="color:white; padding:1%; border: 4px solid #f0dd24;">
                        <#list ordersFromServer.productList as product>
                            <h2>${product.name}  ${product.amount} </h2>
                        </#list>
                    </div>
                </td>
            </tr>
                <#else >
                <h2>You haven't orders</h2>
            </#if>
        </div>
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