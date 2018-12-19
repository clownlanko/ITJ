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
		<link rel="stylesheet" href="/ITJ/css/login.css" />
		<title>ITJ博客</title>
	</head>
	<body>
		<div class="app-location">
			<h2>LOGIN TO ITJ</h2>
			<div class="location"><img src="/ITJ/img/location.png" class="img-responsive" alt="" /></div>
			<form id="login-form">
				<input name="account" placeholder="enter a account" type="text" class="text">
				<input name="password" placeholder="enter a password" type="password">
				<div class="submit"><input type="button" accesskey="13" onclick="apply()" value="Sign in"></div>
				<div class="new">
					<h3><a href="#">Forgot password ?</a></h3>
					<h4><a href="/ITJ/view/register.jsp">New here ? Sign Up</a></h4>
				</div>
			</form>
		</div>
		<div class="copy-right">
			Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" title="微爱">TinyLvoe</a> All rights reserved.
		</div>
	</body>
	<script src="/ITJ/js/jquery-2.1.4.min.js"></script>
	<script src="/ITJ/layer/layer.js"></script>
	<script src="/ITJ/js/login.js"></script>
</html>
