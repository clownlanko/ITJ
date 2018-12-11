<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ITJ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="App Loction Form,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements"./>
    <link href="${pageContext.request.contextPath}/css/login.css" rel='stylesheet' type='text/css' />

</head>
<body>
<h1>ITJ LOGIN FORM</h1>
<div class="app-location">
    <h2>Welcome to ITJ</h2>
    <div class="line"><span></span></div>
    <div class="location"><img src="${pageContext.request.contextPath}/img/location.png" class="img-responsive" alt="" /></div>
    <form action="user.itj/login.itj" method="post" onsubmit="return apply();">
        <input name="account" placeholder="enter a account" type="text" class="text">
        <input name="password" placeholder="enter a password" type="password">
        <div class="submit"><input type="submit" value="Sign in"></div>
        <div class="new">
            <h3><a href="#">Forgot password ?</a></h3>
            <h4><a href="${pageContext.request.contextPath}/view/register.jsp">New here ? Sign Up</a></h4>
        </div>
    </form>
</div>
<!--start-copyright-->
<div class="copy-right">
    <p>Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" target="_blank" title="微爱">TinyLvoe</a> All rights reserved.</p>
</div>
<script src="../assets/js/jquery-1.8.2.min.js"></script>
<script src="../assets/layer/layer.js"></script>
<!--//end-copyright-->
</body>
<script>
    function apply() {
        console.info(123);
        let error = 0;
        $("input[type!=button]").each(function() {
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
    }
</script>
</html>