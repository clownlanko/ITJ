jQuery(document).ready(function() {
    $.backstretch([
        "/ITJ/img/backgrounds/1.jpg", "/ITJ/img/backgrounds/2.jpg", "/ITJ/img/backgrounds/3.jpg"
    ], {
        duration: 3000,
        fade: 750
    });
});
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
		url: "/ITJ/user.itj/register.itj",
		data: new FormData($("#regin-form")[0]),
		type: "POST",
		dataType: "json",
		processData: false,
		contentType: false,
		success: function(json) {
			if (json.state == 4) {
                layer.alert(json.message, {
                    title: 'ITJ Tooltip',
                    icon: 0,
                    end:function () {
                        location.href = "/ITJ/view/zero.jsp";
                    }
                });
			}
		}
	});
}
function queryAccount() {
	$.ajax({
		url: "/ITJ/user.itj/qa.itj?account=" + $("#account").val(),
		type: "get",
		dataType: "json",
		success: function(json) {
			if (json.state == 4) {
				layer.alert(json.message, {
					title: 'ITJ Tooltip',
					icon: 0
				});
			}
		}
	});
}
