<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                                <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</a>&nbsp&nbsp&nbsp
                                <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-download"></i>导入</a>&nbsp&nbsp&nbsp
                                <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-upload"></i>导出</a>
                            </div>

                            <div class="box-tools">
                                <div class="input-group input-group-sm" style="width: 150px;">
                                    <input type="text" name="table_search" class="form-control pull-right" placeholder="搜索">

                                    <div class="input-group-btn">
                                        <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>用户名</th>
                                    <th>邮箱</th>
                                    <th>密码</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users}" var="users">
                                    <tr>
                                        <td>${users.username}</td>
                                        <td>${users.email}</td>
                                        <td>${users.password}</td>
                                        <td>
                                            <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-search"></i>查看</a>&nbsp&nbsp&nbsp
                                            <a href="#" type="button" class="btn bnt-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp&nbsp&nbsp
                                            <a href="#" type="button" class="btn bnt-sm btn-danger"><i class="fa fa-trash"></i>删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>



                            </table>
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
</body>
</html>