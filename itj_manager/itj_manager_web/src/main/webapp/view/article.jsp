<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="lanko" />
		<meta name="keywords" content="ITJ博客" />
		<meta name="description" content="ITJ博客" />
		<link rel="shortcut icon" type="image/x-icon" href="/ITJ/img/logo.png" />
		<title>ITJ博客</title>
		<link rel="stylesheet" href="/ITJ/editor/css/editormd.preview.css" />
		<link rel="stylesheet" href="/ITJ/css/article-reader.css" />
	</head>
	<body>
		<div><button id="back" onclick="history.back()"></button></div>
		<div id="result" class="markdown-body editormd-html-preview"></div>
		<div style="margin: 5px;">
			<div class="article-tags"></div>
			<div class="article-menu">
				<ul>
					<li><img src="/ITJ/img/like.png" onclick="thumbsUp(${param.ai})"><span>12312</span></li>
					<li><img src="/ITJ/img/look.png" style="width: 22px; height: 25px;"><span>241</span></li>
					<li><img src="/ITJ/img/comment.png" onclick="openCommontPanel()"></li>
				</ul>
			</div>
		</div>
		<div class="commont">
			<p>这篇文章写得好</p>
			<p>这篇文章写得好</p>
			<p>这篇文章写得好</p>
		</div>
		<input id="commont-panel" type="text" style="display: none;"/>
		<script src="/ITJ/js/jquery-2.1.4.min.js"></script>
		<script src="/ITJ/editor/lib/marked.min.js"></script>
		<script src="/ITJ/editor/lib/prettify.min.js"></script>
		<script src="/ITJ/editor/lib/raphael.min.js"></script>
		<script src="/ITJ/editor/lib/underscore.min.js"></script>
		<script src="/ITJ/editor/lib/sequence-diagram.min.js"></script>
		<script src="/ITJ/editor/lib/flowchart.min.js"></script>
		<script src="/ITJ/editor/lib/jquery.flowchart.min.js"></script>
		<script src="/ITJ/editor/editormd.js"></script>
		<script src="/ITJ/layer/layer.js"></script>
		<script src="/ITJ/js/article-reader.js" charset="UTF-8"></script>
		<script type="text/javascript">
			queryArticle(${param.ai});
		</script>
	</body>
</html>
