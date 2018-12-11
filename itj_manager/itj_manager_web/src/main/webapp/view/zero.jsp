<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>${sessionScope.user.account}的博客</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/zero.css"/>
</head>
<body>
<header>
    <div class="menu">
        <ul>
            <li><a href="">主页</a></li>
            <li><a href="">博客管理</a></li>
            <li><a href="">写博客</a></li>
            <li>
                <a class="owner-center" href="">个人中心</a>
                <ul class="owner">
                    <li><a href="">资料</a></li>
                    <li><a href="">修改密码</a></li>
                    <li><a href="">退出</a></li>
                </ul>
            </li>
            <li><a href="">关于我们</a></li>
        </ul>
    </div>
    <div id="headPhoto">
        <div><p>${user.account}</p></div>
        <img src="${pageContext.request.contextPath}/${user.headPhoto}"/>
        <div><p>${user.autograph}</p></div>
    </div>
</header>
<article>
    <!--single article-->
    <div class="article">
        <div class="title"><h3>文章标题</h3></div>
        <div class="content">文章内容</div>
        <div>
            <ul>
                <li><img src="${pageContext.request.contextPath}/img/like.png"><span>12312</span></li>
                <li><img src="${pageContext.request.contextPath}/img/look.png" style="width: 22px; height: 22px;"><span>241</span></li>
                <li><img src="${pageContext.request.contextPath}/img/comment.png"><span></span></li>
            </ul>
        </div>
    </div>
    <!--single article-->
</article>
<div class="leftPannel">TOP
    <ul>
        <li>asdfa</li>
        <li>asdfa</li>
        <li>asdfa</li>
        <li>asdfa</li>
        <li>asdfa</li>
        <li>asdfa</li>
        <li>asdfa</li>
    </ul>
</div>
<footer>
    <ul>
        <li style="float: left;">版权声明:个人博客</li>
        <li style="float: right;">联系E-mail:clownlanko@126.com</li>
    </ul>
</footer>
</body>
</html>
