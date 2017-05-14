<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<head>
<title>blog-login</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 设配移动端 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- Custom Theme files -->
<link rel="stylesheet" href="<c:url value="/style/css/reset.css"/>"
	type="text/css" media="all" />
<link rel="stylesheet" href="<c:url value="/style/css/main.css"/>"
	type="text/css">

</head>

<body>
	<header>
		<div class="logo">
			<a href="index.html"><img
				src="<c:url value="/style/img/logo.png"/>" alt="Foto"></a>
		</div>
		<div id="menu_icon"></div>
		<nav id="nav_menu">
			<ul>
                <li class="selected"><a href="/doHome">Home</a> </li>
                <li><a href="/doArticle">Aticle</a></li>
                <li><a href="/doDemo">Demo</a> </li>
                <li><a href="/doContact">Contact</a> </li>
			</ul>
		</nav>
		<div class="social_widget">
			<div class="sm">
				<ul>
	                    <li><a href="#" target="_blank" class="fb"><i></i></a><span></span></li>
                    <li><a href="http://weibo.com/kkxiaojun" target="_blank" class="t"><i></i></a> </li>
                    <li><a href="https://github.com/kkxiaojun" target="_blank" class="g"><i></i></a></li>
					<li><a href="#" target="_blank" class="mail"><i></i></a></li>
				</ul>
			</div>
		</div>
	</header>
	<!-- End header  -->
	<section class="main">
		<ul id="slider">
			<li><img src="<c:url value="/style/img/hero4.jpg"/>" title="" /></li>
			<li><img src="<c:url value="/style/img/hero2.jpg"/>" title="" /></li>
			<li><img src="<c:url value="/style/img/hero3.jpg"/>" title="" /></li>
		</ul>
		<!-- End slider  -->
		<!-- End hero_img-->
		<div class="main_content">
			<h1>个人介绍</h1>
			<hr>
			<p class="info"> ${user.info} </p>
			<ul class="contact">
				<li><i class="iconfont">&#xe60b;</i><span class="contact_email"> ${user.email} </span></li>
				<li><i class="iconfont">&#xe603;</i><span class="contact_phone"> ${user.phone} </span></li>
				<li><i class="iconfont">&#xe616;</i><span class="contact_qq"> ${user.qq} </span></li>
			</ul>
		</div>
		<!-- End main_content-->
	</section>
	<!-- End main  -->
	<script src="<c:url value="/style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="/style/js/slider.js"/>"></script>
	<script src="<c:url value="/style/js/main.js"/>"></script>
</body>

</html>
