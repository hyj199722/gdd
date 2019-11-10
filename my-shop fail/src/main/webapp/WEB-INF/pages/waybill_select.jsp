<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

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
                            <form class="form-horizontal" action="/waybill_search" method="get">
                                <div class="box-body col-sm-12 page">

                                    <div class="form-group">
                                    <label class="col-sm-2 control-label">货运单号：</label>
                                    <input type="text" name="waybillId" class="col-sm-2" placeholder="请输入编号">
                                        <label class="col-sm-2 control-label">发货客户：</label>
                                        <input type="text" name="waybillSend" class="col-sm-2" value="${waybill.waybillSend}" placeholder="请输入客户">
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">收货客户：</label>
                                        <input type="text" name="waybillRecive" class="col-sm-2" placeholder="请输入客户">
                                        <label class="col-sm-2 control-label">托运时间：</label>
                                        <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-clock-o"></i>
                                        </div>
                                        <input style="width: 200px" name="timeRange" type="text" class="form-control pull-left" id="reservation">
                                    </div>

                                    </div>

                                    <div class="form-group">

                                        <label class="col-sm-2 control-label">起点站：</label>
                                        <input type="text"  name="waybillBegin" class=" col-sm-2 " placeholder="请输入起点站">
                                        <label class="col-sm-2 control-label">终点站：</label>
                                        <input type="text"  name="waybillEnd" class=" col-sm-2 " placeholder="请输入终点站">
                                    </div>

                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">状态：</label>
                                        <select name="waybillStatus" class="col-sm-2 select">
                                            <option selected value="0">请选择</option>
                                            <option value="1">未发货</option>
                                            <option value="2">已发货</option>
                                            <option value="3">已送达</option>
                                            <option value="4">已提货</option>
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
                                <c:forEach items="${pageInfo.list}" var="waybill">
                                    <tr>
                                        <td> <a href="/waybill_edit?waybillId=${waybill.waybillId}" >${waybill.waybillId}</a></td>
                                        <td>${waybill.waybillBegin}</td>
                                        <td>${waybill.waybillEnd}</td>
                                        <td><fmt:formatDate value="${waybill.waybillDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                                        <td>${waybill.waybillRecive}</td>
                                        <td>${waybill.waybillRecivePhone}</td>
                                        <td><c:if test="${waybill.waybillStatus==1}">未发货</c:if>
                                            <c:if test="${waybill.waybillStatus==2}">已发货</c:if>
                                            <c:if test="${waybill.waybillStatus==3}">已送达</c:if>
                                            <c:if test="${waybill.waybillStatus==4}">已提货</c:if></td>
                                    </tr>
                                </c:forEach>

                                </tbody>


                            </table>
                        </div>
                            <%--分页文字信息--%>
                                <div class="row" >
                                    <%--分页文字信息--%>
                                    <div class="col-md-6">
                                        当前第${pageInfo.pageNum}页，总${pageInfo.pages}页，总共${pageInfo.total}条记录
                                    </div>
                                    <%--分页条信息--%>
                                    <div class="col-md-6" style="padding-left: 150px">
                                        <nav aria-label="Page navigation">
                                            <ul class="pagination">
                                                <li><a href="/waybill_search?pn=1&waybillId=${waybillId}&waybillSend=${waybillSend}&waybillRecive=${waybillRecive}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&timeRange=${timeRange}&waybillStatus="${waybillStatus}">首页</a> </li>
                                                <%--如果有上一页，则可以通过减一操作移动，且有<符号&laquo，否则连点<的符号也没有，也就不能移动上一页--%>
                                                <c:if test="${pageInfo.hasPreviousPage}">
                                                    <li>
                                                        <a href="/waybill_search?pn=${pageInfo.pageNum-1}&waybillId=${waybillId}&waybillSend=${waybillSend}&waybillRecive=${waybillRecive}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&timeRange=${timeRange}&waybillStatus="${waybillStatus}" aria-label="Previous">
                                                            <span aria-hidden="true">&laquo;</span>
                                                        </a>
                                                    </li>
                                                </c:if>


                                                <%--如果是当前页，则显示高亮--%>
                                                <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                                                    <c:if test="${page_Num==pageInfo.pageNum}">
                                                        <li class="active"><a href="#">${page_Num}</a></li>
                                                    </c:if>
                                                    <c:if test="${page_Num!=pageInfo.pageNum}">
                                                        <li><a href="/waybill_search?pn=${page_Num}&waybillId=${waybillId}&waybillSend=${waybillSend}&waybillRecive=${waybillRecive}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&timeRange=${timeRange}&waybillStatus="${waybillStatus}">${page_Num}</a></li>
                                                    </c:if>

                                                </c:forEach>
                                                <c:if test="${pageInfo.hasNextPage}">
                                                    <li>
                                                        <a href="/waybill_search?pn=${pageInfo.pageNum+1}&waybillId=${waybillId}&waybillSend=${waybillSend}&waybillRecive=${waybillRecive}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&timeRange=${timeRange}&waybillStatus="${waybillStatus}" aria-label="Next">
                                                            <span aria-hidden="true">&raquo;</span>
                                                        </a>
                                                    </li>
                                                </c:if>

                                                <li><a href="/waybill_search?pn=${pageInfo.pages}&waybillId=${waybillId}&waybillSend=${waybill.waybillSend}&waybillRecive=${waybillRecive}&waybillBegin=${waybillBegin}&waybillEnd=${waybillEnd}&timeRange=${timeRange}&waybillStatus="${waybillStatus}">末页</a> </li>
                                                <form style="float: left" action="/waybill_search">
                                                    <input type="text" name="pn" style="height:33px;width: 50px">
                                                    <input hidden type="text" name="waybillId" value="${waybillId}" style="height:33px;width: 50px">
                                                    <input hidden type="text" name="waybillSend" value="${waybillSend}" style="height:33px;width: 50px">
                                                    <input hidden type="text" name="waybillRecive" value="${waybillRecive}" style="height:33px;width: 50px">
                                                    <input hidden type="text" name="waybillBegin" value="${waybillBegin}" style="height:33px;width: 50px">
                                                    <input hidden type="text" name="waybillEnd" value="${waybillEnd}" style="height:33px;width: 50px">
                                                    <input hidden type="text" name="timeRange" value="${timeRange}" style="height:33px;width: 50px">
                                                    <input hidden type="text" name="waybillStatus" value="${waybillStatus}" style="height:33px;width: 50px">
                                                    <input type="submit" value="跳转" class="btn btn-primary">
                                                </form>


                                            </ul>
                                        </nav>
                                    </div>

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
<script>
    $(function () {



        //Date range picker
        $('#reservation').daterangepicker()
        //Date range picker with time picker
        $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' })
        //Date range as a button
        $('#daterange-btn').daterangepicker(
            {
                ranges   : {
                    'Today'       : [moment(), moment()],
                    'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
                    'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                    'This Month'  : [moment().startOf('month'), moment().endOf('month')],
                    'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                },
                startDate: moment().subtract(29, 'days'),
                endDate  : moment()
            },
            function (start, end) {
                $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
            }
        )

        //Date picker
        $('#datepicker').datepicker({
            autoclose: true
        })







        //Timepicker
        $('.timepicker').timepicker({
            showInputs: false
        })
    })
</script>
</body>
</html>