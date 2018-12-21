<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="lanko" />
		<meta name="keywords" content="ITJ博客" />
		<meta name="description" content="ITJ博客" />
		<link rel="shortcut icon" type="image/x-icon" href="/ITJ/img/logo.png" />
		<link rel="stylesheet" href="/ITJ/css/register.css"/>
		<title>ITJ博客</title>
	</head>
	<body>
		<header>
			<a class="login" title="登陆" href="/ITJ/view/login.jsp" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
			<a class="home" title="首页" href="/ITJ/view/home.jsp" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
		</header>
		<article>
			<div id="autograph">
				<p>你只是太没有出息</p>
				<p>所以才会连一个不爱你的人都放不下</p>
				<p>既然你装作刀枪不入的样子</p>
				<p>那就做好万箭穿心的准备</p>
			</div>
			<div class="register">
				<form id="regin-form" enctype="multipart/form-data">
					<h2>REGISTER TO ITJ</h2>
					<div>
						<img id="show-icon" src="/ITJ/img/avatar.jpg" onclick="selectFile()" />
						<input id="icon" name="headPhoto" type="file" />
					</div>
					<label for="account">Account</label><br>
					<input type="text" id="account" name="account" placeholder="choose a account..."><br>
					<label for="password">Password</label><br>
					<input onfocus="queryAccount()" type="password" id="password" name="password" placeholder="choose a password..."><br>
					<button type="button" onclick="apply()" id="login-btn">REGISTER</button>
				</form>
			</div>
		</article>
		<footer>
			<div class="copy-right">
				Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" title="微爱">TinyLvoe</a> All rights reserved.
			</div>
		</footer>
	</body>
	<script src="/ITJ/js/jquery-2.1.4.min.js"></script>
	<script src="/ITJ/js/jquery.backstretch.min.js"></script>
	<script src="/ITJ/layer/layer.js"></script>
	<script src="/ITJ/js/register.js"></script>
    <script src="/ITJ/js/load-img.js"></script>
</html>
