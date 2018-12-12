<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ITJ</title>
    <link href="${pageContext.request.contextPath}/css/edit.css" rel="stylesheet"/>
</head>
<body>
<header>
    <div>
        <form id="article-form" action="${pageContext.request.contextPath}/ac.itj/add.itj" method="post">
            <input type="hidden" name="userId" value="${sessionScope.user.userId}"/>
            <input title="标题" id="title" placeholder="Title" name="title"/>
            <ul>
                <li><input type="submit" id="save"/></li>
                <li><input type="button" id="imgBtn" onclick="addImage()"/></li>
                <li><input type="button" id="tagBtn" onclick="addTag()"/></li>
                <li><a id="back" href=""></a></li>
            </ul>
            <div class="article-tag"><input type="checkbox" checked name="tags" value="无"/><label></label></div>
            <textarea style="display: none;" id="article" name="content" placeholder="article"></textarea>
        </form>
    </div>
    <div class="showpage">
        <textarea spellcheck="true" wrap="soft" translate id="content" onkeyup="compile()"></textarea>
        <div id="result"></div>
    </div>
    <div id="tag" style="display: none;"><input placeholder="enter a tag"></div>
    <div id="image" style="display: none;">
        <form id="image-form" enctype="multipart/form-data">
            <input type="hidden" name="account" value="${user.account}">
            <input name="image" type="file"/>
        </form></div>
</header>
</body>
<script src="${pageContext.request.contextPath}/js/showdown.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.8.2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/layer/layer.js"></script>
<script>
    function compile(){
        let converter = new showdown.Converter();
        let html = converter.makeHtml($("#content").val());
        $("#result").html(html);
        $("#article").val(html);
    }
    function addTag(){
        $("#tag>input").val("");
        layer.open({
            type:1,
            title:"添加标签",
            shadeClose:true,
            content:$("#tag"),
            btn:["确定"],
            yes:function(index){
                let tag=$("<div class=\"article-tag\"><input type=\"checkbox\" checked name=\"tags\" value="+$("#tag>input").val()+"><label>"+$("#tag>input").val()+"</label></div>");
                $("#tagBtn").before(tag);
                layer.close(index);
            }
        });
    }
    function addImage(){
        $("#image>input").val("");
        layer.open({
            type:1,
            title:"添加图片",
            shadeClose:true,
            content:$("#image"),
            btn:["确定"],
            yes:function(index){
                $.ajax({
                    url:"${pageContext.request.contextPath}/ac.itj/addimg.itj",
                    type:"POST",
                    data:new FormData($("#image-form")[0]),
                    processData: false,
                    contentType: false,
                    dataType: "json",
                    success:function (json) {
                        if(json.state==1 || json.state==3){
                            layer.alert(json.message,{
                                icon: 3,
                                title:"ITJ提示"
                            })
                        }
                        if(json.state==4){
                            document.getElementById("content").value+="![图片描述]("+json.data+")";
                        }
                    }
                });
                layer.close(index);
            }
        });
    }
    function saveArticle(){
        $.ajax({
            url:"${pageContext.request.contextPath}/ac.itj/add.itj",
            data:$("#article-form").serialize(),
            dataType:"json",
            type:"post",
            success:function (json) {
                if(json.state==4){
                    layer.config(json.message,{
                        title:"ITJ提示",
                        icon:1,
                        btn:["查看","管理博客","返回主页"]
                    },function () {
                        alert("查看");
                    },function () {
                        alert("管理博客");
                    },function () {
                        alert("返回主页");
                    })
                }
            }
        });
    }
</script>
</html>
