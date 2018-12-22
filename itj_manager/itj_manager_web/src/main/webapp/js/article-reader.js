function markdownResover(view,content) {
	return editormd.markdownToHTML(view, {
		markdown: content,
		// htmlDecode: true, // 开启 HTML 标签解析，为了安全性，默认不开启
		// htmlDecode: "style,script,iframe", // you can filter tags decode
		emoji : true,
		toc: false,
		tocm: true, // Using [TOCM]
		gfm: false,
		tocDropdown: true,
		markdownSourceCode: false, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
		taskList: true,
		tex: true, // 默认不解析
		flowChart: true, // 默认不解析
		sequenceDiagram: true, // 默认不解析
		taskList: true,
	});
}
function queryArticle(articleId) {
    $.get("/ITJ/ac.itj/qa.itj?articleId="+articleId,function (json) {
        markdownResover("result",json.data.content);
        $("title").html(json.data.nickname+"---->"+json.data.title);
        $("meta[name='keywords']").attr("content",$("meta[name='keywords']").attr("content")+"|"+json.data.title);
        if(json.data.tags.length>0){
        	var ul=$("<ul></ul>");
            for(var i=0;i<json.data.tags.length;i++){
				ul.append("<li>"+json.data.tags[i]+"</li>");
            }
            $(".article-tags").append(ul);
		}
        $("#result-footer>.article-menu span:first").html(json.data.likeQuantity);
        $("#result-footer>.article-menu span:last").html(json.data.lookQuantity);
		if(json.data.commonts.length>0){
			for(var i=0;i<json.data.commonts.length;i++){
				$("#result-footer>.commont").append("<p>" + json.data.commonts[i] + "</p>");
			}
		}
    });
}
function openCommontPanel(articleId,userId,nickname) {
	$("#commont-panel").val("");
	layer.open({
		type: 1,
		title: "COMMONT",
		shadeClose: true,
		content: $("#commont-panel"),
		btn: ["ENSURE"],
		yes: function(index) {
			var commont="<strong>"+nickname+"<strong> : "+$("#commont-panel").val();
			var data="articleId="+articleId+"&userId="+userId+"&commont="+commont;
			$.get("/ITJ/ac.itj/acc.itj?"+data,function(json){
				if(json.state==4){
                    $("#result-footer>.commont").prepend("<p>" + commont + "</p>");
                    layer.msg(json.message,{
                    	icon:1,
						title:"ITJ Tooltip"
					});
				}
				if(json.state=-1){
                    layer.msg(json.message,{
                        icon:3,
                        title:"ITJ Tooltip"
                    });
				}
			});
			layer.close(index);
		}
	});
}
function thumbsUp(articleId){
	$.get("/ITJ/ac.itj/tu.itj?articleId="+articleId,function (json) {
		if(json.state==4){
            layer.msg(json.message,{
				icon:1,
				title: "ITJ Tooltip"
            })
		}
		if(json.state==-1){
            layer.msg(json.message,{
                icon:3,
                title: "ITJ Tooltip"
            })
        }
    });
}