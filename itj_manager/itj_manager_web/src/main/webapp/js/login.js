function apply() {
    let error = 0;
    $("input[type!=button]").each(function() {
        if ($(this).val() == "") {
            layer.alert($(this).attr("placeholder"), {
                title: 'ITJ Tooltip',
                icon: 0
            });
            error++;
            return false;
        }
    });
    if (error > 0) {
        return;
    }
    if(error==0){
        $.ajax({
            url:"/ITJ/user.itj/login.itj",
            type:"post",
            dataType:"json",
            data:$("#login-form").serialize(),
            success:function (json) {
                if(json.state==4){
                    layer.msg(json.message,{
                        icon:1,
                        title:"ITJ Tooltip",
                        end:function () {
                            location.href="/ITJ/view/zero.jsp";
                        }
                    })
                }
                if(json.state==-1){
                    layer.msg(json.message, {
                        icon: 2,
                        title: "ITJ Tooltip",
                        btn:["REGISTER","TRY AGAIN"],
                        yes:function () {
                            location.href="/ITJ/view/register.jsp";
                        }
                    });
                }
            }
        });
    }
}