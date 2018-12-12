<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ITJ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
</head>

<body>

<div class="header">
    <div class="container">
        <div class="row">
            <div class="logo span4">
                <h1>ITJ Register <span class="red">.</span></h1>
            </div>
            <div class="links span8">
                <a class="login" href="${pageContext.request.contextPath}/view/login.jsp" rel="tooltip" data-placement="bottom" data-original-title="Login"></a>
                <a class="home" href="${pageContext.request.contextPath}/view/home.jsp" rel="tooltip" data-placement="bottom" data-original-title="Home"></a>
                <a class="blog" href="${pageContext.request.contextPath}/view/blog.jsp" rel="tooltip" data-placement="bottom" data-original-title="Blog"></a>
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
        <form id="regin-form" enctype="multipart/form-data">
            <h2>REGISTER TO <span class="red"><strong>ITJ</strong></span></h2>
            <span>
                <img src="${pageContext.request.contextPath}/img/avatar.jpg" onclick="selectFile()"/>
                <input id="icon" name="headPhoto" type="file"/>
            </span>
            <label for="account">Account</label>
            <input type="text" id="account" name="account" placeholder="choose a account...">
            <label for="password">Password</label>
            <input onfocus="queryAccount()" type="password" id="password" name="password" placeholder="choose a password...">
            <button type="button" onclick="apply()" id="login-btn">REGISTER</button>
        </form>
    </div>
</div>
<div class="copy-right">
    <p>Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" target="_blank" title="微爱">TinyLvoe</a> All
        rights reserved.</p>
</div>
<!-- Javascript -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.8.2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.backstretch.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>
<script src="${pageContext.request.contextPath}/assets/layer/layer.js"></script>
</body>
<script>
    function selectFile() {
        $("#icon").trigger("click");
    }
    function apply() {
        let error = 0;
        $("input[type!=file]").each(function() {
            if ($(this).val() == "") {
                layer.alert($(this).attr("placeholder"), {
                    title: 'ITJ提示',
                    icon: 0
                });
                error++;
                return false;
            }
        });
        if (error > 0) {
            return false;
        }
        $.ajax({
            url: "user.itj/register.itj",
            data: new FormData($("#regin-form")[0]),
            type: "POST",
            dataType:"json",
            processData: false,
            contentType: false,
            success:function (json) {
                layer.alert(json.message, {
                    title: 'ITJ提示',
                    icon: 0
                });
                if(json.state==4){
                    location.href="${pageContext.request.contextPath}/view/zero.jsp";
                }
            }
        });
    }
    function queryAccount() {
        $.ajax({
            url: "user.itj/qa.itj?account='"+$("#account").val()+"'",
            type: "get",
            dataType:"json",
            success: function (json) {
                if(json.state==4){
                    layer.alert(json.message, {
                        title: 'ITJ提示',
                        icon: 0
                    });
                }
            }
        });
    }
</script>
</html>
