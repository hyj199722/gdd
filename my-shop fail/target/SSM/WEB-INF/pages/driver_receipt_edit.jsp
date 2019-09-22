<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

    <title>AdminLTE 2 | Dashboard</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <link rel="stylesheet" href="/assets/bower_components/css/bill_add.css">
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
                司机回执
                <small>Driver Receipt</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>司机回执</li>
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

                    <div class="box box-info box-size">
                        <div class="box-header with-border">
                            <h3 class="box-title">司机回执</h3>
                        </div>


                        <form class="form-horizontal" action="/driver_receipt_save" method="post">
                            <div class="box-body col-sm-12">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">运输合同编号：</label>
                                    </label><input type="text" class="col-sm-2" placeholder="请输入编号">
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">司机名称：</label><input type="text" class="col-sm-2" placeholder="请输入名称">

                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 收货验收记录：</label>
                                    <input type="text"  placeholder="请输入内容">

                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 验收时间：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入日期">
                                    <label class="col-sm-2 control-label"> 验收人：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入名称">
                                </div>

                                <div class="box-footer">

                                    <div class="row" style="padding-left: 600px; padding-top: 10px">

                                        <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</a>&nbsp&nbsp&nbsp
                                        <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>修改</a>&nbsp&nbsp&nbsp
                                        <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>返回</a>&nbsp&nbsp&nbsp
                                    </div>

                                </div>

                            </div>
                        </form>
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