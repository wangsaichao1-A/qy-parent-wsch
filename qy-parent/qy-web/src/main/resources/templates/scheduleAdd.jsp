<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/header.html"%>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12 col-sm-12 col-xs-12">
    <div class="x_panel">
      <div class="x_title">
        <h2>新增医生排期</h2>
        <div class="clearfix"></div>
      </div>
      <div class="x_content">
           <div class="clearfix"></div>
        <form id="addScheduleForm" class="form-horizontal form-label-left" action="addSchedule" method="post">
          <input type="hidden" id="queryDepartmentId" value="${queryDepartmentId}">
          <input type="hidden" id="queryRoomId" value="${queryRoomId}">
          <input type="hidden" id="queryUserId" value="${queryUserId}">
          <input type="hidden" id="queryInquiryTime" value="${queryInquiryTime}">
          <input type="hidden" id="queryRemainingQuantity" value="${queryRemainingQuantity}">
          <input type="hidden" id="signCount" value="${signCount}">
          <input type="hidden" id="sign" value="${sign}">

          <div class="item form-group" id="departmentIdDiv">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="departmentId">科室 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="departmentId" id="departmentId" class="form-control" onclick="departmentFun()" required="required">
              </select>
            </div>
          </div>
          <div class="item form-group" id="roomDiv">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="roomId">诊室名称 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="roomId" id="roomId" class="form-control" required="required">
                <option value="">--请先选择科室--</option>
              </select>
            </div>
          </div>
          <div class="item form-group" id="doctorDiv">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="userId">门诊医师 <span class="required">*</span></label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <select name="userId" id="userId" class="form-control" required="required">
                <option value="">--请先选择科室--</option>
              </select>
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="inquiryTime">出诊时间 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="inquiryTime" class="form-control col-md-7 col-xs-12"
                     data-validate-length-range="20" data-validate-words="1" name="inquiryTime" required="required"
                     placeholder="请选择出诊时间" type="date">
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12">出诊时间段 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="sign01" name="signs" value="1" type="checkbox" />上午
              <input id="sign02" name="signs" value="2" type="checkbox" />下午
            </div>
          </div>
          <div class="item form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="remainingQuantity">号源 <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input id="remainingQuantity" class="form-control col-md-7 col-xs-12"
                     data-validate-length-range="20" data-validate-words="1" name="remainingQuantity" required="required"
                     placeholder="请输入号源数量" type="text" oninput = "value=value.replace(/[^\d]/g,'')">
            </div>
          </div>
          <div class="item form-group">
            <div style="text-align: center;color: red;font-size: initial;">
              ${msg }
            </div>
          </div>

          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-md-offset-3">
              <button id="send" type="submit" class="btn btn-success">保存</button>
              <button type="button" class="btn btn-primary" id="back">返回</button>
              <br/><br/>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/scheduleAdd.js"></script>