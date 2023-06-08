$(function () {
    //加载就诊科室列表json
    $.ajax({
        type: "GET",//请求类型
        url: projectName + "/api/department/getDepartmentList.json",//请求的url
        dataType: "json",//ajax接口（请求url）返回的数据类型
        success: function (data) {//data：返回数据（json对象）
            if (data.code == 200) {
                data = data.data;
                var options = "<option value=\"\">--请选择--</option>";
                for (var i = 0; i < data.length; i++) {
                    options += "<option value=\"" + data[i].id + "\">" + data[i].name + "</option>";
                }
                $("#departmentId").html(options);

                // 回显
                $("#departmentId ").val($("#queryDepartmentId").val());

                let departmentId = $("#departmentId ").val();
                if (departmentId != 0) {
                    // 根据就诊科室ID查询就诊房间列表
                    $.ajax({
                        type: "POST",//请求类型
                        url: projectName + "/api/room/getRoomList.json",//请求的url
                        data: {departmentId: departmentId},
                        dataType: "json",//ajax接口（请求url）返回的数据类型
                        success: function (data) {//data：返回数据（json对象）
                            if (data.code == 200) {
                                data = data.data;
                                var options = "<option value=\"\">--请选择--</option>";
                                for (var i = 0; i < data.length; i++) {
                                    options += "<option value=\"" + data[i].id + "\" >" + data[i].name + "</option>";
                                }
                                $("#roomId").html(options);

                                // 回显
                                $("#roomId ").val($("#queryRoomId").val());
                            } else {
                                alert("就诊房间查询失败");
                            }
                        },
                        error: function () {//当访问时候，404，500 等非200的错误状态码
                            alert("就诊房间查询失败");
                        }
                    });
                    // 根据就诊科室ID查询门诊医师列表
                    $.ajax({
                        type: "POST",//请求类型
                        url: projectName + "/api/users/getDoctorList.json",//请求的url
                        data: {departmentId: departmentId},
                        dataType: "json",//ajax接口（请求url）返回的数据类型
                        success: function (data) {//data：返回数据（json对象）
                            if (data.code == 200) {
                                data = data.data;
                                var options = "<option value=\"\">--请选择--</option>";
                                for (var i = 0; i < data.length; i++) {
                                    options += "<option value=\"" + data[i].id + "\" >" + data[i].userName + "</option>";
                                }
                                $("#userId").html(options);

                                // 回显
                                $("#userId ").val($("#queryUserId").val());
                            } else {
                                alert("就诊医生查询失败");
                            }
                        },
                        error: function () {//当访问时候，404，500 等非200的错误状态码
                            alert("就诊医生查询失败");
                        }
                    });
                }
            }
        },
        error: function () {//当访问时候，404，500 等非200的错误状态码
            alert("查询就诊科室列表失败！");
        }
    });

    // 回显
    $("#inquiryTime ").val($("#queryInquiryTime").val());
    $("#remainingQuantity ").val($("#queryRemainingQuantity").val());
    if($("#signCount").val() == 2){
        $("#sign01").attr("checked","checked");
        $("#sign02").attr("checked","checked");
    }
    if($("#signCount").val() == 1){
        if($("#sign").val() == 1){
            $("#sign01").attr("checked","checked");
        }else {
            $("#sign02").attr("checked","checked");
        }
    }
    // console.log('queryDepartmentId：' + queryDepartmentId);

    // 返回按钮事件
    $("#back").on("click", function () {
        window.location.href = "scheduleList";
    });

});

// 根据就诊科室ID查询就诊房间列表和门诊医师列表
function departmentFun() {
    var departmentId = $('select option:selected').val();

    if (departmentId != 0) {
        // 根据就诊科室ID查询就诊房间列表
        $.ajax({
            type: "POST",//请求类型
            url: projectName + "/api/room/getRoomList.json",//请求的url
            data: {departmentId: departmentId},
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.code == 200) {
                    data = data.data;
                    var options = "<option value=\"\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        options += "<option value=\"" + data[i].id + "\" >" + data[i].name + "</option>";
                    }
                    $("#roomId").html(options);
                } else {
                    alert("就诊房间查询失败");
                }
            },
            error: function () {//当访问时候，404，500 等非200的错误状态码
                alert("就诊房间查询失败");
            }
        });
        // 根据就诊科室ID查询门诊医师列表
        $.ajax({
            type: "POST",//请求类型
            url: projectName + "/api/users/getDoctorList.json",//请求的url
            data: {departmentId: departmentId},
            dataType: "json",//ajax接口（请求url）返回的数据类型
            success: function (data) {//data：返回数据（json对象）
                if (data.code == 200) {
                    data = data.data;
                    var options = "<option value=\"\">--请选择--</option>";
                    for (var i = 0; i < data.length; i++) {
                        options += "<option value=\"" + data[i].id + "\" >" + data[i].userName + "</option>";
                    }
                    $("#userId").html(options);
                } else {
                    alert("就诊医生查询失败");
                }
            },
            error: function () {//当访问时候，404，500 等非200的错误状态码
                alert("就诊医生查询失败");
            }
        });
    }
}

// 表单提交
function submit() {
    var checkOne = false;   //判断是否被选择条件
    var checkBox = $('input[name = signs]');    //获得得到所的复选框
    console.log(checkBox);
    for (var i = 0; i < checkBox.length; i++) {
        //如果有1个被选中时（jquery1.6以上还可以用if(checkBox[i].prop('checked')) 去判断checkbox是否被选中）
        if (checkBox[i].checked) {
            checkOne = true;
        }
    }
    if (!checkOne) {
        alert("请至少选择一个出诊时间段!");
    }
}