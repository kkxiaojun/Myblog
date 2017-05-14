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
				<li class="selected"><a href="/doHome">Home</a></li>
				<li><a href="/doArticle">Aticle</a></li>
				<li><a href="/doDemo">Demo</a></li>
				<li><a href="/doContact">Contact</a></li>
			</ul>
		</nav>
		<div class="social_widget">
			<div class="sm">
				<ul>
					<li><a href="#" target="_blank" class="fb"><i></i></a><span></span></li>
					<li><a href="http://weibo.com/kkxiaojun" target="_blank"
						class="t"><i></i></a></li>
					<li><a href="https://github.com/kkxiaojun" target="_blank"
						class="g"><i></i></a></li>
					<li><a href="#" target="_blank" class="mail"><i></i></a></li>
				</ul>
			</div>
		</div>
	</header>
	<!-- End header  -->
	<section class="main" id="articleList">
	</section>
	<!-- End main  -->
	<script src="<c:url value="/style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="/style/js/main.js"/>"></script>
	<script>

	// 异步请求article
	var pageIndex = 0;
	       //前一页  
       function GoToPrePage() {
           pageIndex -= 1;
           pageIndex = pageIndex >= 0 ? pageIndex : 0;
           searchArticle(pageIndex);
       }
       //后一页  
       function GoToNextPage(totalCount) {
           if (pageIndex + 1 < totalCount) {
               pageIndex += 1;
           }
           searchArticle(pageIndex);
       }
  // 异步请求article
  function searchArticle(pageIndex){
  	$.ajax({  
    type : 'GET',  
    contentType : 'application/json',  
    url : 'blog/article',
    data:{
    	currPage:pageIndex
    },
    dataType : 'json',  
    success : function(data) {  
      console.log("success");
      renderArticle(data);
    },  
    error : function() {  
      alert("error")  
    }  
  });
  }
  function renderArticle(data) {
        var html = '';
        $.each(data.listArticle.list, function(index, item) {
            var context = ' <article class="post"><h1 class="title"><a href="/blog/articleShow/' +
                item.id + '">' + item.title + '</a></h1><div class="entry-content"><p>' + item.content.substring(0, 110) + '</p></div><div class="entry-comment"><a href="/blog/articleShow/' + item.id + '" class="continue">继续阅读 &raquo;</a><div class="right"><time>' + item.pubDate + '</time></div></div></article>';
            html += context;
        });
        var btn = '<article class="article-btn"><div class="entry-comment"><a href="javascript:void(0)" class="prev" onclick="GoToPrePage()">&laquo; prev</a><a href="javascript:void(0)" class="next" onclick="GoToNextPage('+data.listArticle.totalPage+')">next &raquo;</a></div></article>';
        html += btn;
        $('#articleList').empty().append(html);
  }
  searchArticle(pageIndex);
	 </script>
</body>

</html>
