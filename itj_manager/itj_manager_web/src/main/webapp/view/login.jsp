<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ITJ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="App Loction Form,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements"./>
    <link href="css/login.css" rel='stylesheet' type='text/css' />
</head>
<body>
<h1>ITJ REGIN FORM</h1>
<div class="app-location">
    <h2>Welcome to ITJ</h2>
    <div class="line"><span></span></div>
    <div class="location"><img src="img/location.png" class="img-responsive" alt="" /></div>
    <form>
        <input type="text" class="text" value="E-mail address" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'E-mail address';}" >
        <input type="password" value="Password" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Password';}">
        <div class="submit"><input type="submit" onClick="myFunction()" value="Sign in" ></div>
        <div class="clear"></div>
        <div class="new">
            <h3><a href="#">Forgot password ?</a></h3>
            <h4><a href="#">New here ? Sign Up</a></h4>
            <div class="clear"></div>
        </div>
    </form>
</div>
<!--start-copyright-->
<div class="copy-right">
    <p>Copyright &copy; 2018.<a href="http://www.genitalbean.top/TinyLove/" target="_blank" title="微爱">TinyLvoe</a> All rights reserved.</p>
</div>
<!--//end-copyright-->
</body>
</html>