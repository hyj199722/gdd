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
                货运单查询
                <small>WayBill  Query</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>货运单查询</li>
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
                            <div class="row" style="padding-left: 12px; padding-top: 10px">
                                <a href="/waybill_add" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>新增</a>&nbsp&nbsp&nbsp
                            </div>
                            <h2></h2>
                            <h3 class="box-title">查询条件</h3>
                            <form class="form-horizontal" action="#" method="post">
                                <div class="box-body col-sm-12 page">

                                    <div class="form-group">
                                    <label class="col-sm-2 control-label">运单号：</label>
                                    <input type="text" class="col-sm-2" placeholder="请输入编号">
                                        <label class="col-sm-2 control-label">发货客户：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入客户">
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">收货客户：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入客户">
                                        <label class="col-sm-2 control-label">托运时间：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入时间">
                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">起点站：</label>
                                        <select name="cars" class="col-sm-2 select">
                                            <option value="货运单">货运单</option>
                                            <option value="运输合同">运输合同</option>
                                        </select>
                                        <label class="col-sm-2 control-label">终点站：</label>
                                        <select name="cars" class="col-sm-2 select">
                                            <option selected>请选择选择</option>
                                            <option value="小王">小王</option>
                                            <option value="小李">小李</option>
                                            <option value="小李">小李</option>
                                        </select>

                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">状态：</label>
                                        <select name="cars" class="col-sm-2 select">
                                            <option selected>请选择选择</option>
                                            <option value="小王">小王</option>
                                            <option value="小李">小李</option>
                                            <option value="小李">小李</option>
                                        </select>
                                        <button type="submit" class="btn btn-info pull-right">查询</button>
                                    </div>

                                </div>
                            </form>

                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>货运单编号</th>
                                    <th>起点</th>
                                    <th>终点</th>
                                    <th>托运时间</th>
                                    <th>收货客户</th>
                                    <th>收货客户手机</th>
                                    <th>状态</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users}" var="users">
                                    <tr>
                                        <td> <a href="/waybill_edit" >${users.username}</a></td>
                                        <td>${users.email}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>
                                        <td>${users.password}</td>
                                    </tr>
                                </c:forEach>

                                </tbody>


                            </table>
                        </div>
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