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
					<li><a href="/ITJ/view/home.jsp">主页</a></li>
					<li><a href="/ITJ/view/zero.jsp">博客管理</a></li>
					<li><a href="/ITJ/view/editor.jsp">写博客</a></li>
					<li><a href="javascript:openAboutUsPanel();">关于我们</a></li>
				</ol>
			</div>
			<div id="large-header" class="large-header">
			<canvas id="demo-canvas" ></canvas>
			</div>
	</header>
	<article id="articles">
		<!--single article-->
	</article>
	 <div class="leftPannel">
		 <div class="seratch">
			 <input onkeyup="seartch(this.value)" />
			 <ul>
				 <li><a style="margin-right: 50px;">博客测试</a>作责</li>
				 <li><a>博客测试</a>作责</li>
				 <li><a>博客测试</a>作责</li>
				 <li><a>博客测试</a>作责</li>
			 </ul>
		 </div>
	 	<div class="topPannel">
	 		<h3>TOP</h3>
	 			<ul></ul>
	 	</div>
	 </div>
		<div id="aboutUs" style="display: none;margin-left: 30px;">
			<h2>ITJ博客</h2>
			<p>个人所创<a href="http://www.genitalbean.top/TinyLove/" title="微爱">TinyLvoe</a> All rights reserved.</p>
			<p>汝若欢喜，所有功能免费使用.
				汝若不<br>欢喜或觉得功能不够强大,可以前往
				GitHub:<br>http://www.github.com/kittycoco/ITJ.git
				<br>赋予更强大的功能。
				也可以反馈邮箱:clownlanko@126.com</p>
			<textarea></textarea><br>
		</div>
	 <footer>
	 	Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" title="微爱">TinyLvoe</a> All rights reserved.
	 </footer>
	</body>
	<script src="/ITJ/js/jquery-2.1.4.min.js"></script>
	<script src='/ITJ/js/TweenMax.js'></script>
	<script src="/ITJ/js/home.js"></script>
	<script src="/ITJ/layer/layer.js"></script>
	<script>
      $(queryArticles(),queryRankingList());
	</script>
</html>
