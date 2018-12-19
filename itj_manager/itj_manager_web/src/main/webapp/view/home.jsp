<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="lanko"/>
		<meta name="keywords" content="ITJ博客"/>
		<meta name="description" content="ITJ博客"/>
		<link rel="shortcut icon" type="image/x-icon" href="/ITJ/img/logo.png"/>
		<link rel="stylesheet" href="/ITJ/css/article.css" />
		<link rel="stylesheet" href="/ITJ/css/home.css"/>
		<title>ITJ博客</title>
	</head>
	<body>
		<header>
			<div class="menu">
				<ol>
					<li><a href="home.jsp">主页</a></li>
					<li><a href="zero.jsp">博客管理</a></li>
					<li><a href="editor.jsp">写博客</a></li>
					<li><a href="">关于我们</a></li>
				</ol>
			</div>
			<div id="large-header" class="large-header">
			<canvas id="demo-canvas" ></canvas>
			</div>
	</header>
	<article id="articles">
		<!--single article-->
		<div class="article">
			<div class="title"><h3><a>文章标题</a></h3></div>
			<div class="content">文章内容</div>
			<div class="article-tags">
				<ul>
					<li>java</li>
					<li>java</li>
				</ul>
			</div>
			<div class="article-menu">
				<ul>
					<li><img src="/ITJ/img/like.png"><span>12312</span></li>
					<li><img src="/ITJ/img/look.png" style="width: 22px; height: 25px;"><span>241</span></li>
				</ul>
			</div>
		</div>

	</article>
	 <div class="leftPannel">
	 	<div class="topPannel">
	 		<h3>TOP</h3>
	 			<ul>
	 				<li><a>asdfaasdfaasdfaasdfa</a></li>
	 				<li>asdfa</li>
	 				<li>asdfa</li>
	 				<li>asdfa</li>
	 				<li>asdfa</li>
	 				<li>asdfa</li>
	 				<li>asdfa</li>
	 			</ul>
	 	</div>
	 </div>
	 <footer>
	 	Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" title="微爱">TinyLvoe</a> All rights reserved.
	 </footer>
	</body>
	<script src="/ITJ/js/jquery-2.1.4.min.js"></script>
	<script src='/ITJ/js/TweenMax.js'></script>
	<script src="/ITJ/js/home.js"></script>
	<script>
      $(queryArticles());
	</script>
</html>
