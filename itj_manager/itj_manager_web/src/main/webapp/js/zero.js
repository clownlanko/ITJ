$(function() {
	$("body").css("background-size", window.innerWidth + "px " + window.innerHeight + "px");
});
function showInfo(){
	layer.open({
		type: 1,
		title: "Personal Information",
		shadeClose: true,
		content: $("#userInfo"),
		btn: ["ENSURE"],
		yes: function (index) {
            $.ajax({
                url: "/ITJ/user.itj/updateUser.itj",
                type: "POST",
                data:  new FormData($("#info-form")[0]),
                processData: false,
                contentType: false,
                dataType: "json",
                success: function (json) {
                	if(json.state==4){
                        layer.msg(json.message,{
                            icon:1,
                            title:"ITJ Tooltip",
                            time:2000
                        })
					}
                    if(json.state==-1){
                        layer.msg(json.message,{
                            icon:2,
                            title:"ITJ Tooltip",
                            time:2000
                        })
                    }
                    layer.close(index);
                    document.getElementById("info-form").reset();
                }
            });
		}
	});
}
function changePassword(){
	layer.open({
		type: 1,
		title: "Change Password",
		shadeClose: true,
		content: $("#changePwd"),
		btn: ["ENSURE"],
		yes: function (index) {
            var oldPwd= $("#password-form>input[name='oldPwd']").val();
			var newPwd= $("#password-form>input[name='newPwd']").val();
            var reNewPwd= $("#password-form>input[placeholder='Confirm password']").val();
            var flag=true;
            if(oldPwd=="" || newPwd=="" || newPwd=="" || newPwd!=reNewPwd){
            	layer.msg("The two password entries are inconsistent. Please try again.",{
            		icon:2,
					title:"ITJ Tooltip",
					icon:2000
				})
				flag=false;
			}
            if(flag){
                $.ajax({
                    url:"/ITJ/user.itj/cp.itj",
                    type:"POST",
                    data:$("#password-form").serialize(),
                    dataType: "json",
                    success:function (json) {
                        if(json.state==1){
                            layer.msg(json.message,{
                                icon:2,
                                title:"ITJ Tooltip",
                                icon:2000
                            })
                        }
                        if(json.state==-1){
                            layer.msg(json.message,{
                                icon:3,
                                title:"ITJ Tooltip",
                                icon:2000
                            })
                        }
                        if(json.state==4){
                            layer.msg(json.message,{
                                icon:1,
                                title:"ITJ Tooltip",
                                icon:2000
                            })
							document.getElementById("password-form").reset();
                            layer.close(index);
                        }
                    }
                });
			}
		}
	});
}
function changeState(){
	$("#info-form input").removeAttr("disabled");
}
function queryArticle(userId){
	$.ajax({
		url:"/ITJ/ac.itj/getArticle.itj?userId="+userId,
		type:"get",
		dataType:"json",
		success:function (json) {
			if(json.state==-1){
				layer.confirm(json.message,{
					icon:1,
					title:"ITJ Tooltip",
					btn:["ENSURE","NO"]
				},function () {
					location.href="/ITJ/view/editor.jsp";
				})
			}
			if(json.state==4){
				for(var i=0;i<json.data.length;i++){
					var article=$("<div class='article'></div>");
					var title=$("<div class=\"title\"><h3><a href=\"/ITJ/view/article.jsp?ai="
						+json.data[i].articleId+"\">"+json.data[i].title+"</a></h3><strong>"+json.data[i].nickname+"</strong></div>");
					var content=$("<div class=\"content\">"+json.data[i].content.substr(0,100)+"</div>");
					var article_tags=$("<div class=\"article-tags\"></div>");
					var ul=$("<ul></ul>");
					for(var j=0;j<json.data[i].tags.length;j++){
						ul.append($("<li>"+json.data[i].tags[j]+"</li>"));
					}
					article_tags.append(ul);
					var article_menu=$("<div class='article-menu'><ul>\n" +
						"<li><img src=\"/ITJ/img/like.png\"><span>"+json.data[i].likeQuantity+"</span></li>" +
						"<li><img src=\"/ITJ/img/look.png\" style=\"width: 22px; height: 22px;\"><span>"+json.data[i].lookQuantity+"</span></li>" +
						"<li><img src=\"/ITJ/img/delete.png\" onclick='javascript:deleteArticle(\""+json.data[i].articleId+"\")'></li>" +
						"</ul></div>");
					article.append(title,content,article_tags,article_menu);
					$("#articles").append(article);
				}
			}
		}
	});
}
function deleteArticle(articleId){
    layer.confirm("Are you sure you want to delete it?",{
        icon:1,
        title:"ITJ Tooltip",
        btn:["ENSURE","CANCEL"]
    },function (index) {
        $.get("/ITJ/ac.itj/da.itj?articleId="+articleId,function (json) {
            if(json.state==4){
                layer.msg(json.message,{
                    icon:5,
                    title:"ITJ Tooltip"
                })
            }
            if(json.state==-1){
                layer.msg(json.message,{
                    icon:1,
                    title:"ITJ Tooltip"
                })
            }
        });
        layer.close(index);
    })
}
