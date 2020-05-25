<!DOCTYPE html>
<html lang="en">
<head>
    <title>Users</title>
    <script src="/js/banUser.js"></script>
    <#include "head.ftl">
</head>

<body class="mainClass1">

<div style="color:white">
    <#include "navbar.ftl">
    <#list users as user>
        <p>${user.login} ${user.role} ${user.state}
            <#if user.role.toString() != "ADMIN">
            <button class="btn btn-warning" onclick="banUser(${user.id}, '${user.state.toString()}')">
                <#assign u = user.state.toString()>
                <#if u == "ACTIVE">
                    BAN
                <#else>
                    RESTORE
                </#if>
                </#if>
            </button>
        </p>
    </#list>
</div>
<div id="fotter">
    <p> KARPOV & MUSINA TEAM 2019</p>
</div>
</body>
</html>