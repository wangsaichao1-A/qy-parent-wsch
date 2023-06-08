<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@include file="common/header.html"%>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>用户信息管理</h2>
				<div class="clearfix"></div>
			</div>

			<div class="x_content">
				<form method="post" action="list">
					<input type="hidden" name="pageNo" value="1" />
					<input type="hidden" id="queryUserType" value="${queryUserType}">

					<ul>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">用户类型</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<select id="userType" name="userType" class="form-control">
									</select>
								</div>
							</div>
						</li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">账号</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input name="account" type="text" class="form-control col-md-7 col-xs-12" value="${queryAccount}">
								</div>
							</div>
						</li>
						<li>
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">用户名</label>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<input name="userName" type="text" class="form-control col-md-7 col-xs-12" value="${queryUserName}">
								</div>
							</div>
						</li>
						<button type="submit" class="btn btn-primary"> 搜 &nbsp;&nbsp;&nbsp;&nbsp;索 </button></li>
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
							<a href="${pageContext.request.contextPath}/api/users/addUser" class="btn btn-success btn-sm">新增用户</a>
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
										用户类型</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										账号</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										用户名</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										创建时间</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										创建人ID</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										aria-label="Last name: activate to sort column ascending">
										状态</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 124px;"
										aria-label="Last name: activate to sort column ascending">
										操作</th>
								</tr>
								</thead>
								<tbody>
								<c:forEach var="sysUser" items="${usersDtoList }" varStatus="status">
									<tr role="row" class="odd">
										<td tabindex="0" class="sorting_1">${sysUser.id}</td>
										<td>${sysUser.userTypeName }</td>
										<td>${sysUser.account }</td>
										<td>${sysUser.userName }</td>
										<td>${sysUser.createdTime }</td>
										<td>${sysUser.createdUserId }</td>
										<td>
											<c:if test="${sysUser.status == 0}">启用</c:if>
											<c:if test="${sysUser.status == 1}">禁用</c:if>
										</td>
										<td>
											<div class="btn-group">
												<c:if test="${sysUser.status == 0}"><button data-down="${sysUser.id}" type="button" class="viewRegister">禁用</button></c:if>
												<c:if test="${sysUser.status == 1}"><button data-down="${sysUser.id}" type="button" class="viewRegister">启用</button></c:if>
											</div>
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
<script src="${pageContext.request.contextPath }/statics/localjs/userList.js"></script>