<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html>
<html>
<head>

    <title>AdminLTE 2 | Dashboard</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <link rel="stylesheet" href="/assets/bower_components/css/waybill_add.css">
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
                运输合同填写
                <small>Fill out a Transport contract</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li>运输合同填写</li>
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
                            <h3 class="box-title">运输合同填写</h3>
                        </div>


                        <form class="form-horizontal" action="/contract_save" method="post">
                            <div class="box-body col-sm-12">

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">合同编号：</label>
                                    <input type="text" name="contractId" readonly value="${contractId}" class="col-sm-2" placeholder="请输入编号">
                                    <label class="col-sm-2 control-label"> 承运人：</label>
                                    <select name="contractDriver" class="col-sm-2 select">
                                        <option selected value="0">请选择</option>
                                        <c:forEach items="${drivers}" var="driver">
                                            <option value="${driver.driverId}"<c:if test="${contract.contractDriver eq driver.driverId}">selected</c:if>>${driver.driverName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 车牌号：</label>
                                    <input type="text" name="contractCarnum" readonly class="col-sm-2"
                                           placeholder="请选择承运人" <c:if test="${contract.contractCarnum!=null}">value="${contract.contractCarnum}"</c:if>>
                                    <label class="col-sm-2 control-label"> 营运证：</label>
                                    <input type="text" name="contractOperationLicense" class="col-sm-2"
                                           placeholder="请输入编号" <c:if test="${contract.contractOperationLicense!=null}">value="${contract.contractOperationLicense}"</c:if>>

                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 驾驶证：</label>
                                    <input type="text" class="col-sm-2" readonly name="contractDriverLicense"
                                           placeholder="请选择承运人" <c:if test="${contract.contractDriverLicense!=null}">value="${contract.contractDriverLicense}"</c:if>>
                                    <label class="col-sm-2 control-label"> 行驶证：</label>
                                    <input type="text" name="contractDrivingLicense" readonly class="col-sm-2"
                                           placeholder="请选择承运人" <c:if test="${contract.contractDrivingLicense!=null}">value="${contract.contractDrivingLicense}"</c:if>>

                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 发货地：</label>
                                    <input type="text" name="contractBegin" class="col-sm-2"
                                           placeholder="起始地点" <c:if test="${contract.contractBegin!=null}">value="${contract.contractBegin}"</c:if>>
                                    <label class="col-sm-2 control-label"> 起运时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" <c:if test="${contract.contractBeginDate==null}">value="<fmt:formatDate value="${localDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" </c:if> <c:if test="${contract.contractBeginDate!=null}">value="<fmt:formatDate value="${contract.contractBeginDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"</c:if>name="contractBeginDate" class="form-control pull-right" id="contractBeginDate">
                                    </div>


                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label"> 交货地：</label>
                                    <input type="text" name="contractEnd" class="col-sm-2"
                                           placeholder="请输入号码" <c:if test="${contract.contractEnd!=null}">value="${contract.contractEnd}"</c:if>>
                                    <label class="col-sm-2 control-label"> 到达时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" <c:if test="${contract.contractEndDate==null}">value="<fmt:formatDate value="${localDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" </c:if> <c:if test="${contract.contractEndDate!=null}">value="<fmt:formatDate value="${contract.contractEndDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"</c:if> name="contractEndDate" class="form-control pull-right" id="contractEndDate">
                                    </div>


                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 收货联系人：</label>
                                    <input type="text" name="contractRecive" class="col-sm-2"
                                           placeholder="请输入名字" <c:if test="${contract.contractRecive!=null}">value="${contract.contractRecive}"</c:if>>
                                    <label class="col-sm-2 control-label"> 联系人手机：</label>
                                    <input type="text" name="contractRecivePhone" class="col-sm-2"
                                           placeholder="请输入号码" <c:if test="${contract.contractRecivePhone!=null}">value="${contract.contractRecivePhone}"</c:if>>

                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 收货详细地址：</label>
                                    <input type="text" name="contractReciveAddress" class="col-sm-6"
                                           placeholder="请输入地址" <c:if test="${contract.contractReciveAddress!=null}">value="${contract.contractReciveAddress}"</c:if>>
                                </div>

                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 承运人订装货物保证金：</label>
                                    <input type="text" name="contractBond" class="col-sm-2"
                                           placeholder="请输入金额" <c:if test="${contract.contractBond!=null}">value="${contract.contractBond}"</c:if>>
                                    <label class="col-sm-2 control-label"> 配车服务费：</label>
                                    <input type="text" name="contractService" class="col-sm-2"
                                           placeholder="请输入金额" <c:if test="${contract.contractService!=null}">value="${contract.contractService}"</c:if>>

                                </div>

                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 运费结算方式：</label>
                                    <select name="contractPayType" class="col-sm-2 select">
                                        <option value="0" selected <c:if test="${contract.contractPayType==0}">selected</c:if>>请选择</option>
                                        <option value="1" <c:if test="${contract.contractPayType==1}">selected</c:if>>到货</option>
                                        <option value="2" <c:if test="${contract.contractPayType==2}">selected</c:if>>回结</option>
                                        <option value="3" <c:if test="${contract.contractPayType==3}">selected</c:if>>现付</option>
                                    </select>
                                    <label class="col-sm-2 control-label"> 送货单回执押金：</label>
                                    <input type="text" name="contractDeposit" class="col-sm-2"
                                           placeholder="请输入金额" <c:if test="${contract.contractDeposit!=null}">value="${contract.contractDeposit}"</c:if>>

                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 运费计价方式：</label>
                                    <select name="contractMoneyType" class="col-sm-2 select">
                                        <option value="0" selected<c:if test="${contract.contractMoneyType==0}">selected</c:if>>请选择</option>
                                        <option value="1" <c:if test="${contract.contractMoneyType==1}">selected</c:if>>重量</option>
                                        <option value="2" <c:if test="${contract.contractMoneyType==2}">selected</c:if>>体积</option>
                                    </select>


                                </div>


                                <div class="form-group">
                                    <label class="col-sm-2 control-label">运费：</label>
                                    <input type="text" name="contractMoney" class="col-sm-2" placeholder="请输入金额" <c:if test="${contract.contractMoney!=null}">value="${contract.contractMoney}"</c:if>>
                                    <label class="col-sm-2 control-label">保险费：</label>
                                    <input type="text" name="contractInsurance" class="col-sm-2" placeholder="请输入金额" <c:if test="${contract.contractInsurance!=null}">value="${contract.contractInsurance}"</c:if>>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">预付费用：</label>
                                    <input type="text" name="contractPrepay" class="col-sm-2" placeholder="请输入金额"  <c:if test="${contract.contractPrepay!=null}">value="${contract.contractPrepay}"</c:if>>
                                    <label class="col-sm-2 control-label">签订时间：</label>
                                    <div  class="col-sm-2 input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" <c:if test="${contract.contractDate==null}">value="<fmt:formatDate value="${localDate}" pattern="yyyy-MM-dd"></fmt:formatDate>" </c:if> <c:if test="${contract.contractDate!=null}">value="<fmt:formatDate value="${contract.contractDate}" pattern="yyyy-MM-dd"></fmt:formatDate>"</c:if> name="contractDate" class="form-control pull-right" id="contractDate">
                                    </div>
                                </div>

                                </div>


                                <div class="form-group">

                                    <label class="col-sm-2 control-label"> 备注：</label>
                                    <textarea style="height:72px;width:680px" maxlength="255" name="contractRemarks" placeholder="请输入备注" ><c:if test="${contract.contractRemarks!=null}">${contract.contractRemarks}</c:if></textarea>

                                </div>

                                <div class="box-footer">
                                    <a href="/contract_select" type="button" class="btn bnt-sm btn-default" ><i class="fa fa-undo"></i>返回</a>
                                    <button type="submit" class="btn btn-info pull-right">提交</button>

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


<script>
    $(function () {

        $("select[name='contractDriver']").change(function () {
            var contractDriver = $("select[name='contractDriver']").val();
            $.ajax({
                url:"/driver_change",
                type:"POST",
                data:"contractDriver="+contractDriver,
                dataType:"json",
                success:function (data) {
                    $("input[name='contractCarnum']").val(data.driverCarnum);
                    $("input[name='contractDriverLicense']").val(data.driverLicense);
                    $("input[name='contractDrivingLicense']").val(data.drivingLicense);
                }
            });
        });

    })
</script>
</body>
</html>