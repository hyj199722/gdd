<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html>
<head>

    <title>客户回执编辑</title>
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
                客户回执
                <small>Customer Receipt</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>客户回执</li>
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
                            <h3 class="box-title">客户回执</h3>
                        </div>


                        <form id="customer_receipt_max_form" class="form-horizontal" action="/customer_receipt_edit" method="post">
                            <div class="box-body col-sm-12">
                                <input name="customerReceiptId" value="${customer_receipt.customerReceiptId}" hidden>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">货运单编号：</label>
                                    </label><input name="waybillId" value="${customer_receipt.waybillId}" type="text" class="col-sm-2" placeholder="请输入编号">
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">客户名称：</label><input  name="customerReceiptName" value="${customer_receipt.customerReceiptName}" type="text" class="col-sm-2" placeholder="请输入名称">

                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 收货验收记录：</label>
                                    <textarea name="customerReceiptRecord" style="width: 50%" class=" form-control"  rows="2" >${customer_receipt.customerReceiptRecord}</textarea>

                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 验收人：</label>
                                    <input name="customerReceiptCheck"type="text" class="col-sm-2"value="${customer_receipt.customerReceiptCheck}"
                                           placeholder="请输入名称">
                                    <label class="col-sm-2 control-label"> 验收时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input  name="customerReceiptDate" value="<fmt:formatDate value="${customer_receipt.customerReceiptDate}" pattern="yyyy-MM-dd"/>" readonly="readonly" type="text" class="form-control pull-right" id="datepicker">
                                    </div>

                                </div>

                                <div class="box-footer">

                                    <div class="row" style="padding-left: 700px; padding-top: 10px">

                                        <button id="customer_receipt_delete" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</button>&nbsp&nbsp&nbsp

                                        <button  type="submit" class="btn bnt-sm btn-default"><i class="fa fa-edit"></i>修改</button>&nbsp&nbsp&nbsp
                                        <a href="/customer_receipt_select" type="button" class="btn bnt-sm btn-default" ><i class="fa fa-undo"></i>返回</a>&nbsp&nbsp&nbsp
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
<!-- 自定义模态框 -->
<sys:modal />
<script>

    $("#customer_receipt_delete").bind("click",function () {
        $("#modal-message").html("确认删除当前回执？");
        $("#modal-default").modal("show");
        $("#btnModalOk").bind("click", function () {
            $("#modal-default").modal("hide");
            $("#customer_receipt_max_form").attr("action","/customer_receipt_delete?customerReceiptId="+${customer_receipt.customerReceiptId})
            $("#customer_receipt_max_form").submit();

        });
    });


</script>
</body>
</html>