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
    <link rel="stylesheet" href="<c:url value="/style/css/reset.css"/>" type="text/css" media="all" />
    <link rel="stylesheet" href="<c:url value="/style/css/main.css"/>" type="text/css" >

</head>

<body>
    <header>
        <div class="logo">
            <a href="index.html"><img src="<c:url value="/style/img/logo.png"/>" alt="Foto"></a>
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
                    <li><a href="#" target="_blank" class="mail"><i></i></a> </li>
                </ul>
            </div>
        </div>
    </header>
    <!-- End header  -->
    <section class="main">
        <article class="article">
            <h1 class="article_title"><a href="javascript:void(0)"> ${article.title}</a></h1>
            <div class="article-content">
                <p>${article.content}</p>
            </div>
        </article>
        <!--end article-->
        <div class="publish-comment">
            <div class="comment-text">
            	<input type="hidden" name="article_id" value="${article.id}" id="article_id">
                <textarea placeholder="想说啥就说啥" class="js-textarea" id="js-textarea"></textarea>
                <div class="comment-push clearfix">
                    <input type="submit" class="comment-btn" id="comment-btn" value="发表评论">
                </div>
            </div>
        </div>
        <div id="commentList">
        <c:forEach items="${listReply}" var="a">
        <div class="show-comment">
            <p class="comment">${a.content}</p>
            <time class="time">${a.time} </time>
        </div>
        </c:forEach>
        </div>
        <!-- End main_content-->
    </section>
    <!-- End main  -->
    <script src="<c:url value="/style/js/jquery-1.8.3.min.js"/>"></script>
	<script src="<c:url value="/style/js/main.js"/>"></script>
	<script type="text/javascript">
		function renderReply(data){
			 var html = '';
			 html='<div class="show-comment"><p class="comment">'+data.reply.content+'</p><time class="time">'+data.reply.time+'</time></div>';
		     $('#commentList').prepend(html);
		}
		$('#comment-btn').on('click',function(){
			
		  	$.ajax({  
		  	    type : 'GET',  
		  	    contentType : 'application/json',  
		  	    url : 'reply',
		  	    data:{
		  	    	article_id:$('#article_id').val(),
		  	    	content:$('#js-textarea').val()
		  	    },
		  	    dataType : 'json',  
		  	    success : function(data) {  
		  	      console.log("success");
		  	      renderReply(data);		  	      
		  	    },  
		  	    error : function() {  
		  	      alert("error")  
		  	    }  
		  	  });
		});
	</script>
</body>

</html>
