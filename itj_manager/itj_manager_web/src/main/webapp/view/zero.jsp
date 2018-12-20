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
		<link rel="stylesheet" href="/ITJ/css/zero.css" />
		<title>${user.account}的博客</title>
	</head> 
	<body>
		<header>
			<div class="menu">
				<ol>
					<li><a href="/ITJ/view/home.jsp">主页</a></li>
					<li><a href="/ITJ/view/zero.jsp">博客管理</a></li>
					<li><a href="/ITJ/view/editor.jsp">写博客</a></li>
					<li>
						<a href="#">个人中心</a>
						<ul class="owner">
							<li><a href="javascript:showInfo();">资料</a></li>
							<li><a href="javascript:changePassword();">修改密码</a></li>
							<li><a href="/ITJ/user.itj/logout.itj">退出</a></li>
						</ul>
					</li>
				</ol>
			</div>
			<div id="headPhoto">
				<p>${user.account}</p>
				<img src="/ITJ/${user.headPhoto==null?'user_img/account.jpg':user.headPhoto}"/>
				<p>${user.autograph==null?"":user.autograph}</p>
			</div>
		</header>
		<article id="articles"  style="width: 90%;">
			<!--single article-->
		</article>
		<footer>
			Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" title="微爱">TinyLvoe</a> All rights reserved.
		</footer>
		<!--个人资料-->
		<div id="userInfo" style="display: none;">
			<form id="info-form" enctype="multipart/form-data" style="margin:10px 50px 10px 50px;">
				<div>
					<img src="/ITJ/${user.headPhoto==null?'user_img/account.jpg':user.headPhoto}" onclick="$('#info-form div input[type=file]').trigger('click')"/>
					<input type="file" onchange="" name="headPhoto" style="display: none;"/>
				</div>
				<div>${user.account}<button type="button" onclick="changeState()">修改</button></div>
				<div><input name="nickname" placeholder="${user.nickname==null?"昵称":user.nickname}" disabled="disabled"/></div>
				<div><input name="autograph" placeholder="${user.autograph==null?"个性签名":user.autograph}" disabled="disabled"/></div>
			</form>
		</div>
		<!--修改密码-->
		<div id="changePwd" style="display: none;">
			<form id="password-form" style="margin: 10px;">
				原&nbsp;&nbsp;密&nbsp;&nbsp;码:&nbsp;<input name="oldPwd" type="password"/><br>
				新&nbsp;&nbsp;密&nbsp;&nbsp;码:&nbsp;<input name="newPwd" type="password"/><br>
				确认密码:&nbsp;&nbsp;<input type="password" placeholder="reNewPwd"/>
			</form>
		</div>
	</body>
	<script src="/ITJ/js/jquery-2.1.4.min.js"></script>
	<script src="/ITJ/layer/layer.js"></script>
	<script src="/ITJ/js/zero.js"></script>
	<script>
	    $(queryArticle(${user.userId}));
	</script>
</html>
