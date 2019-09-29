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
                客户投诉
                <small>Complaint</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>客户投诉</li>
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
                            <h3 class="box-title">客户投诉</h3>
                        </div>


                        <form class="form-horizontal" action="/complaint_save" method="post">
                            <div class="box-body col-sm-12">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">投诉货运单编号：</label>
                                    </label><input type="text" class="col-sm-2" placeholder="请输入编号">
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">投诉事件详情：</label><input type="text" class="col-sm-2" placeholder="请输入详情"">

                                </div>



                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 投诉时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input  type="text" class="form-control pull-right" id="datepicker">
                                    </div>

                                    <label class="col-sm-2 control-label"> 投诉人：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入名称">
                                </div>

                            </div>

                            <div class="box-body col-sm-12">
                                <h2>处理情况</h2>
                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 是否处理：</label>
                                    <select name="cars" class="col-sm-2 select">
                                        <option selected>请选择选择</option>
                                        <option value="小王">小王</option>
                                        <option value="小李">小李</option>
                                    </select>

                                    <label class="col-sm-2 control-label"> 处理时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input  type="text" class="form-control pull-right" id="datepicker">
                                    </div>


                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">处理结果：</label><input type="text" class="col-sm-2" placeholder="请输入详情">

                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 是否回告：</label>
                                    <select name="cars" class="col-sm-2 select">
                                        <option selected>请选择选择</option>
                                        <option value="小王">小王</option>
                                        <option value="小李">小李</option>
                                    </select>

                                    <label class="col-sm-2 control-label"> 回告时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input  type="text" class="form-control pull-right" id="datepicker">
                                    </div>


                                </div>

                            </div>
                        </form>

                        <div class="box-footer">

                            <div class="row" style="padding-left: 600px; padding-top: 10px">

                                <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>修改</a>&nbsp&nbsp&nbsp
                                <button type="button" class="btn bnt-sm btn-default" onclick="window.location.href=document.referrer"><i class="fa fa-plus"></i>返回</button>&nbsp&nbsp&nbsp
                            </div>

                        </div>
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