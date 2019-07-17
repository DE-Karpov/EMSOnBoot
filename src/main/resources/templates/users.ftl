<!DOCTYPE html>
<html lang="en">
<head>
    <title>Users</title>
    <script src="/js/banUser.js"></script>
    <#include "head.ftl">
</head>

<body class="mainClass1">

<div id="box1">
    <#include "navbar.ftl">
    <#list users as user>
        <p>${user.login} ${user.role} ${user.state}
            <button onclick="banUser(${user.id}, '${user.state.toString()}')">
                <#assign u = user.state.toString()>
                <#if u == "ACTIVE">
                    BAN
                <#else>
                    RESTORE
                </#if>
            </button>
        </p>
    </#list>
    <div id="fotter">
        <p> KARPOV & MUSINA TEAM 2019</p>
    </div>
</div>
</body>
</html>