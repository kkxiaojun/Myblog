<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>

<head>
<title>后台模板管理系统</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 设配移动端 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value="/style/css/reset.css"/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/style/css/background.css"/>" />

</head>

<body>
	<header id="header">
		<div class="logo">博客后台管理系统</div>
		<nav class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li>${sessionScope.username}</li>
				<li><a href="/SignOut">退出</a></li>
			</ul>
		</nav>
	</header>
	<section id="content">
		<nav class="left_menu">
			<ul id="nav_dot">
				<li>
					<h4 class="M1">
						<span></span>后台设置
					</h4>
					<div class="list-item none">
						<a href="/doModify">基本资料</a> <a href="/doUser/admin/userModify">密码修改</a>
					</div>
				</li>
				<li>
					<h4 class="M2">
						<span></span>博文管理
					</h4>
					<div class="list-item none">
						<a href="admin/doMarticle?currPage=1">文章管理</a> <a
							href="admin/doCatagory?currPage=1">类别管理</a> <a
							href="admin/doReply?currPage=1">评论管理</a> <a
							href="admin/doPublish">写新文章</a>
					</div>
				</li>
				<li>
					<h4 class="M3">
						<span></span>DEMO管理
					</h4>
					<div class="list-item none">
						<a href="doDemo/admin/1">DEMO列表</a> 
						<a href="admin/doDemoPublish">新增DEMO</a>
					</div>
				</li>
			</ul>
		</nav>
		<div class="m-right">
			<div class="right-nav">
				<h2 class="b_title">系统公告:欢迎来到后台操作界面</h2>
				<p class="b_content"></p>
			</div>
			<div class="main"></div>
		</div>
	</section>
	<footer id="footer">
		<p>Copyright &copy; 2017 JUN. All Rights Reserved.</p>
	</footer>
	<script type="text/javascript"
		src="<c:url value="/style/js/jquery-1.8.3.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/style/js/menu.js"/>"></script>
</body>

</html>
