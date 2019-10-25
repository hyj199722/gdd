<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>

    <title>投诉处理</title>
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


                        <form class="form-horizontal"  id="commentForm" action="/complaint_edit" method="post">
                            <div class="box-body col-sm-12">
                                <input name="complaintId" value="${complaint.complaintId}" hidden>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">投诉货运单编号：</label>
                                    </label><input name="waybillId" value="${complaint.waybillId}"type="text" class="col-sm-2" placeholder="请输入编号">
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">投诉事件详情：</label>
                                    <textarea name="complaintDetail" style="width: 50%" class=" form-control"  rows="2" >${complaint.complaintDetail}</textarea>

                                </div>



                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 投诉人：</label>
                                    <input name="complaintPerson" value="${complaint.complaintPerson}"type="text" class="col-sm-2" placeholder="请输入名字">

                                    <label class="col-sm-2 control-label"> 投诉时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input  name="complaintDate" value="<fmt:formatDate value="${complaint.complaintDate}" pattern="yyyy-MM-dd"/>" readonly="readonly" type="text" class="form-control pull-right" id="datepicker">
                                    </div>


                                </div>

                            </div>

                            <div class="box-body col-sm-12">
                                <h4>处理情况</h4>
                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 是否处理：</label>
                                    <select name="complaintDoType" class="col-sm-2 select">

                                        <option selected value="是" ${complaint.complaintDoType=='是'?"selected":""}>是</option>
                                        <option value="否" ${complaint.complaintDoType=='否'?"selected":""}>否</option>
                                    </select>

                                    <label class="col-sm-2 control-label"> 处理时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i  class=" fa fa-calendar"></i>
                                        </div>
                                        <input  type="text" value="<fmt:formatDate value="${localDate}" pattern="yyyy-MM-dd"></fmt:formatDate> " name="complaintDoDate" class="form-control pull-right" id="datepicker">
                                    </div>


                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">处理结果：</label>
                                    <textarea name="complaintDoResult" style="width: 50%" class=" form-control" required rows="2" >${complaint.complaintDoResult}</textarea>

                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 是否回告：</label>

                                    <select name="complaintReplyType" class="col-sm-2 select">

                                        <option  selected value="是" ${complaint.complaintReplyType=='是'?"selected":""}>是</option>
                                        <option value="否" ${complaint.complaintReplyType=='否'?"selected":""}>否</option>
                                    </select>

                                    <label class="col-sm-2 control-label"> 回告时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div  class="input-group-addon">
                                            <i  class=" fa fa-calendar"></i>
                                        </div>
                                        <input  type="text" value="<fmt:formatDate value="${localDate}" pattern="yyyy-MM-dd"></fmt:formatDate> " name="ComplaintReplyDate" class="form-control pull-right" id="datepicker">
                                    </div>


                                </div>

                            </div>


                        <div class="box-footer">

                            <div class="row" style="padding-left: 800px; padding-top: 10px">

                                <button  type="submit" class="btn bnt-sm btn-default"><i class="fa fa-edit"></i>修改</button>&nbsp&nbsp&nbsp
                                <a href="/complaint_manager" type="button" class="btn bnt-sm btn-default" ><i class="fa fa-undo"></i>返回</a>&nbsp&nbsp&nbsp
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
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>

    $().ready(function() {
        $("#commentForm").validate();
    });
</script>
<style>
    label.error {
        color: red;
        font-size: 16px;
        font-weight: normal;
        line-height: 1.4;
        margin-top: 0.5em;
        width: 100%;
        float: none;
    }

    @media screen and (orientation: portrait){
        label.error { margin-left: 0; display: block; }
    }

    @media screen and (orientation: landscape){
        label.error { display: inline-block; margin-left: 35%; }
    }

    em { color: red; font-weight: bold; padding-right: .25em; }
</style>
</body>
</html>