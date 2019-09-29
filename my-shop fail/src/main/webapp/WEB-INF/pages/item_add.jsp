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
                货物单编辑
                <small>WayBill  Query</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>货物单编辑</li>
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


                            <form class="form-horizontal" action="#" method="post">
                                <div class="box-body col-sm-12 page">

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">货运单编号：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入编号">

                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">货物名称：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入名称">
                                        <label class="col-sm-2 control-label">编号：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入编号">
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label"> 包装：</label>
                                        <select name="cars" class="col-sm-2 select">
                                            <option selected>请选择选择</option>
                                            <option value="小王">小王</option>
                                            <option value="小李">小李</option>
                                        </select>
                                        <label class="col-sm-2 control-label"> 件数：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入件数">
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">重量（千克）：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入重量">
                                        <label class="col-sm-2 control-label">体积（立方米）：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入体积">
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">货物价值（元）：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入价格">
                                        <label class="col-sm-2 control-label">保险费率：</label>
                                        <input type="text" class="col-sm-2" placeholder="请输入费率">
                                    </div>
                                    <div class="form-group">

                                        <label class="col-sm-2 control-label"> 计价方式：</label>
                                        <select name="cars" class="col-sm-2 select">
                                            <option selected>请选择选择</option>
                                            <option value="小王">小王</option>
                                            <option value="小李">小李</option>
                                            <option value="小李">小李</option>

                                        </select>
                                        <label class="col-sm-2 control-label"> 运输费：</label>
                                        <input type="text" class="col-sm-2"
                                               placeholder="请输入价钱">

                                    </div>

                                    <div class="row" style="padding-left: 50px; padding-top: 10px">
                                        <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>添加</a>&nbsp&nbsp&nbsp
                                        <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</a>&nbsp&nbsp&nbsp
                                        <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>修改</a>&nbsp&nbsp&nbsp
                                        <button type="button" class="btn bnt-sm btn-default" onclick="window.location.href=document.referrer"><i class="fa fa-plus"></i>返回</button>&nbsp&nbsp&nbsp
                                    </div>
                                </div>
                            </form>

                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>货物名称</th>
                                    <th>编号</th>
                                    <th>包装</th>
                                    <th>件数</th>
                                    <th>重量</th>
                                    <th>体积</th>
                                    <th>货物价值</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${users}" var="users">
                                    <tr>
                                        <td> <a href="/item_edit" >${users.username}</a></td>
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