
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>


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
                票据编辑
                <small>Bill Distribution</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>票据编辑</li>
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
                            <h3 class="box-title">票据分发</h3>
                        </div>


                        <form id="bill_max_form" class="form-horizontal" action="/bill_edit?pageNum=${pageNum}" method="POST">
                            <input name="billId" value="${bill.billId}" hidden>
                            <div class="box-body col-sm-12">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">单据类型：</label>
                                    <select  disabled=disabled  class="col-sm-2 select">
                                        <option value="1" ${bill.billType==1?"selected":""}>货运单</option>
                                        <option value="2" ${bill.billType==2?"selected":""} >运输合同</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">单据开始号：</label><input value="${bill.billBegin}" readonly=readonly type="text" class="col-sm-2" placeholder="请输入编号">
                                    <label class="col-sm-2 control-label">单据结束号：</label><input value="${bill.billEnd}" readonly=readonly type="text" class="col-sm-2" placeholder="请输入编号">
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 领票人：</label>
                                    <select name="billTaker" class="col-sm-2 select">
                                        <option selected value="${bill.billTaker}">${bill.billTaker}</option>
                                        <c:forEach items="${staff}" var="staff">
                                            <option value="${staff.staff}">${staff.staff}</option>
                                        </c:forEach>

                                    </select>
                                    <label class="col-sm-2 control-label"> 接货点：</label>
                                    <input type="text" name="billLocation" value="${bill.billLocation}" class=" col-sm-2 "
                                           placeholder="请输入地址">
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 领票时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div style="height:26px ;margin-bottom: 8px" class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input style="height:26px ;margin-bottom: 8px"  value="<fmt:formatDate value="${bill.billDate}" pattern="yyyy-MM-dd"/>" readonly="readonly" type="text" class="form-control pull-right" id="datepicker">
                                    </div>

                                    <label class="col-sm-2 control-label"> 分发人：</label>
                                    <select name="billGiver" class="col-sm-2 select">
                                        <option selected value="${bill.billGiver}">${bill.billGiver}</option>
                                        <c:forEach items="${staff}" var="staff">
                                            <option value="${staff.staff}">${staff.staff}</option>
                                        </c:forEach>

                                    </select>
                                </div>


                                <div class="box-footer">

                                    <div class="row" style="padding-left: 600px; padding-top: 10px">

                                        <button id="bill_delete" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</button>&nbsp&nbsp&nbsp

                                        <button  type="submit" class="btn bnt-sm btn-default"><i class="fa fa-edit"></i>修改</button>&nbsp&nbsp&nbsp
                                        <a href="/bill_list" type="button" class="btn bnt-sm btn-default" ><i class="fa fa-recycle"></i>返回</a>&nbsp&nbsp&nbsp
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

        $("#bill_delete").bind("click",function () {
            $("#modal-message").html("确认删除当前票据项？");
            $("#modal-default").modal("show");
            $("#btnModalOk").bind("click", function () {
                $("#modal-default").modal("hide");
                $("#bill_max_form").attr("action","/bill_delete?billId="+${bill.billId})
                $("#bill_max_form").submit();

            });
        });


</script>
</body>
</html>