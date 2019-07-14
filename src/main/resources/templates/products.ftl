<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">

    <title>Product</title>

    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/addProduct.js"></script>
    <script src="/js/deleteProduct.js"></script>
    <script src="/js/getCart.js"></script>
    <script src="/js/getAmount.js"></script>
    <link rel="import">

</head>

<body class="mainClass1" onload="getCart()">
<script>
    document.getElementById("box1").style.height = document.documentElement.clientHeight - 20 + 'px';
    document.getElementById("box1").style.width = document.documentElement.clientWidth - 20 + 'px';
</script>

<div id="box2">
    <#if header ??>
        <#include "navbar.ftl">
    <#else>
        <nav class="navbar navbar-expand-lg navbar-light" id="nav" style="background-color: black;">
            <a class="navbar-brand" href="#" style="background-color: black;color: #f0dd24">Menu</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
                    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown"
                 style="background-color: #f0dd24; color: #f0dd24">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="/login">Sign In<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/signUp">Sign Up<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
    </#if>
    <form method="post" action="/products">
        <button type="submit">Submit</button>
    </form>
    <div id="goods_table"></div>
    <ul class="list-unstyled" id="product1">
        <div id="1" onclick="addProduct(1)">
            <li class="media">
                <img src="../img/1.jpg" alt="" style="width: 250px; height: 250px;">
                <div class="media-body">
                    <h5>Cap</h5>
                    <h4>799.–</h4>
                    Frame: Steel, Nickel Plating, Clear lacquer
                    Chain: Steel
                    Safety glass: Polystyrene, Polyethylene
                    Support panel: Corrugated cardboard
                    Back panel: Polypropylene
                </div>
            </li>
        </div>
        <div id="2" onclick="addProduct(2)">
            <li class=" media" id="product2">
                <img src="../img/2.jpg" style="width: 250px; height: 250px;">
                <div class="media-body">
                    <h5>Sneakers</h5>
                    <h4>599.–</h4>
                    The glass Cloche on the stand can be used to showcase your favorite decorative items.
                    Size
                    19 cm
                </div>
            </li>
        </div>
        <div id="3" onclick="addProduct(3)">
            <li class=" media
        " id="product3">
                <img src="../img/3.jpg" style="width: 250px; height: 250px;">>
                <div class="media-body">
                    <h5>T-Shirt</h5>
                    <h4>499.–</h4>
                    Figure of people, wood
                </div>
            </li>
        </div>
        <div>
            <li class="media" id="product4">
                <img src="../img/4.jpg">
                <div class="media-body">
                    <h5>Pillow tight</h5>
                    <h4>2 499.–</h4>
                    Dense cushion with a cover made of cotton sateen and filled with duck down and feathers.
                    The denser interior of the filler is surrounded by a softer layer of down/feather. This ensures
                    optimal
                    support and reduces muscle tension in the neck and shoulders.
                    Double edging makes the pillow higher at the edges and provides free movement of the filler.
                    This pillow is suitable for those who prefer to sleep on the side or on the back. High and dense
                    pillow
                    provides a comfortable support.
                    The pillow can be washed in a washing machine at 60 °C. At this temperature, dust mites die.
                </div>
            </li>
        </div>
        <div>
            <li class="media" id="product5">
                <img src="../img/5.JPG">
                <div class="media-body">
                    <h5>Pedestal for flowers, white</h5>
                    <h4>2 999.–</h4>
                    Allows you to place houseplants in any part of the house.
                </div>
            </li>
        </div>
        <div>
            <li class="media" id="product6">
                <img src="../img/6.JPG">
                <div class="media-body">
                    <h5>Mirror outdoor, ash</h5>
                    <h4>9 999.–</h4>
                    Do you value every minute of your morning sleep? Get your clothes ready for tomorrow and hang them
                    behind the mirror.
                    Clothes can be hung neatly behind the mirror.
                    Suitable for use in most rooms. Tested and approved for use in the bathroom.
                    A special film will protect against splinters if the glass breaks.
                </div>
            </li>
        </div>
    </ul>
    <div id="fotter">
        <p> KARPOV & MUSINA TEAM 2019</p>
    </div>
</div>
</body>
</html>