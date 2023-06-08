$(function(){

	//动态加载就诊科室列表json
	$.ajax({
		type:"GET",//请求类型
		url: projectName + "/api/department/getDepartmentList.json",//请求的url
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(data){//data：返回数据（json对象）
			if(data.code == 200){
				data = data.data;
				var options = "<option value=\"\">--请选择--</option>";
				for(var i = 0; i < data.length; i++){
					options += "<option value=\""+data[i].id+"\">"+data[i].name+"</option>";
				}
				$("#departmentId").html(options);

				// 回显查询条件就诊科室
				var queryDepartmentId = $("#queryDepartmentId").val();
				$("#departmentId ").val(queryDepartmentId);
				// console.log(queryDepartmentId);

				if(queryDepartmentId != 0){
					$.ajax({
						type: "POST",//请求类型
						url: projectName + "/api/room/getRoomList.json",//请求的url
						data:{departmentId:queryDepartmentId},
						dataType: "json",//ajax接口（请求url）返回的数据类型
						success:function(data){//data：返回数据（json对象）
							if(data.code == 200){
								data = data.data;
								var options = "<option value=\"\">--请选择--</option>";
								for(var i = 0; i < data.length; i++){
									options += "<option value=\""+data[i].id+"\" >"+data[i].name+"</option>";
								}
								$("#roomId").html(options);

								// 回显查询条件就诊医师
								var queryRoomId = $("#queryRoomId").val();
								$("#roomId ").val(queryRoomId);
							} else {
								alert("就诊房间查询失败");
							}
						},
						error:function(){//当访问时候，404，500 等非200的错误状态码
							alert("就诊房间查询失败");
						}
					});
				}
			}
		},
		error:function(){//当访问时候，404，500 等非200的错误状态码
			alert("就诊房间查询失败！");
		}
	});

});
// 根据就诊科室查询就诊房间列表
function departmentFun() {
	var departmentId = $('select option:selected').val();

	if(departmentId != 0){
		$.ajax({
			type: "POST",//请求类型
			url: projectName + "/api/room/getRoomList.json",//请求的url
			data:{departmentId:departmentId},
			dataType: "json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.code == 200){
					data = data.data;
					var options = "<option value=\"\">--请选择--</option>";
					for(var i = 0; i < data.length; i++){
						options += "<option value=\""+data[i].id+"\" >"+data[i].name+"</option>";
					}
					$("#roomId").html(options);
				} else {
					alert("就诊房间查询失败");
				}
			},
			error:function(){//当访问时候，404，500 等非200的错误状态码
				alert("就诊房间查询失败");
			}
		});
	}
}

// 删除按钮事件
$('.viewRegister').on("click", function () {
	var msg = "您确定要删除吗？";
	if (confirm(msg)==true){
		let id = $(this).data('down');

		$.ajax({
			type: "POST",//请求类型
			url: projectName + "/api/schedule/deleteScheduleById.json",//请求的url
			data:{id:id},
			dataType: "json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.code == 200){
					window.location.reload();
					alert("删除成功");
				} else {
					alert(data.msg);
				}
			},
			error:function(){//当访问时候，404，500 等非200的错误状态码
				alert(data.msg);
			}
		});
		return true;
	}else{
		return false;
	}
});