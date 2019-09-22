<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

    <title>AdminLTE 2 | Dashboard</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <link rel="stylesheet" href="/assets/bower_components/css/bill_select.css">

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
                运输货物编辑
                <small>Item Query</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>运输货物编辑</li>
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

                        <form class="form-horizontal" action="#" method="post">
                            <div class="row" style="padding-left: 20px; padding-top: 10px">
                                <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>全选</a>&nbsp&nbsp&nbsp
                                <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>反选</a>&nbsp&nbsp&nbsp
                                <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>装货</a>&nbsp&nbsp&nbsp
                            </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>货物单编号</th>
                                    <th>品名</th>
                                    <th>货号（件）</th>
                                    <th>件数</th>
                                    <th>重量</th>
                                    <th>体积</th>
                                    <th>卸货件数</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users}" var="users">
                                    <tr>
                                        <td> <a href="/itemdriver_selectd" >${users.username}</a></td>
                                        <td>${users.email}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>


                                    </tr>
                                </c:forEach>

                                </tbody>


                            </table>
                        </div>
                        </form>
                        <div class="page">
                            <ul class="pagination ">
                                <li><a href="#">&laquo;</a></li>
                                <li><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li><a href="#">&raquo;</a></li>
                            </ul>
                        </div>
                        <!-- /.box-body -->

                    </div>
                </div>
            </div>

        </section>
    </div>
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.2.0
        </div>
        <strong>Copyright &copy; 2019-2019 <a href="#">We can resolve it</a>.</strong> All rights
        reserved.
    </footer>

</div>


<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>