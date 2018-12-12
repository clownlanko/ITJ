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
        <form>
            <input type="hidden" name="userId" value=""/>
            <input title="标题" id="title" placeholder="Title" name="title"/>
            <ul>
                <li><input type="button" id="save" onclick="save()"/></li>
                <li><input type="button" id="imgBtn" onclick="addImage()"/></li>
                <li><input type="button" id="tagBtn" onclick="addTag()"/></li>
                <li><a id="back" href="">&nbsp;</a></li>
            </ul>
            <textarea style="display: none;" id="article" name="article" placeholder="article"></textarea>
        </form>
    </div>
    <div class="showpage">
        <textarea spellcheck="true" wrap="soft" translate id="content" onkeyup="compile()"></textarea>
        <div id="result"></div>
    </div>
    <div id="tag" style="display: none;"><input placeholder="enter a tag"></div>
    <div id="image" style="display: none;"><input type="file"/></div>
</header>
</body>
<script src="${pageContext.request.contextPath}/js/showdown.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.8.2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/layer/layer.js"></script>
<script>
    function compile(){
        var converter = new showdown.Converter();
        var html = converter.makeHtml($("#content").val());
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
                var tag=$("<div class=\"article-tag\"><input type=\"checkbox\" name=\"tags\" value="+$("#tag>input").val()+"><label>"+$("#tag>input").val()+"</label></div>");
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

                });
                layer.close(index);
            }
        });
    }
    function save(){

    }
</script>
</html>
