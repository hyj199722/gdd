<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html>
<head>

    <title>AdminLTE 2 | Dashboard</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>

</head>


<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"></jsp:include>

    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
                <small>User panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">用户面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult.status!=null}">
                        <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <h4><i class="icon fa fa-ban"></i> Alert!</h4>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>

                            <div class="row" style="padding-left: 12px; padding-top: 10px">
                                <a href="/user_from" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>新增</a>&nbsp&nbsp&nbsp
                                <%--<a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</a>&nbsp&nbsp&nbsp--%>
                                <button type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/users_delete')"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                            </div>

                            <div class="box-tools">
                                <form action="/user_search" method="post">
                                <div class="input-group input-group-sm" style="width: 150px;">
                                    <input type="text" name="username" class="form-control pull-right" placeholder="用户名搜索">

                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                                </form>
                            </div>

                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master"></th>
                                    <th>用户名</th>
                                    <th>邮箱</th>
                                    <th>密码</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="users">
                                    <tr>
                                        <td><input id="${users.id}" type="checkbox" class="minimal"></td>
                                        <td>${users.username}</td>
                                        <td>${users.email}</td>
                                        <td>${users.password}</td>
                                        <td>
                                            <a href="/to_edit?id=${users.id}" type="button" class="btn bnt-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp&nbsp&nbsp
                                            <%--<a href="/user_delete?id=${users.id}" type="button" class="btn bnt-sm btn-danger"><i class="fa fa-trash"></i>删除</a>--%>
                                            <button  onclick="App.deleteSingle('/users_delete',${users.id},'确认删除用户:'+${users.username})" type="button" class="btn bnt-sm btn-danger"><i class="fa fa-trash"></i>删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>

                            </table>
                        </div>
                        <%--分页信息--%>
                        <div class="row">
                            <%--分页文字信息--%>
                            <div class="col-md-6">
                                当前${pageInfo.pageNum}页，总${pageInfo.pages}页，总共${pageInfo.total}条记录
                            </div>
                            <%--分页条信息--%>
                            <div class="col-md-6">
                                <nav aria-label="Page navigation">
                                    <ul class="pagination">
                                        <li><a href="/user_list?pn=1">首页</a> </li>
                                        <%--如果有上一页，则可以通过减一操作移动，且有<符号&laquo，否则连点<的符号也没有，也就不能移动上一页--%>
                                        <c:if test="${pageInfo.hasPreviousPage}">
                                            <li>
                                                <a href="/user_list?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                                    <span aria-hidden="true">&laquo;</span>
                                                </a>
                                            </li>
                                        </c:if>


                                        <%--如果是当前页，则显示高亮--%>
                                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                                            <c:if test="${page_Num==pageInfo.pageNum}">
                                                <li class="active"><a href="#">${page_Num}</a></li>
                                            </c:if>
                                            <c:if test="${page_Num!=pageInfo.pageNum}">
                                                <li><a href="/user_list?pn=${page_Num}">${page_Num}</a></li>
                                            </c:if>

                                        </c:forEach>
                                        <c:if test="${pageInfo.hasNextPage}">
                                            <li>
                                                <a href="/user_list?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                                    <span aria-hidden="true">&raquo;</span>
                                                </a>
                                            </li>
                                        </c:if>

                                        <li><a href="/user_list?pn=${pageInfo.pages}">末页</a> </li>
                                        <form style="float: left" action="/user_list">
                                            <input type="text" name="pn" style="height:33px;width: 50px">
                                            <input type="submit" value="跳转" class="btn btn-primary">
                                        </form>


                                    </ul>
                                </nav>
                            </div>

                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>

        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"></jsp:include>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>
<!-- 自定义模态框 -->
<sys:modal />
</body>
</html>