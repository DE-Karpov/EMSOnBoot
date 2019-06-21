<!DOCTYPE html>
<html lang="en">
<head>
    <title>Users</title>
    <#include "head.ftl">
</head>

<body class="mainClass1">

<div id="box1">
    <#include "navbar.ftl">
    <#list users as user>
        <p>${user}</p>
    </#list>
    <div id="fotter">
        <p> KARPOV & MUSINA TEAM 2019</p>
    </div>
</div>
</body>
</html>