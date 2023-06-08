$(function(){
	//动态加载用户类型列表
	$.ajax({
		type:"GET",//请求类型
		url: projectName + "/api/auth/getRoleList.json",//请求的url
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data.code == 200){
				data = data.data;
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
				}
				$("#userType").html(options);

				// 回显查询条件
				var queryUserType = $("#queryUserType").val();
				$("#userType ").val(queryUserType);
			}
		},
		error:function(){//当访问时候，404，500 等非200的错误状态码
			alert("加载用户类型失败！");
		}
	});
});

$('.viewRegister').on("click", function () {
	var msg = "您确定启用/禁用该用户吗？";
	if (confirm(msg)==true){
		let id = $(this).data('down');

		$.ajax({
			type: "POST",//请求类型
			url: projectName + "/api/users/handleUser.json",//请求的url
			data:{id:id},
			dataType: "json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.code == 200){
					window.location.reload();
					alert("成功");
				} else {
					alert(data.msg);
				}
			},
			error:function(){//当访问时候，404，500 等非200的错误状态码
				alert("失败");
			}
		});
		return true;
	}else{
		return false;
	}
});