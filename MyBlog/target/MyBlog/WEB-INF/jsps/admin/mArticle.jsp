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
	type="text/css" />
<link rel="stylesheet" href="<c:url value="/style/css/background.css"/>"
	type="text/css">

</head>

<body>
	<header id="header">
		<div class="logo">博客后台管理系统</div>
		<nav class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li><a href="#">张山</a></li>
				<li><a href="../setting/modifyPassword.html">修改密码</a></li>
				<li><a href="#">设置</a></li>
				<li><a href="#">退出</a></li>
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
						<a href="/doModify">基本资料</a> <a href="/doUser">密码修改</a>
					</div>
				</li>
				<li>
					<h4 class="M2">
						<span></span>博文管理
					</h4>
					<div class="list-item">
						<a href="doMarticle?currPage=1">文章管理</a> <a
							href="doCatagory?currPage=1">类别管理</a> <a
							href="doReply?currPage=1">评论管理</a> <a
							href="doPublish">写新文章</a>
					</div>
				</li>
				<li>
					<h4 class="M3">
						<span></span>DEMO管理
					</h4>
					<div class="list-item none">
						<a href="admin/doDemo?currPage=1">DEMO列表</a> <a
							href="admin/doDemoPublish">新增DEMO</a>
					</div>
				</li>
			</ul>
		</nav>
		<div class="m-right">
			<div class="right-nav">
				<ul class="nav-list">
					<li>您当前的位置</li>
					<li>&nbsp;>&nbsp;</li>
					<li class="write-article">写新文章</li>
				</ul>
			</div>
			<div class="main">
<%-- 				<div class="catagory-select" name="articletype">
					<span class="title">类别：</span> 
					<select name="colId" id="catagory" class="catagory">
						<option value="0">--请选择--</option>
						<c:forEach items="${typeList}" var="a">							
								<option value="${a.id}">${a.type}</option>							
						</c:forEach>
					</select>
				</div> --%>
				<table class="insert-tab insert-tab-comment">
					<thead>
						<th>ID</th>
						<th>标题</th>
						<th>发布时间</th>
						<th>编辑</th>
					</thead>
					<tbody id="deleteItem">
						<c:forEach items="${listArticle.list}" var="a">
							<tr>
								<td>${a.id}</td>
								<td>${a.title}</td>
								<td>${a.pubDate}</td>
								<td><a href="/doPublish?article_id=${a.id}">编辑</a> <a
									href="/doDelete?article_id=${a.id}" class="deleteItem">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="list-page">
					<c:if test="${listArticle.currPage!=1}">
						<a href="doMarticle?currPage=1" class="prepage">首页</a>
						<a href="doMarticle?currPage=${listArticle.currPage-1}"
							class="prepage">上一页</a>
					</c:if>
					<c:if test="${listArticle.currPage!=listArticle.totalPage}">
						<a href="doMarticle?currPage=${listArticle.currPage+1}"
							class="nextpage">下一页</a>
						<a href="doMarticle?currPage=${listArticle.totalPage }"
							class="prepage">尾页</a>
					</c:if>
					<span class="pageCount">共${listArticle.totalCount}</span>条 <span
						class="cuurPage">${listArticle.currPage}</span> / <span
						class="pageCount">${listArticle.totalPage}</span>页
				</div>
			</div>
		</div>
	</section>
	<footer id="footer">
		<p>Copyright &copy; 2017 JUN. All Rights Reserved.</p>
	</footer>
	<script src="<c:url value="/style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="/style/js/menu.js"/>"></script>
	<script>
    $(document).ready(function() {
    	// 删除时，显示提示框 
        $('#deleteItem').on('click', 'a', function(e) {
        	if(e.target.className == 'deleteItem'){
        		var flag = confirm('确定删除？');
                if (flag) {
                    return true;
                } else {
                    return false;
                }
        	}
            
        })
    });
    </script>
</body>

</html>
