<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ITJ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
</head>

<body>

<div class="header">
    <div class="container">
        <div class="row">
            <div class="logo span4">
                <h1>ITJ Register <span class="red">.</span></h1>
            </div>
            <div class="links span8">
                <a class="home" href="home.jsp" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                <a class="blog" href="blog.jsp" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
            </div>
        </div>
    </div>
</div>
<div class="register-container">
    <div class="autograph">
        <p>你只是太没有出息</p>
        <p>所以才会连一个不爱你的人都放不下</p>
        <p>既然你装作刀枪不入的样子</p>
        <p>那就做好万箭穿心的准备</p>
    </div>
    <div class="register span6">
        <form action="user.itj/register.itj" method="post" enctype="multipart/form-data">
            <h2>REGISTER TO <span class="red"><strong>ITJ</strong></span></h2>
            <span>
                <img src="img/avatar.jpg" onclick="selectFile()"/>
                <input id="icon" name="headPhoto" type="file"/>
            </span>
            <label for="account">Account</label>
            <input type="text" id="account" name="account" placeholder="choose a account...">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="choose a password...">
            <button type="submit">REGISTER</button>
        </form>
    </div>
</div>
<div class="copy-right">
    <p>Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" target="_blank" title="微爱">TinyLvoe</a> All
        rights reserved.</p>
</div>
<!-- Javascript -->
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>
</body>
<script>
    function selectFile() {
        $("#icon").trigger("click");
    }
</script>
</html>
