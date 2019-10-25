<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page import="java.util.Date" %>


<!DOCTYPE html>
<html>
<head>

    <title>司机回执添加</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <link rel="stylesheet" href="/assets/bower_components/css/bill_add.css">
    <%pageContext.setAttribute("localDate",new Date());%>
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


                        <form class="form-horizontal" action="/driver_receipt_save" method="POST">
                            <div class="box-body col-sm-12">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">运输合同编号：</label>
                                    </label><input type="text"<c:if test="${driver_receipt.contractId!=null}">value="${driver_receipt.contractId}" </c:if> name="contractId" class="col-sm-2" placeholder="请输入编号">
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">司机名称：</label><input type="text"name="driverReceiptName" <c:if test="${driver_receipt.driverReceiptName!=null}">value="${driver_receipt.driverReceiptName}" </c:if>class="col-sm-2" placeholder="请输入名称">

                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 收货验收记录：</label>

                                        <textarea style="width: 50%" class=" form-control" name="driverReceiptRecord" rows="2" placeholder="请输入内容"><c:if test="${driver_receipt.driverReceiptRecord!=null}">${driver_receipt.driverReceiptRecord} </c:if></textarea>


                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 验收人：</label>
                                    <input type="text" class="col-sm-2"
                                           <c:if test="${driver_receipt.driverReceiptCheck!=null}">value="${driver_receipt.driverReceiptCheck}" </c:if>   name="driverReceiptCheck" placeholder="请输入名称">
                                    <label class="col-sm-2 control-label"> 验收时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i  class=" fa fa-calendar"></i>
                                        </div>
                                        <input  type="text" value="<fmt:formatDate value="${localDate}" pattern="yyyy-MM-dd"></fmt:formatDate> " name="driverReceiptDate" class="form-control pull-right" id="datepicker">
                                    </div>


                                </div>

                                <div class="box-footer">
                                    <a href="/driver_receipt_select" type="button" class="btn bnt-sm btn-default" ><i class="fa fa-undo"></i>返回</a>&nbsp&nbsp&nbsp
                                    <button type="submit" class="btn btn-info pull-right">提交</button>

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