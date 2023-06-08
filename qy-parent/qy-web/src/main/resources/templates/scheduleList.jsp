<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="common/header.html"%>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>医生出诊信息管理</h2>
				<div class="clearfix"></div>
			</div>

			<div class="x_content">
				<form method="post" action="scheduleList">
					<input type="hidden" name="pageNo" value="1" />
					<input type="hidden" id="queryDepartmentId" value="${queryDepartmentId}">
					<input type="hidden" id="queryRoomId" value="${queryRoomId}">
			    <ul>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">就诊科室</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="departmentId" name="departmentId" class="form-control" onclick="departmentFun()">
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">诊室名称</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<select id="roomId" name="roomId" class="form-control">
									<option value="">--请先选择就诊科室--</option>
        						</select>
							</div>
						</div>
					</li>
					<li>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">门诊医师</label>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<input name="doctorName" type="text" class="form-control col-md-7 col-xs-12" value="${queryDoctorName}">
							</div>
						</div>
					</li>
					<li><button type="submit" class="btn btn-primary"> 查 &nbsp;&nbsp;&nbsp;&nbsp;询 </button></li>
				</ul>
				</form>
			</div>
		</div>
	</div>
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_content">
				<p class="text-muted font-13 m-b-30"></p>
				<div id="datatable-responsive_wrapper"
					 class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row">
						<div class="col-sm-12">
							<a href="${pageContext.request.contextPath}/api/schedule/addSchedule" class="btn btn-success btn-sm">新增</a>
							<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
								   cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
								<thead>
								<tr role="row">
									<th class="sorting_asc" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="First name: activate to sort column descending"
										aria-sort="ascending">编号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										科室</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										诊室名称</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										门诊医师</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										出诊日期</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										出诊时间段</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										号源</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 124px;"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
								</thead>
								<tbody>
								<%--<c:set var="nowDate" value="<%=System.currentTimeMillis()%>"></c:set>--%>
								<jsp:useBean id="now" class="java.util.Date" scope="page"/>
								<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="now" />
								<c:forEach var="schedule" items="${scheduleList }" varStatus="status">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${schedule.id}</td>
										<td>${schedule.departmentName }</td>
										<td>${schedule.roomName }</td>
										<td>${schedule.doctorName }</td>
										<td>${schedule.inquiryTime }</td>
										<td>
											<c:if test="${schedule.sign == 1}">上午</c:if>
											<c:if test="${schedule.sign == 2}">下午</c:if>
										</td>
										<td>${schedule.remainingQuantity }</td>
										<td>
											<fmt:parseDate value="${schedule.inquiryTime}" pattern="yyyy-MM-dd" var="inquiryTime"/>
											<fmt:parseDate value="${now}" pattern="yyyy-MM-dd" var="nowDate"/>
											<c:choose>
											<c:when test="${nowDate.getTime()-inquiryTime.getTime() > 0}">
											</c:when>
											<c:otherwise>
												<div class="btn-group">
													<button data-down="${schedule.id}" type="button" class="viewRegister">删除</button>
												</div>
											</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-5">
							<div class="dataTables_info" id="datatable-responsive_info"
								 role="status" aria-live="polite">共${pages.total }条记录
								${pages.pageNo }/${pages.pages }页</div>
						</div>
						<div class="col-sm-7">
							<div class="dataTables_paginate paging_simple_numbers"
								 id="datatable-responsive_paginate">
								<ul class="pagination">
									<c:if test="${pages.pageNo > 1}">
										<li class="paginate_button previous"><a
												href="javascript:page_nav(document.forms[0],1);"
												aria-controls="datatable-responsive" data-dt-idx="0"
												tabindex="0">首页</a>
										</li>
										<li class="paginate_button "><a
												href="javascript:page_nav(document.forms[0],${pages.pageNo-1});"
												aria-controls="datatable-responsive" data-dt-idx="1"
												tabindex="0">上一页</a>
										</li>
									</c:if>
									<c:if test="${pages.pageNo < pages.pages }">
										<li class="paginate_button "><a
												href="javascript:page_nav(document.forms[0],${pages.pageNo+1 });"
												aria-controls="datatable-responsive" data-dt-idx="1"
												tabindex="0">下一页</a>
										</li>
										<li class="paginate_button next"><a
												href="javascript:page_nav(document.forms[0],${pages.pages });"
												aria-controls="datatable-responsive" data-dt-idx="7"
												tabindex="0">最后一页</a>
										</li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<%@include file="common/footer.jsp"%>
<script src="${pageContext.request.contextPath }/statics/localjs/rollpage.js"></script>
<script src="${pageContext.request.contextPath }/statics/localjs/scheduleList.js"></script>