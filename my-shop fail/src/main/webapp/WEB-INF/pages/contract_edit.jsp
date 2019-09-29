<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>

    <title>AdminLTE 2 | Dashboard</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <link rel="stylesheet" href="/assets/bower_components/css/waybill_add.css">
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
                编辑运输合同
                <small>Fill out a Transport contract</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>编辑运输合同</li>
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
                            <h3 class="box-title">编辑运输合同</h3>
                        </div>


                        <form class="form-horizontal" action="/contract_save" method="post">
                            <div class="box-body col-sm-12">

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">合同编号：</label>
                                    <input type="text" class="col-sm-2" placeholder="请输入编号">
                                    <label class="col-sm-2 control-label"> 承运人：</label>
                                    <select name="cars" class="col-sm-2 select">
                                        <option selected>请选择选择</option>
                                        <option value="小王">小王</option>
                                        <option value="小李">小李</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 车牌号：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入号码">
                                    <label class="col-sm-2 control-label"> 营运证：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入号码">

                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 驾驶证：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入号码">
                                    <label class="col-sm-2 control-label"> 行驶证：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入号码">

                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 发货地：</label>
                                    <select name="cars" class="col-sm-2 select">
                                        <option selected>请选择选择</option>
                                        <option value="小王">小王</option>
                                        <option value="小李">小李</option>
                                    </select>
                                    <label class="col-sm-2 control-label"> 起运时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input  type="text" class="form-control pull-right" id="datepickerss">
                                    </div>


                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 交货地：</label>
                                    <select name="cars" class="col-sm-2 select">
                                        <option selected>请选择选择</option>
                                        <option value="小王">小王</option>
                                        <option value="小李">小李</option>
                                    </select>
                                    <label class="col-sm-2 control-label"> 到达时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input  type="text" class="form-control pull-right" id="datepickers">
                                    </div>


                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 收货联系人：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入名字">
                                    <label class="col-sm-2 control-label"> 联系人手机：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入号码">

                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 收货详细地址：</label>
                                    <input type="text" class="col-sm-6"
                                           placeholder="请输入地址">
                                </div>

                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 承运人订装货物保证金：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入金额">
                                    <label class="col-sm-2 control-label"> 配车服务费：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入金额">

                                </div>

                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 运费结算方式：</label>
                                    <select name="cars" class="col-sm-2 select">
                                        <option selected>请选择选择</option>
                                        <option value="小王">小王</option>
                                        <option value="小李">小李</option>
                                    </select>
                                    <label class="col-sm-2 control-label"> 送货单回执押金：</label>
                                    <input type="text" class="col-sm-2"
                                           placeholder="请输入金额">

                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 运费计价方式：</label>
                                    <select name="cars" class="col-sm-2 select">
                                        <option selected>请选择选择</option>
                                        <option value="小王">小王</option>
                                        <option value="小李">小李</option>
                                    </select>


                                </div>


                                <div class="form-group">
                                    <label class="col-sm-2 control-label">运费：</label>
                                    <input type="text" class="col-sm-2" placeholder="请输入金额">
                                    <label class="col-sm-2 control-label">保险费：</label><input type="text" class="col-sm-2" placeholder="请输入金额">
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">预付费用：</label>
                                    <input type="text" class="col-sm-2" placeholder="请输入金额">
                                    <label class="col-sm-2 control-label">鉴定时间：</label> <div  class="col-sm-2 input-group date">
                                    <div style="height:26px ;margin-bottom: 8px" class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input style="height:26px ;margin-bottom: 8px" type="text" class="form-control pull-right" id="datepicker">
                                </div>

                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 备注：</label>
                                    <input type="text"  placeholder="请输入备注">

                                </div>
                                <div class="form-group">
                                    <div class="row" style="padding-left: 50px; padding-top: 10px">
                                    <a href="/itemdrive_select" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>运输货物列表</a>&nbsp&nbsp&nbsp
                                    </div>
                                </div>
                                <div class="box-footer">

                                    <div class="row" style="padding-left: 600px; padding-top: 10px">

                                        <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</a>&nbsp&nbsp&nbsp
                                        <a href="#" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>修改</a>&nbsp&nbsp&nbsp
                                        <button type="button" class="btn bnt-sm btn-default" onclick="window.location.href=document.referrer"><i class="fa fa-plus"></i>返回</button>&nbsp&nbsp&nbsp
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