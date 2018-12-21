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
    <link rel="stylesheet" href="/ITJ/editor/css/editormd.css"/>
    <link rel="stylesheet" href="/ITJ/css/editor.css"/>
    <title>ITJ博客</title>
</head>
<body>
<div id="layout">
    <canvas></canvas>
    <div id="editor"></div>
    <div id="tag" style="display: none;">Tag:<input style="height: 30px;
	border-radius: 5px;
	border: 1px solid gray;" type="text" placeholder="enter a tag"></div>
    <div id="article-panel" style="display: none;">
        <form id="article-form" enctype="text/plain">
            <input type="hidden" name="userId" value=""/>
            Title:<input style="height: 30px;
	border-radius: 5px;
	border: 1px solid gray; " type="text" title="标题" id="title" placeholder="enter a title" name="title"/><br><br>
            Tag:<input style="width: 20px;margin-left: 5px;
	height: 20px;
	background-color: transparent;
	color: #00C4FF;
	font-size: 20px;
	text-align: center;
	line-height: 15px;
	border: 1px solid gray;
	border-radius:50% ;" type="button" id="tag-btn" onclick="addTag()" value="+"/>
            <textarea style="display: none;" id="article" name="content"></textarea>
        </form>
    </div>
</div>
</body>
<script src="/ITJ/js/jquery-2.1.4.min.js"></script>
<script src="/ITJ/editor/editormd.js"></script>
<script src="/ITJ/layer/layer.js"></script>
<script src="/ITJ/js/markdown.js"></script>
<script src="/ITJ/js/pop_word.js"></script>
<script type="text/javascript">
    function back() {
        layer.confirm("返回将不会保存!!", {
            icon: 2,
            title: "ITJ提示",
            btn: ["确定", "取消"]
        }, function () {
            location.href = "/ITJ/view/zero.jsp";
        });
    }

    function addTag() {
        $("#tag>input").val("");
        layer.open({
            type: 1,
            title: "添加标签",
            shadeClose: true,
            content: $("#tag"),
            btn: ["确定"],
            yes: function (index) {
                var tag = $("<input style='display:none' type=\"checkbox\" checked name=\"tags\" class=\"article-tag\" value=\"" + $("#tag>input").val() + "\"><span style='background-color:rgba(18,230,136,0.5);border-radius:3px;margin-right:5px;'>" + $("#tag>input").val() + "</span>");
                $("#tag-btn").before(tag);
                layer.close(index);
            }
        });
    }

    function save() {
        $("#article").html($("#editor>.editormd-markdown-textarea").val());
        layer.open({
            type: 1,
            title: "保存博客",
            shadeClose: true,
            content: $("#article-panel"),
            btn: ["确定"],
            yes: function (index) {
                $.ajax({
                    url: "/ITJ/ac.itj/add.itj",
                    data: $("#article-form").serialize(),
                    dataType: "json",
                    type: "POST",
                    success: function (json) {
                        if (json.state == -1) {
                            layer.msg(json.message, {
                                icon: 2,
                                title: "ITJ提示"
                            });
                        }
                        if (json.state == 4) {
                            layer.confirm(json.message, {
                                title: "ITJ提示",
                                icon: 1,
                                btn: ["查看", "管理博客", "返回主页"]
                            }, function () {
                                location.href="/ITJ/view/article.jsp?ai="+JSON.stringify(json.data);
                            }, function () {
                                location.href = "/ITJ/view/zero.jsp";
                            }, function () {
                                location.href = "/ITJ/view/home.jsp";
                            });
                        }
                        layer.close(index);
                    }
                });
            }
        });
    }

    $.get("/ITJ/js/zh_cn.json", function (zh_cn) {
        var editor = createMarkdownEditor("editor", zh_cn, save, '${user.account}');
    });
</script>
</html>

