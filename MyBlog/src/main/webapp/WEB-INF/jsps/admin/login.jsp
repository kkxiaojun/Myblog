<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>

<head>
    <title>blog-login</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 设配移动端 -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- Custom Theme files -->
    <link rel="stylesheet" href="<c:url value="/style/css/reset.css"/>" type="text/css" >
    <link rel="stylesheet" href="<c:url value="/style/css/login.css"/>" type="text/css" media="all" />
    
</head>

<body id="login">
    <div class="login">
        <h2>博客后台登录</h2>
        <div class="login-top">
            <h1>登录信息</h1>
            <form action="<c:url value="/doLogin"/>" method="post">
                <input type="text" name="username" placeholder="用 户 名">
                <input type="password" name="password" placeholder="密 码">
                <div class="forgot">
                	<a href="#">注册</a>
                <input type="submit" value="login">
            </div>
            </form>
        </div>
        <div class="login-bottom">
            <h3><a href="article/">返回博客</a></h3>
        </div>
    </div>
    <div class="copyright">
        <p>Copyright &copy; 2017 JUN. All Rights Reserved.</p>
    </div>
</body>

</html>
