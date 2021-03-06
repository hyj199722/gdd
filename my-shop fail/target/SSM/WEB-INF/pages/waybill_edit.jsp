<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
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
                货运单编辑
                <small> Fill out a WayBill </small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>货运单编辑</li>
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
                            <h3 class="box-title">货运单编辑  <small><c:if test="${waybill.waybillStatus!=1}">货运单已发车，无法编辑</c:if></small></h3>
                        </div>


                        <form class="form-horizontal" action="/waybill_save" method="post" id="waybillForm">
                            <div class="box-body col-sm-12">

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">货运单编号：</label>
                                    <input type="text" readonly name="waybillId" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> value="${waybill.waybillId}" class="col-sm-2" placeholder="请输入编号">
                                    <label class="col-sm-2 control-label">托运日期：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> value="<fmt:formatDate value="${waybill.waybillDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" name="waybillDate" class="form-control pull-right" id="waybillDate">
                                    </div>
                                </div>

                                </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label"> 起点站：</label>
                                <input type="text"  <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillBegin" class=" col-sm-2 " placeholder="请输入起点站" value="${waybill.waybillBegin}">
                                <label class="col-sm-2 control-label"> 到达站：</label>
                                <input type="text"  <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillEnd" class=" col-sm-2 " placeholder="请输入终点站" value="${waybill.waybillEnd}">
                            </div>

                            <div class="form-group">

                                <label class="col-sm-2 control-label"> 收货客户：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if>  name="waybillRecive" class=" col-sm-2 " placeholder="请输入收货客户" value="${waybill.waybillRecive}">
                                <label class="col-sm-2 control-label"> 收货客户地址：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if>  class="col-sm-2" name="waybillReciveAddress" placeholder="请输入地址" value="${waybill.waybillReciveAddress}">

                            </div>

                            <div class="form-group">


                                <label class="col-sm-2 control-label"> 收货客户电话：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> class="col-sm-2" name="waybillRecivePhone" placeholder="请输入号码" value="${waybill.waybillRecivePhone}">

                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label"> 发货客户：</label>
                                <input type="text"  <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillSend" class=" col-sm-2 " placeholder="请输入发货客户" value="${waybill.waybillSend}">
                                <label class="col-sm-2 control-label"> 发货客户地址：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> class="col-sm-2" name="waybillSendAddress" placeholder="请输入地址"value="${waybill.waybillSendAddress}">
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label"> 发货客户电话：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> class="col-sm-2" name="waybillSendPhone" placeholder="请输入号码" value="${waybill.waybillSendPhone}">
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label"> 代收贷款：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> class="col-sm-2" name="waybillLoan" placeholder="请输入贷款" value="${waybill.waybillLoan}">
                                <label class="col-sm-2 control-label"> 代收佣金率：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> class="col-sm-2" name="waybillCommission" placeholder="请输入佣金率" value="${waybill.waybillCommission}">
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label"> 业务员：</label>
                                <select <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillSalesman" class="col-sm-2 select">
                                    <option selected>请选择</option>
                                    <c:forEach items="${staff}" var="staff">
                                        <option value="${staff.staff}" <c:if test="${staff.staff==waybill.waybillSalesman}">selected</c:if>>${staff.staff}</option>
                                    </c:forEach>
                                </select>
                                <label class="col-sm-2 control-label">运费：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if>  name="waybillFreight" class="col-sm-2" placeholder="请输入金额" value="${waybill.waybillFreight}">
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">保险费：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillInsurance" class="col-sm-2" placeholder="请输入金额" value="${waybill.waybillInsurance}">
                                <label class="col-sm-2 control-label"> 付款方式：</label>
                                <select <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillPayType" class="col-sm-2 select">
                                    <option selected value="0" >请选择</option>
                                    <option value="1"<c:if test="${'1' eq waybill.waybillPayType}">selected</c:if>>现付</option>
                                    <option value="2"<c:if test="${'2' eq waybill.waybillPayType}">selected</c:if>>提付</option>
                                    <option value="3"<c:if test="${'3' eq waybill.waybillPayType}">selected</c:if>>回单付</option>
                                    <option value="4"<c:if test="${'4' eq waybill.waybillPayType}">selected</c:if>>月结</option>

                                </select>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label"> 取货方式：</label>
                                <select <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillReciveType" class="col-sm-2 select">
                                    <option selected value="0">请选择</option>
                                    <option value="1"<c:if test="${'1' eq waybill.waybillReciveType}">selected</c:if>>自提</option>
                                    <option value="2"<c:if test="${'2' eq waybill.waybillReciveType}">selected</c:if>>送货</option>

                                </select>
                                <label class="col-sm-2 control-label"> 填票人：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillFill" value="${waybill.waybillFill}" class="col-sm-2" placeholder="请输入填票人">

                            </div>
                            <div class="form-group">

                                <label class="col-sm-2 control-label">付回扣：</label>
                                <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillRebate" class="col-sm-2" placeholder="请输入金额" value="${waybill.waybillRebate}">
                                <label class="col-sm-2 control-label">填票日期：</label>
                                <div  class="col-sm-2 input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> value="<fmt:formatDate value="${waybill.waybillFillDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" name="waybillFillDate" class="form-control pull-right" id="waybillFillDate">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label"> 备注：</label>
                                <textarea style="height:72px;width:680px" maxlength="255" <c:if test="${waybill.waybillStatus!=1}">disabled</c:if> name="waybillRemarks" placeholder="请输入备注">${waybill.waybillRemarks}</textarea>
                            </div>
                                <div class="box-footer">

                                    <div class="row" style="padding-left: 600px; padding-top: 10px">
                                        <a href="/item_add?waybillId=${waybill.waybillId}" type="button" class="btn bnt-sm btn-default"><i class="fa fa-plus"></i>编辑货物</a>&nbsp&nbsp&nbsp
                                        <%--<a href="/waybill_delete?waybillId=${waybill.waybillId}" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</a>&nbsp&nbsp&nbsp--%>
                                        <c:if test="${waybill.waybillStatus==1}"> <button id="waybill_delete" type="button" class="btn bnt-sm btn-default"><i class="fa fa-trash-o"></i>删除</button>&nbsp&nbsp&nbsp
                                        <button type="submit" class="btn bnt-sm btn-default"><i class="fa fa-edit"></i>修改</button>&nbsp&nbsp&nbsp</c:if>
                                        <a href="/waybill_select" type="button" class="btn bnt-sm btn-default" ><i class="fa fa-undo"></i>返回</a>&nbsp&nbsp&nbsp
                                        <c:if test="${waybill.waybillStatus==1}"> </div></c:if>
                                </div>
                        </form>
                            </div>
                        </form>
                    </div>
                </div>
        </section>
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
<sys:modal />
<script>

    $("#waybill_delete").bind("click",function () {
        $("#modal-message").html("确认删除当前货运单？");
        $("#modal-default").modal("show");
        $("#btnModalOk").bind("click", function () {
            $("#modal-default").modal("hide");
            $("#waybillForm").attr("action","/waybill_delete")
            $("#waybillForm").submit();

        });
    });


</script>
</body>
</html>